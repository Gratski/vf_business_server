package com.vf.business.business.dao.models

import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class User (
        id: Int? = null,
        @Column(name = "first_name")
        open var firstName: String?,
        @Column(name = "last_name")
        open var lastName: String?,
        @Column(name = "email")
        open var email: String?,
        @Column(name = "pwd")
        open var password: String?,
        @ManyToOne
        @JoinColumn(name = "nationality")
        open var nationality: Country? = null,
        @ManyToOne
        @JoinColumn(name = "living_in")
        open var livingIn: Country? = null,

        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
        open var spokenLanguages: MutableList<UserLanguage>,

        @Column(name = "fcm_token")
        open var fcmToken: String? = null,
        @Column(name = "picture_url")
        open var pictureUrl: String?= null,
        @Column(name = "active")
        open var active: Boolean? = false,
        @Column(name = "enabled")
        open var enabled: Boolean? = true,

        createdAt: Date?,
        updatedAt: Date?) : AbstractEntity(id, createdAt, updatedAt)