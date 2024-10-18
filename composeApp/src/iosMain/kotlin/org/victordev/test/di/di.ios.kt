package org.victordev.test.di

import org.koin.dsl.module
import org.victordev.test.data.database.getDataBaseBuilder

actual val nativeModule = module{
    single {
        getDataBaseBuilder()
    }

}