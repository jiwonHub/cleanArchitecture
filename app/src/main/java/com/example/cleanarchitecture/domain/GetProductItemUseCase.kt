package com.example.cleanarchitecture.domain

import com.example.cleanarchitecture.data.entity.product.ProductEntity
import com.example.cleanarchitecture.data.repository.ProductRepository

internal class GetProductItemUseCase (
    private val productRepository: ProductRepository
): UseCase{
    suspend operator fun invoke(productId: Long): ProductEntity?{
        return productRepository.getProductItem(productId)
    }
}

