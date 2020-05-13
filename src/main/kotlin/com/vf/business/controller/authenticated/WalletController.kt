package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.payments.*
import com.vf.business.business.service.itf.internal.ProfessorService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.WalletService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/wallet")
class WalletController(
    val walletService: WalletService,
    val userService: UsersService
) {

    @Secured
    @PostMapping("/me/transactions")
    fun getTransactions(@RequestParam("page") page: Int, @RequestParam("size") size: Int, principal: Principal)
            : ResourcePage<TransactionDTO> {
        val user = userService.getUser(principal)
        return walletService.getTransactions(user, page, size)
    }

    /**
     * Gets the available payment methods for a given professor
     */
    @Secured
    @GetMapping("/me/payment-methods")
    fun getPaymentMethods(principal: Principal): ResourcePage<PaymentMethodDTO> {
        val professor = userService.getUser(principal) as Professor
        return walletService.getPaymentMethods(professor);
    }

    /**
     * Creates a new payment method
     */
    @Secured
    @PostMapping("/me/payment-methods")
    fun createPaymentMethod(principal: Principal, @RequestBody dto: CreatePaymentMethodDTO): CreateOperationResponseDTO {
        val professor = userService.getUser(principal) as Professor
        return walletService.createPaymentMethod(professor, dto)
    }

    /**
     * Sets a given the default one
     */
    @Secured
    @PostMapping("/me/payment-methods/{id}/make-default")
    fun setPaymentMethodAsDefault(principal: Principal, @PathVariable("id") id: Int){
        val professor = userService.getUser(principal) as Professor
        return walletService.makePaymentMethodDefault(professor, id)
    }

    /**
     * Deletes a given Payment Method
     */
    @Secured
    @DeleteMapping("/me/payment-methods/{id}")
    fun deletePaymentMethod(principal: Principal, @PathVariable("id") id: Int) {
        val professor = userService.getUser(principal) as Professor
        return walletService.deletePaymentMethod(professor, id)
    }

    @Secured
    @GetMapping("/currencies")
    fun getCurrencies(): ResourcePage<CurrencyDTO> {
        return walletService.getCurrencies()
    }

    @Secured
    @GetMapping("/me/currency")
    fun getUserCurrency(principal: Principal): CurrencyDTO {
        val professor = userService.getUser(principal) as Professor
        return walletService.getUserCurrency(professor)
    }

    @Secured
    @PutMapping("/me/currency")
    fun updateUserCurrency(principal: Principal, @RequestBody dto: UpdateCurrencyDTO) {
        val user = userService.getUser(principal)
        walletService.updateUserCurrency(user, dto)
    }

}