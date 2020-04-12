package com.vf.business.business.service.impl.external.storage

import com.amazonaws.AmazonServiceException
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.ObjectMetadata
import com.vf.business.business.dto.storage.StorePictureResponse
import com.vf.business.business.exception.ExternalOperationException
import com.vf.business.business.service.itf.internal.StorageService
import org.apache.commons.io.FilenameUtils
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class AWSStorageServiceImpl(
        val credentialsProvider: VFCredentialsProvider
) : StorageService {

    val BUCKET_NAME = "vfitbucket"
    val BASE_AWS_URL = "https://$BUCKET_NAME.s3.eu-west-2.amazonaws.com/"
    val DISCIPLINES_KEY = "users/dynamic/disciplines/main/"
    val DEFAULT_FILE_ACL_KEY = "x-amz-acl"
    val DEFAULT_FILE_ACL_VALUE = "public-read"

    override fun storePicture(file: MultipartFile): StorePictureResponse {

        val s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.EU_WEST_2)
                .build()

        return try {
            // prepare metadata
            val metadata = ObjectMetadata()
            metadata.contentLength = file.size
            metadata.setHeader(DEFAULT_FILE_ACL_KEY, DEFAULT_FILE_ACL_VALUE)

            // get the extension and generate Unique File ID UFID
            val fileExtension = FilenameUtils.getExtension(file.originalFilename)
            val ufid = UUID.randomUUID().toString().replace("-", "")

            val fileKey = "$DISCIPLINES_KEY$ufid.$fileExtension"
            val result = s3.putObject(BUCKET_NAME, fileKey, file.inputStream,  metadata);

            StorePictureResponse("$BASE_AWS_URL$fileKey")

        } catch (e: AmazonServiceException) {
            throw ExternalOperationException("Could not insert the given file")
        }

    }

}