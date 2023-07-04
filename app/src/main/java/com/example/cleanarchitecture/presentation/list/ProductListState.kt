package com.example.cleanarchitecture.presentation.list

import com.example.cleanarchitecture.data.entity.product.ProductEntity

sealed class ProductListState {

    object UnInitialized: ProductListState()

    object Loading: ProductListState()

    data class Success(
        val productList : List<ProductEntity>
    ): ProductListState()

    object Error: ProductListState()

}