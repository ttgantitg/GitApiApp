package com.ttgantitg.gitapiapp.di.components

import com.ttgantitg.gitapiapp.MainActivity
import com.ttgantitg.gitapiapp.di.modules.ContextModule
import com.ttgantitg.gitapiapp.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ContextModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity?)
}