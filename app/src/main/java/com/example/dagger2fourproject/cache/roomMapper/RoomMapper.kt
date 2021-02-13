package com.example.dagger2fourproject.cache.roomMapper

import android.graphics.ColorSpace
import com.example.dagger2fourproject.cache.model.RoomModel
import com.example.dagger2fourproject.domain.model.Model
import com.example.dagger2fourproject.util.Mapper
import java.lang.StringBuilder

class RoomMapper : Mapper<RoomModel, Model> {
    override fun mapToDomainModel(entity: RoomModel): Model {
        return Model(
            pk = entity.id,
            title = entity.title,
            publisher = entity.publisher,
            rating = entity.rating,
            source_url = entity.sourceUrl,
            featured_image = entity.featuredImage,
            description = entity.description,
            cooking_instructions = entity.cookingInstructions,
            ingredients = convertIngredientsToList(entity.ingredients),
            date_added = entity.dateAdded,
            date_updated = entity.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: Model): RoomModel {
        return RoomModel(
            id = domainModel.pk,
            title = domainModel.title,
            publisher = domainModel.publisher,
            rating = domainModel.rating,
            sourceUrl = domainModel.source_url,
            featuredImage = domainModel.featured_image,
            description = domainModel.description,
            cookingInstructions = domainModel.cooking_instructions,
            ingredients = convertIngredientsListToString(domainModel.ingredients.orEmpty()),
            dateAdded = domainModel.date_added,
            dateUpdated = domainModel.date_updated
        )
    }

    private fun convertIngredientsListToString(ingredients: List<String>): String {
        val ingredientsString: StringBuilder = StringBuilder()
        for (ingredient in ingredients) {
            ingredientsString.append("$ingredient,")
        }
        return ingredientsString.toString()
    }
    private fun convertIngredientsToList(ingredientsString: String?): List<String> {
        val list: ArrayList<String> = ArrayList()
        ingredientsString?.let {
            for (ingredinet in it.split(",")) {
                list.add(ingredinet)
            }
        }
        return list
    }
}