package com.vf.business.dao.models

import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        open var id: Int?,
        @Column(name = "first_name")
        open var firstName: String?,
        @Column(name = "last_name")
        open var lastName: String?,
        @Column(name = "email")
        open var email: String?,
        @Column(name = "pwd")
        open var password: String?,
        @Column(name = "active")
        open var active: Boolean? = false,
        @Column(name = "enabled")
        open var enabled: Boolean? = true,
        @Column(name = "created_at")
        open var createdAt: Date?,
        @Column(name = "updated_at")
        open var updatedAt: Date?)