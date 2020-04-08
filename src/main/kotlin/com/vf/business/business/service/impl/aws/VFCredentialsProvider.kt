package com.vf.business.business.service.aws

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials

class VFCredentialsProvider : AWSCredentialsProvider {

    override fun getCredentials(): AWSCredentials =
            BasicAWSCredentials(
                    "AKIASNRGKNAAXL74MV4S",
                    "yPaLnKb571SzKAxICnji8RCSg4esniJfzv/1ypmQ")

    override fun refresh() {}

}