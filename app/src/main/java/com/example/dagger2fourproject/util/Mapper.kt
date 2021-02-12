package com.example.dagger2fourproject.util

interface Mapper<Entity,DomainModel>{

    fun mapToDomainModel(entity: Entity):DomainModel
    fun mapFromDomainModel(domainModel: DomainModel):Entity
}