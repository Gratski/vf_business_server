package com.vf.business.business.service.itf

import com.vf.business.business.dto.storage.StorePictureResponse
import org.springframework.web.multipart.MultipartFile

interface StorageService {

    fun storePicture(file: MultipartFile): StorePictureResponse

}