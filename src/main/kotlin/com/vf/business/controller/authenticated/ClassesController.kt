package com.vf.business.controller.authenticated

import com.vf.business.business.dto.classes.VFClassDTO
import com.vf.business.business.service.itf.ClassesService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.version}/classes")
class ClassesController(
        val classesService: ClassesService
) {

    /**
     * Gets a collection of active classes
     */
    @GetMapping("/active")
    fun getActiveClasses(@RequestParam("page") page: Int,
                         @RequestParam("size") size: Int): Page<VFClassDTO> =
            classesService.getActiveClasses(page, size)


}