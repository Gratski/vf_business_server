package com.vf.business.business.dao.models

import com.vf.business.business.dao.models.wallet.Wallet
import com.vf.business.business.dto.user.Gender
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class User (
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "referred_by")
        open var referredBy: User? = null,

        @OneToMany(mappedBy = "referredBy")
        open var referrals: MutableList<User>? = mutableListOf(),

        @OneToOne(mappedBy = "belongsTo")
        open var wallet: Wallet? = null,

        @OneToMany(mappedBy = "user")
        open var conversations: MutableList<ConversationCorrespondent>? = null,

        @Column(name = "first_name")
        open var firstName: String?,
        @Column(name = "last_name")
        open var lastName: String?,
        @Column(name = "email")
        open var email: String?,
        @Column(name = "pwd")
        open var password: String?,

        @Column(name = "gender")
        @Enumerated(EnumType.STRING)
        open var gender: Gender,

        @Column(name = "birthday")
        open var birthday: Date,

        @ManyToOne
        @JoinColumn(name = "phone_number_country")
        open var phoneNumberCountry: Country,

        @Column(name = "phone_number")
        open var phoneNumber: String? = null,

        @ManyToOne
        @JoinColumn(name = "nationality")
        open var nationality: Country? = null,
        @ManyToOne
        @JoinColumn(name = "living_in")
        open var livingIn: Country? = null,

        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
        open var spokenLanguages: MutableList<UserLanguage>,

        @OneToMany(mappedBy = "user")
        open var notificationPreferences: MutableList<NotificationPreference>,

        @Column(name = "fcm_token")
        open var fcmToken: String? = null,

        @Column(name = "pwd_token")
        open var pwdToken: String? = null,

        @Column(name = "picture_url")
        open var pictureUrl: String?= null,
        @Column(name = "active")
        open var active: Boolean? = false,
        @Column(name = "enabled")
        open var enabled: Boolean? = true,

        createdAt: Date,
        updatedAt: Date) : AbstractEntity(id, createdAt, updatedAt)