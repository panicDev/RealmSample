package com.panicdev.realmsample.data.utils

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(data: T): DomainModel
}