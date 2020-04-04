package com.vf.business.business.service.impl

import com.vf.business.business.dao.repo.CategoryRepository
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.CategoryService
import com.vf.business.business.utils.CategoryMapper
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(val categoryRepo: CategoryRepository): CategoryService {

    override fun getAllCategories(): Collection<CategoryDTO> {
        val categories = categoryRepo.findAll();
        val result = arrayListOf<CategoryDTO>()
        categories.forEach {
            it?.let {
                result.add(CategoryMapper.Mapper.map(it)!!)
            }
        }
        return result;
    }

    override fun getById(id: Int): CategoryDTO {
        val catOpt = categoryRepo.findById(id)
        catOpt.orElseThrow {
            throw ResourceNotFoundException();
        }
        return CategoryMapper.Mapper.map(catOpt.get())
    }

}