package com.mvfkotlin.myapplication.network

import com.mvfkotlin.myapplication.model.Item
import com.mvfkotlin.myapplication.util.EntityMapper
import javax.inject.Inject

class MovieNetworkMapper
@Inject
constructor(): EntityMapper<MovieNetworkObject, Item>{
    override fun mapFromEntityToModel(entity: MovieNetworkObject): Item {
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

    override fun mapFromModelToEntity(item: Item): MovieNetworkObject {
        return MovieNetworkObject(
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

    fun mapFromEntityListToModelList(entities: List<MovieNetworkObject>): List<Item>{
        return entities.map { mapFromEntityToModel(it) }
    }
}

class TvNetworkMapper
@Inject
constructor(): EntityMapper<TvNetworkObject, Item>{
    override fun mapFromEntityToModel(entity: TvNetworkObject): Item {
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

    override fun mapFromModelToEntity(item: Item): TvNetworkObject {
        return TvNetworkObject(
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

    fun mapFromEntityListToModelList(entities: List<TvNetworkObject>): List<Item>{
        return entities.map { mapFromEntityToModel(it) }
    }
}