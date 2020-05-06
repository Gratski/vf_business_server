package com.vf.business.business.service.itf.internal

import com.vf.business.business.dto.storage.StoreFileResponse
import org.springframework.web.multipart.MultipartFile

interface StorageService {

    fun storePicture(file: MultipartFile): StoreFileResponse

    fun removePicture(pictureUrl: String?)

    fun storeInvoice(file: MultipartFile): StoreFileResponse

    fun storeProfilePicture(file: MultipartFile): StoreFileResponse
}