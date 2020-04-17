package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.repo.CommissionRepository
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.CommissionService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.stereotype.Service

@Service
class CommissionServiceImpl(
        val commissionRepo: CommissionRepository
): CommissionService {

    override fun getCommissionValueByAttendants(attendantsNumber: Int): Double {
        val commissionOpt = commissionRepo.findCommissionByAttendantsQuantity(attendantsNumber)
        commissionOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE,
                    arrayOf(Translator.toLocale(MessageCodes.COMMISSION)))
            )
        }

        val commission = commissionOpt.get()
        return commission.amount
    }
}