package com.example.cleanarchitecture.domain

import com.example.cleanarchitecture.data.entity.product.ProductEntity
import com.example.cleanarchitecture.data.repository.ProductRepository

internal class OrderProductItemUseCase (
    private val productRepository: ProductRepository
): UseCase{
    suspend operator fun invoke(productEntity: ProductEntity): Long?{
        return productRepository.insertProductItem(productEntity)
    }
}

