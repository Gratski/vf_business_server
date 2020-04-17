package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "commision")
class Commission(
        id: Int? = null,

        @Column(name = "from_number")
        open var from: Int,
        @Column(name = "until_number")
        open var until: Int,
        @Column(name = "amount")
        open var amount: Double,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt){
}