package com.vf.business.business.dto

data class ResourcePage<T>(
    val items:MutableList<T>,
    val total: Long
)