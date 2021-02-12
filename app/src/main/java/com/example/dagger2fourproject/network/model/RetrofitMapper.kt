package com.example.dagger2fourproject.network.model

import com.example.dagger2fourproject.domain.model.Model
import com.example.dagger2fourproject.util.Mapper

class RetrofitMapper : Mapper<RetrofitModel, Model> {
    override fun mapToDomainModel(entity: RetrofitModel): Model {
        return Model(
            pk = entity.pk,
            title = entity.title,
            publisher = entity.publisher,
            featured_image = entity.featuredImage,
            rating = entity.rating,
            source_url = entity.sourceUrl,
            description = entity.description,
            cooking_instructions = entity.cookingInstructions,
            ingredients = entity.ingredients,
            date_added = entity.dateAdded,
            date_updated = entity.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: Model): RetrofitModel {
        return RetrofitModel(
            pk = domainModel.pk,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featuredImage = domainModel.featured_image,
            rating = domainModel.rating,
            sourceUrl = domainModel.source_url,
            description = domainModel.description,
            cookingInstructions = domainModel.cooking_instructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.date_added,
            dateUpdated = domainModel.date_updated

        )
    }
}