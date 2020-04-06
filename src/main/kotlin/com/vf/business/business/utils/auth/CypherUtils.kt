package com.vf.business.business.utils.auth

import java.security.NoSuchAlgorithmException
import java.security.spec.InvalidKeySpecException
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec


class CypherUtils {

    val ALGORITHM = "PBKDF2WithHmacSHA512"
    val KEY_LENGTH = 512
    val ITERATIONS = 65536

    object Instance {

        fun hashPassword(password: String, salt: String): String? {
            val chars = password.toCharArray()
            val bytes = salt.toByteArray()
            val spec = PBEKeySpec(chars, bytes, 65536, 512)
            Arrays.fill(chars, Character.MIN_VALUE)

            return try {

                val fac = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                val securePassword = fac.generateSecret(spec).encoded
                Base64.getEncoder().encodeToString(securePassword)

            } catch (ex: NoSuchAlgorithmException) {
                throw VFCypherException()
            } catch (ex: InvalidKeySpecException) {
                throw VFCypherException()
            } finally {
                spec.clearPassword()
            }
        }

    }

}