package com.vf.business.business.service.impl.aws

import com.vf.business.business.service.itf.StorageService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class AWSStorageServiceImpl : StorageService {

    override fun storePicture(file: MultipartFile) {
        TODO("Not yet implemented")
    }

}