package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.comms.support.SupportContactInDTO
import com.vf.business.business.service.itf.internal.SupportService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/support")
class SupportController(
        val userService: UsersService,
        val supportService: SupportService
) {

    /**
     * Sends an email to support team on behalf of a professor
     */
    @Secured
    @PostMapping("/professor")
    fun sendSupportMessage(principal: Principal, @RequestBody dto: SupportContactInDTO) {
        val professor = (userService.getUser(principal) as Professor)
        supportService.sendSupportMessage(professor, dto)
    }


}