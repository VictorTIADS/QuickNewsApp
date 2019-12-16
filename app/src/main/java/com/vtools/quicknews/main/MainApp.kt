package com.vtools.quicknews.main

import android.app.Application
import com.vtools.quicknews.di.koinInjector

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        koinInjector()
    }
}