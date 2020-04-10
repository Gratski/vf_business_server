package com.vf.business.config.i18n
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.stereotype.Component


@Component
class Translator(val messageSource: ResourceBundleMessageSource) {

    companion object {
        private var messageSource: ResourceBundleMessageSource? = null

        fun toLocale(msgCode: String): String {
            val locale = LocaleContextHolder.getLocale()
            return messageSource!!.getMessage(msgCode, null, locale)
        }

        fun toLocale(msgCode: String, args: Array<String>): String {
            val locale = LocaleContextHolder.getLocale()
            return messageSource!!.getMessage(msgCode, args, locale)
        }
    }

    init {
        Companion.messageSource = messageSource
    }
}