package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.discipline.classes.VFClassDTO
import com.vf.business.business.service.itf.internal.ClassesService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/classes")
class ClassesController(
        val classesService: ClassesService,
        val usersService: UsersService
) {

    /**
     * To start a class
     */
    @PostMapping("/{id}/start")
    fun startClass(principal: Principal, @PathVariable("id") classId: Int) {
        val professor = (usersService.getUser(principal) as Professor)
        classesService.startClass(professor, classId)
    }

    /**
     * To end a class
     */
    @PostMapping("/{id}/end")
    fun endClass(principal: Principal, @PathVariable("id") classId: Int) {
        val professor = (usersService.getUser(principal) as Professor)
        classesService.endClass(professor, classId)
    }

    /**
     * Mute all class attendants
     */
    @PostMapping("/{id}/mute")
    fun muteAll(principal: Principal, @PathVariable("id") classId: Int) {
        val professor = (usersService.getUser(principal) as Professor)
        classesService.muteAll(professor, classId)
    }

    /**
     * Unmute all class attendants
     */
    @PostMapping("/{id}/mute")
    fun unmuteAll(principal: Principal, @PathVariable("id") classId: Int) {
        val professor = (usersService.getUser(principal) as Professor)
        classesService.unmuteAll(professor, classId)
    }

    /**
     * Gets a collection of active classes
     */
    @GetMapping("/active")
    fun getActiveClasses(@RequestParam("page") page: Int,
                         @RequestParam("size") size: Int): Page<VFClassDTO> =
            classesService.getActiveClasses(page, size)


}