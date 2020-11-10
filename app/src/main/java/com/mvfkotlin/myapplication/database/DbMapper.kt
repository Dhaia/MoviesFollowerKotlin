package com.mvfkotlin.myapplication.database

import com.mvfkotlin.myapplication.model.Item
import com.mvfkotlin.myapplication.util.EntityMapper
import javax.inject.Inject

class DbMapper
@Inject
constructor(): EntityMapper<DatabaseEntity, Item>{
    override fun mapFromEntityToModel(entity: DatabaseEntity): Item {
        return Item(
            popularity = entity.popularity,
            id = entity.id,
            voteAverage = entity.voteAverage,
            voteCount = entity.voteCount,
            posterPath = entity.posterPath,
            backdropPath = entity.backdropPath,
            originalTitle = entity.originalTitle,
            genreIds = entity.genreIds,
            title = entity.title,
            overview = entity.overview,
            releaseDate = entity.releaseDate
        )
    }

    override fun mapFromModelToEntity(item: Item): DatabaseEntity {
        return DatabaseEntity(
            id = item.id,
            title = item.title,
            originalTitle = item.originalTitle,
            posterPath = item.posterPath,
            backdropPath = item.backdropPath,
            overview = item.overview,
            releaseDate = item.releaseDate,
            genreIds = item.genreIds,
            popularity = item.popularity,
            voteCount = item.voteCount,
            voteAverage = item.voteAverage
        )
    }

    fun mapFromEntityListToModelList(entities: List<DatabaseEntity>): List<Item>{
        return entities.map { mapFromEntityToModel(it) }
    }
    fun mapFromModelListToEntityList(items: List<Item>): List<DatabaseEntity>{
        return items.map { mapFromModelToEntity(it) }
    }
}