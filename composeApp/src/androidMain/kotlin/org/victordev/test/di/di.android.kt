package org.victordev.test.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.victordev.test.data.database.getDataBaseBuilder

actual val nativeModule: Module = module {
    single {
        getDataBaseBuilder(get())
    }
}