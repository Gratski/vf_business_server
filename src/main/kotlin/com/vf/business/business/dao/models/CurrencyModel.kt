package com.vf.business.business.dao.models

import javax.persistence.*

@Entity
@Table(name = "currency")
class CurrencyModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int?,

    @Column(name = "designation")
    open var designation: String,

    @Column(name = "symbol")
    open var symbol: String
)