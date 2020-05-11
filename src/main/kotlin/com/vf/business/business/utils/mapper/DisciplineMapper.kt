package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.CategoryTranslation
import com.vf.business.business.dao.models.Discipline
import com.vf.business.business.dto.discipline.DisciplineDTO

class DisciplineMapper {

    object Mapper {

        fun map(input: Discipline, ct: CategoryTranslation? = null, ctParent: CategoryTranslation? = null): DisciplineDTO =
                DisciplineDTO(
                        id = input.id,
                        rate = input.reviewsScore ?: 0.0,
                        languageId = input.languageContext.language.id!!,
                        languageCode = input.languageContext.language.code,
                        category = CategoryMapper.Mapper.map(ct),
                        parentCategory = CategoryMapper.Mapper.map(ctParent),
                        professor = ProfessorMapper.Mapper.map(input.languageContext?.professor),
                        designation = input.designation!!,
                        description = input.description!!,
                        duration = input.duration,
                        equipment = input.equipment,
                        goals = input.goal,
                        difficultyLevel = input.difficultyLevel,
                        calories = input.calories,
                        imageUrl = input.imageUrl,
                        updatedAt = input.createdAt,
                        createdAt = input.createdAt,
                        enabled = input.enabled!!,
                        status = input.status,
                        isActive = input.active!!,
                        instructorId = input.languageContext.professor.id!!,
                        instructorName = "${input.languageContext.professor.firstName} ${input.languageContext.professor.lastName}",
                        instructorRate = 0.0,
                        instructorPictureUrl = input.languageContext.professor.pictureUrl
                )
    }

}