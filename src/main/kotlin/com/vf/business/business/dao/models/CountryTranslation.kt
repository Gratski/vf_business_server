package com.vf.business.business.dao.models

import javax.persistence.*

@Entity
@Table(name = "country_translations")
class CountryTranslation (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        open var id: Int?,

        @ManyToOne
        @JoinColumn(name = "country_id")
        open var country: Country,

        @ManyToOne
        @JoinColumn(name = "language_id")
        open var language: Language,

        @Column(name = "language_code")
        open var languageCode: String,

        @Column(name = "designation")
        open var designation: String
)