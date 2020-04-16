package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.comms.invitation.InvitationInDTO
import com.vf.business.business.dto.comms.support.SupportContactInDTO
import com.vf.business.business.service.itf.internal.InvitationService
import com.vf.business.business.service.itf.internal.SupportService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/invitation")
class InvitationController(
        val userService: UsersService,
        val invitationService: InvitationService
) {

    /**
     * Sends an email to support team on behalf of a professor
     */
    @PostMapping("/professor")
    fun sendInvitationMessage(principal: Principal, @RequestBody dto: InvitationInDTO) {
        val professor = (userService.getUser(principal) as Professor)
        invitationService.sendInvitationMessage(professor, dto)
    }


}