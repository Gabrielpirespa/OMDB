package com.iniciandoaviddadev.omdb.application

import android.app.Application
import com.iniciandoaviddadev.omdb.di.descriptionModule
import com.iniciandoaviddadev.omdb.di.mainModule
import com.iniciandoaviddadev.omdb.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(networkModule)
            modules(mainModule)
            modules(descriptionModule)
        }

    }

}