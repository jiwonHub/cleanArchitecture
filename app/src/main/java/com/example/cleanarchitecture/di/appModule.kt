package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.db.provideDB
import com.example.cleanarchitecture.data.db.provideToDoDao
import com.example.cleanarchitecture.data.network.buildOkHttpClient
import com.example.cleanarchitecture.data.network.provideGsonConverterFactory
import com.example.cleanarchitecture.data.network.provideProductApiService
import com.example.cleanarchitecture.data.network.provideProductRetrofit
import com.example.cleanarchitecture.data.preference.PreferenceManager
import com.example.cleanarchitecture.data.repository.DefaultProductRepository
import com.example.cleanarchitecture.data.repository.ProductRepository
import com.example.cleanarchitecture.domain.GetProductItemUseCase
import com.example.cleanarchitecture.domain.GetProductListUseCase
import com.example.cleanarchitecture.domain.OrderProductItemUseCase
import com.example.cleanarchitecture.presentation.detail.ProductDetailViewModel
import com.example.cleanarchitecture.presentation.list.ProductListViewModel
import com.example.cleanarchitecture.presentation.main.MainViewModel
import com.example.cleanarchitecture.presentation.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel() }
    viewModel { ProfileViewModel(get()) }
    viewModel { ProductListViewModel(get()) }
    viewModel { (productId: Long) -> ProductDetailViewModel(productId, get(), get()) }

    // Dispatchers는 Kotlin의 코루틴(Coroutine)을 사용하여 비동기 작업을 수행하는 데 사용되는 디스패처(dispatcher).
    single { Dispatchers.Main } // Dispatchers.Main은 메인(UI) 스레드에서 코루틴을 실행하기 위한 디스패처.
    single { Dispatchers.IO } // Dispatchers.IO는 I/O 작업에 적합한 백그라운드 스레드에서 코루틴을 실행하기 위한 디스패처.

    // ProductRepository는 데이터를 처리하는 데 사용되는 인터페이스.
    // DefaultProductRepository는 ProductRepository를 구현한 클래스로, 실제 데이터 처리 로직이 구현되어 있다.
    // single<ProductRepository> { DefaultProductRepository(get(), get()) }은 DefaultProductRepository 객체를 싱글톤으로 등록하고,
    // 해당 객체의 생성자에 Dispatchers.Main과 Dispatchers.IO를 주입하는 부분이다.
    single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

    // GetProductItemUseCase는 아이템을 가져오는 데 사용되는 유즈케이스(Use Case) 클래스.
    // factory { GetProductItemUseCase(get()) }는 GetProductItemUseCase 객체를 팩토리로 등록하는 부분이다.
    // 이를 통해 객체가 필요할 때마다 새로운 인스턴스가 생성되며, 해당 객체의 생성자에 ProductRepository를 주입한다.
    factory { GetProductItemUseCase(get()) }
    factory { GetProductListUseCase(get()) }
    factory { OrderProductItemUseCase(get()) }

    // 아래 4개는 HTTP통신을 위한 Retrofit과 관련된 함수
    single { provideGsonConverterFactory() }

    single { buildOkHttpClient() }

    single { provideProductApiService(get()) }

    single { provideProductRetrofit(get(), get()) }

    single { PreferenceManager(androidContext()) }

    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }
}