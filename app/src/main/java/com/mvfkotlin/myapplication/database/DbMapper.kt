package com.mvfkotlin.myapplication.database

import com.mvfkotlin.myapplication.model.Item
import com.mvfkotlin.myapplication.util.EntityMapper
import javax.inject.Inject

class DbMapper
@Inject
constructor(): EntityMapper<CashingDatabaseEntity, Item>{
    override fun mapFromEntityToModel(entity: CashingDatabaseEntity): Item {
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
    fun mapFromFavoritesEntityToModel(entity: FavoriteDatabaseEntity): Item {
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

    override fun mapFromModelToEntity(item: Item): CashingDatabaseEntity {
        return CashingDatabaseEntity(
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
    fun mapFromModelToFavoriteEntity(item: Item): FavoriteDatabaseEntity {
        return FavoriteDatabaseEntity(
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

    fun mapFromFavoriteListToModel(list: List<FavoriteDatabaseEntity>): List<Item>{
        return list.map { mapFromFavoritesEntityToModel(it) }
    }
    fun mapFromModelToFavoriteList(list: List<Item>): List<FavoriteDatabaseEntity>{
        return list.map { mapFromModelToFavoriteEntity(it) }
    }

    fun mapFromEntityListToModelList(entityCashing: List<CashingDatabaseEntity>): List<Item>{
        return entityCashing.map { mapFromEntityToModel(it) }
    }
    fun mapFromModelListToEntityList(items: List<Item>): List<CashingDatabaseEntity>{
        return items.map { mapFromModelToEntity(it) }
    }
}