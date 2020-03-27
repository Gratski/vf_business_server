package dao.models

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor

data class UserModel @PersistenceConstructor constructor(@Id val id: String? = null, val name: String? = "Default Name")