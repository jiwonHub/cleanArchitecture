package com.example.cleanarchitecture.presentation.detail

import com.example.cleanarchitecture.data.entity.product.ProductEntity

sealed class ProductDetailState {

    object UnInitialized: ProductDetailState()

    object Loading: ProductDetailState()

    data class Success(
        val productEntity: ProductEntity
    ): ProductDetailState()

    object Order: ProductDetailState()

    object Error: ProductDetailState()

}