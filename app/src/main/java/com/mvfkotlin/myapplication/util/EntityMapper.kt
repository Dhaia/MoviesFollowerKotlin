package com.mvfkotlin.myapplication.util

interface EntityMapper<Entity, Item> {
    fun mapFromEntityToModel(entity: Entity): Item

    fun mapFromModelToEntity(item: Item): Entity
}