package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Category
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    lateinit var categoryRepo: CategoryRepository

    private val ICON = "ICON"
    private val DESIGNATION = "designation"
    private val DESCRIPTION = "description"
    private val CREATED_AT = Date()
    private val UPDATED_AT = Date()

    private val ICON_SUB = "ICON_sub"
    private val DESIGNATION_SUB = "designation_sub"
    private val DESCRIPTION_SUB = "description_sub"
    private val CREATED_AT_SUB = Date()
    private val UPDATED_AT_SUB = Date()

    private fun prepareCategory(): Category =
            prepareCategory(ICON, DESIGNATION, DESCRIPTION, CREATED_AT, UPDATED_AT)

    private fun prepareCategory(icon: String, designation: String, description: String,
                                createdAt: Date, updatedAt: Date) =
            Category(
                    id = null,
                    icon = icon,
                    designation = designation,
                    description = description,
                    createdAt = createdAt,
                    updatedAt = updatedAt
            )

    @Test
    @Transactional
    fun createNewCategoryTest() {

        // given
        val now = Date()
        val category = prepareCategory()

        // when
        categoryRepo.save(category)
        val fetchedCategoryOpt = categoryRepo.findById(category.id!!)

        // then
        Assert.assertTrue(fetchedCategoryOpt.isPresent)

        val fetchedCategory = fetchedCategoryOpt.get()
        Assert.assertEquals(ICON, fetchedCategory.icon)
        Assert.assertEquals(DESIGNATION, fetchedCategory.designation)
        Assert.assertEquals(DESCRIPTION, fetchedCategory.description)
    }

    @Test
    @Transactional
    fun createNewCategoryWithSubCategoriesTest() {

        // given
        val now = Date()
        val category = prepareCategory()
        category.subCategories = mutableListOf<Category>()
        // when

        // create parent
        categoryRepo.save(category)
        categoryRepo.findById(category.id!!).get()
        var fetchedCategory = categoryRepo.findById(category.id!!).get()

        // create child and associates it with parent
        val childCategory = prepareCategory(ICON_SUB, DESIGNATION_SUB, DESCRIPTION_SUB,
                        CREATED_AT_SUB, UPDATED_AT_SUB)
        childCategory.parent = category
        categoryRepo.save(childCategory)

        fetchedCategory.subCategories?.add(childCategory)
        categoryRepo.save(fetchedCategory)

        // then
        val fetchedSubCategory = categoryRepo.findById(childCategory.id!!).get()
        Assert.assertEquals(fetchedSubCategory.parent?.id, category.id)

        fetchedCategory = categoryRepo.findById(category.id!!).get()
        Assert.assertEquals(fetchedCategory.subCategories?.size, 1)

    }

}