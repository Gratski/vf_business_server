package service.impl

import dto.ElasticStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import service.itf.IElasticService


@Service
class ElasticServiceImpl : IElasticService {
    override fun getElasticStatus(): ElasticStatus {

        val restTemplate = RestTemplate()
        val fooResourceUrl = "http://localhost:9200/"
        val response = restTemplate.getForEntity("$fooResourceUrl", ElasticStatus::class.java)
        println(response)
        return response.body!!;
    }
}