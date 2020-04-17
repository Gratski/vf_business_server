package com.vf.business.business.service.itf.internal

interface CommissionService {

    fun getCommissionValueByAttendants(attendantsNumber: Int): Double

}