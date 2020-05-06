package com.vf.business.business.service.impl.external.storage

import com.amazonaws.AmazonServiceException
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.DeleteObjectRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.vf.business.business.dto.storage.StoreFileResponse
import com.vf.business.business.exception.CriticalSystemException
import com.vf.business.business.exception.ExternalOperationException
import com.vf.business.business.service.itf.internal.StorageService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
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
    val PROFILE_PICTURES_KEY = "users/dynamic/pictures/"
    val INVOICES_KEY = "users/dynamic/invoices/"
    val DEFAULT_FILE_ACL_KEY = "x-amz-acl"
    val DEFAULT_FILE_ACL_VALUE = "public-read"

    override fun storePicture(file: MultipartFile): StoreFileResponse {

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

            StoreFileResponse("$BASE_AWS_URL$fileKey")

        } catch (e: AmazonServiceException) {
            throw ExternalOperationException("Could not insert the given file")
        }

    }

    override fun storeProfilePicture(file: MultipartFile): StoreFileResponse {

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

            val fileKey = "$PROFILE_PICTURES_KEY$ufid.$fileExtension"
            val result = s3.putObject(BUCKET_NAME, fileKey, file.inputStream,  metadata);

            StoreFileResponse("$BASE_AWS_URL$fileKey")

        } catch (e: AmazonServiceException) {
            throw ExternalOperationException("Could not insert the given file")
        }

    }

    override fun removePicture(pictureUrl: String?) {
        if ( pictureUrl== null ) return;
        val s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.EU_WEST_2)
                .build()

        return try {
            val tokens = pictureUrl.split(BASE_AWS_URL)
            if(tokens.size < 2) {
                throw CriticalSystemException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf("AWS Picture")))
            }
            val result = s3.deleteObject(DeleteObjectRequest(BUCKET_NAME, tokens[1]))
        } catch (e: AmazonServiceException) {
            throw ExternalOperationException("Could not remove the given file")
        } catch (e: Exception) {
            throw ExternalOperationException("Could not remove the given file")
        }
    }

    override fun storeInvoice(file: MultipartFile): StoreFileResponse {
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

            val fileKey = "$INVOICES_KEY$ufid.$fileExtension"
            val result = s3.putObject(BUCKET_NAME, fileKey, file.inputStream,  metadata);

            StoreFileResponse("$BASE_AWS_URL$fileKey")

        } catch (e: AmazonServiceException) {
            throw ExternalOperationException("Could not insert the given file")
        }
    }

}