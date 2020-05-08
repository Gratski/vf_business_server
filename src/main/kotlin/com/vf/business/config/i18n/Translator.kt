package com.vf.business.config.i18n
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.stereotype.Component
import java.util.*


@Component
class Translator(val messageSource: ResourceBundleMessageSource) {

    companion object {
        val SPLIT_GENERAL_REGEX = "_"
        val SPLIT_SPECIFIC_REGEX = "_#"

        private var messageSource: ResourceBundleMessageSource? = null

        fun toLocale(msgCode: String): String {
            val locale = LocaleContextHolder.getLocale()
            return messageSource!!.getMessage(msgCode, null, locale)
        }

        fun toLocale(msgCode: String, args: Array<String>): String {
            val locale = LocaleContextHolder.getLocale()
            return messageSource!!.getMessage(msgCode, args, locale)
        }

        // TODO: Add unit tests to this method
        fun getContextLocaleLanguageCode(locale: Locale): String {
            val languageTag = locale.toLanguageTag()
            var tokens = languageTag.split(SPLIT_SPECIFIC_REGEX)[0]
            val spliced = tokens.split(SPLIT_GENERAL_REGEX)
            return standardizeLanguageCode(spliced[spliced.size - 1])
        }

        private fun standardizeLanguageCode(rawLanguageCode: String?): String {
            if(rawLanguageCode == null) return ""
            return rawLanguageCode.toLowerCase()
        }

    }

    init {
        Companion.messageSource = messageSource
    }
}