package com.ttgantitg.gitapiapp

import android.app.Application
import com.ttgantitg.gitapiapp.di.components.AppComponent
import com.ttgantitg.gitapiapp.di.components.DaggerAppComponent

class App : Application() {
    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    fun getComponent(): AppComponent? {
        return appComponent
    }
}