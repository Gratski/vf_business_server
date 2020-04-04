package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Int> {
}