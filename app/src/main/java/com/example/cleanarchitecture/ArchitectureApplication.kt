package com.example.cleanarchitecture

import android.app.Application
import com.example.cleanarchitecture.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ArchitectureApplication: Application() { // 애플리케이션 클래스. 애플리케이션의 전역 상태와 설정을 관리. 애플리케이션 컴포넌트들이 공유 리소스에 접근하고 애플리케이션 수준의 이벤트를 처리할 수 있음.
    override fun onCreate() {
        super.onCreate()

        startKoin{// Koin을 초기화하고 의존성 주입 설정.
            androidLogger(Level.ERROR) // Koin이 Android로그에 오류 수준의 로그를 출력할 수 있도록 설정. ERROR수준 이상의 로그만 출력될 것
            androidContext(this@ArchitectureApplication) // Koin에 현재 애플리케이션 컨텍스트를 제공. 이를 통해 Koin은 Android 애플리케이션 컨텍스트를 사용하여 의존성 주입 가능.
            modules(appModule) // Koin 모듈 설정.
        }
    }
}
// Koin 모듈은 Koin DI(Dependency Injection) 프레임워크에서 사용되는 구성 요소. Koin 모듈은 의존성 주입을 설정하고 관리하는 데 사용된다.
//
// Koin 모듈의 주요 역할
// 1.의존성 등록(Dependency Registration):
// Koin 모듈은 애플리케이션에서 사용되는 클래스 또는 객체의 의존성을 등록한다.
// 이를 통해 Koin은 해당 클래스 또는 객체를 필요로 하는 다른 클래스나 객체에 의존성을 주입할 수 있다.
// 의존성 등록은 single, factory, scope 등의 함수를 사용하여 수행할 수 있으며, 이를 통해 객체의 인스턴스화 방법과 생명주기를 정의할 수 있다.
//
// 2.의존성 주입(Dependency Injection):
// Koin 모듈은 등록된 의존성을 주입하여 클래스나 객체 간의 의존 관계를 해결한다.
// 의존성 주입은 by inject() 또는 get() 함수를 사용하여 수행된다.
// 이를 통해 클래스나 객체는 필요한 의존성을 직접 생성하지 않고, Koin이 의존성을 관리하고 주입해줄 수 있다.
//
// 3.모듈 구성:
// Koin 모듈은 여러 의존성 등록과 의존성 주입 설정을 하나의 논리적 단위로 묶을 수 있다.
// 모듈을 사용하면 애플리케이션의 다양한 부분에서 사용되는 의존성을 그룹화하고 관리하기 쉽다.
// 모듈은 module { ... } 블록을 사용하여 정의되며, 의존성 등록과 주입 설정을 포함할 수 있다.
//
// Koin 모듈은 애플리케이션의 객체 간의 의존성을 관리하고 코드의 유연성과 재사용성을 향상시키는 데 중요한 역할을 한다.
// 의존성을 등록하고 주입함으로써 클래스 간의 강한 결합을 피하고, 객체의 생성 및 관리를 편리하게 할 수 있다.
// 또한, Koin은 모듈 단위로 의존성을 구성하므로, 애플리케이션의 크기가 커져도 의존성 관리가 용이하며 테스트 용이성도 높아진다.