package com.vf.business.common.i18n

class MessageCodes {

    companion object {

        // COMMON ERRORS
        val INVALID_PERIOD_OF_DAY = "invalid_period_of_day"
        val MISSING_ARGUMENTS = "missing_arguments"
        val UNEXISTING_RESOURCE = "unexisting_resource" // expects %resource argument to correctly format
        val UNAUTHORIZED_OPERATION = "unauthorized_operation"
        val BAD_FORMAT = "bad_format" // expects %resource argument to correctly format
        val EMAIL_ALREADY_EXISTS = "email_already_exists"

        // COMMON TERMS
        val WEEK_DAY = "week_day"
        val USER = "user"
        val COUNTRY = "country"

        // NOTIFICATION PREFERENCES RELATED
        val NOTIFICATION_TYPE = "notification_type"
        // LANGUAGE CONTEXT RELATED
        val LANGUAGE = "language"
        val LANGUAGE_CONTEXT = "language_context"

        val LANGUAGE_CONTEXT_ALREADY_EXISTS = "language_context_already_exists"

        // PROFESSOR DETAILS RELATED
        val PROFESSOR_DETAILS = "professor_details"
        val NO_ACCESS_CODE_FOUND = "no_access_code_found"

        // CATEGORY RELATED
        val CATEGORY = "category"

        // DISCIPLINE RELATED
        val DISCIPLINE = "discipline"
        // CLASS RELATED
        val DISCIPLINE_CLASS = "discipline_class"
        val CLASS_IS_ALREADY_STARTED = "class_is_already_started"
        val CANNOT_JOIN_CLASS_IS_FULL = "cannot_join_class_is_full"

        val CLASS_CANNOT_BE_CANCELLED = "class_cannot_be_cancelled"
        // USER RELATED
        val USER_UNEXISTING_LIVING_IN = "user_unexisting_living_in"
        val USER_UNEXISTING_NATIONALITY = "user_unexisting_nationality"

        val USER_SPOKEN_LANGUAGES_EMPTY = "user_spoken_languages_empty"
        // STUDENT RELATED
        val STUDENT = "student"


    }

}