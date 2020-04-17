package com.vf.business.controller.authenticated

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.payments.TransactionDTO
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.WalletService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/wallet")
class WalletController(
    val walletService: WalletService,
    val userService: UsersService
) {

    @Secured
    @PostMapping("me/transactions")
    fun getTransactions(@RequestParam("page") page: Int, @RequestParam("size") size: Int, principal: Principal)
            : ResourcePage<TransactionDTO> {
        val user = userService.getUser(principal)
        return walletService.getTransactions(user, page, size)
    }

}