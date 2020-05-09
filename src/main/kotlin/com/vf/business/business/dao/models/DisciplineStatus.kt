package com.vf.business.business.dao.models

enum class DisciplineStatus(val status: Int) {
    WAITING_FOR_APPROVAL(1), APPROVED(2), REJECTED(3), REPORTED(4);
}