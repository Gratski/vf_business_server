package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractLongEntity (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        open var id: Long?,
        open var createdAt: Date,
        open var updatedAt: Date
)