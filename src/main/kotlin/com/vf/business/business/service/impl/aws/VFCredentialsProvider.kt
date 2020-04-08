package com.vf.business.business.service.impl.aws

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import org.springframework.stereotype.Component

@Component
class VFCredentialsProvider : AWSCredentialsProvider {

    override fun getCredentials(): AWSCredentials =
            BasicAWSCredentials(
                    "AKIASNRGKNAAXL74MV4S",
                    "yPaLnKb571SzKAxICnji8RCSg4esniJfzv/1ypmQ")

    override fun refresh() {}

}