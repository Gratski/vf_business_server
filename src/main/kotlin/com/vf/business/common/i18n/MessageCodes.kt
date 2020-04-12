package com.vf.business.common.i18n

class MessageCodes {

    companion object {

        val INVALID_PERIOD_OF_DAY = "invalid_period_of_day"
        val MISSING_ARGUMENTS = "missing_arguments"
        val UNEXISTING_RESOURCE = "unexisting_resource" // expects %resource argument to correctly format
        val UNAUTHORIZED_OPERATION = "unauthorized_operation"
        val BAD_FORMAT = "bad_format" // expects %resource argument to correctly format
        val DISCIPLINE_SLOT_CONFLICT = "discipline_slot_conflict"

        // CLASS RELATED MESSAGES
        val CLASS_IS_ALREADY_STARTED = "class_is_already_started"

        val CATEGORY = "category"
        val DISCIPLINE = "discipline"
        val STUDENT = "student"
        val DISCIPLINE_CLASS = "discipline_class"
        val WEEK_DAY = "week_day"

    }

}