package com.example.cleanarchitecture.domain

import com.example.cleanarchitecture.data.entity.product.ProductEntity
import com.example.cleanarchitecture.data.repository.ProductRepository

internal class GetProductListUseCase (
    private val productRepository: ProductRepository
): UseCase{
    suspend operator fun invoke(): List<ProductEntity>{
        return productRepository.getProductList()
    }
}

