package service.itf

import dto.ElasticStatus

interface IElasticService {
    fun getElasticStatus(): ElasticStatus
}