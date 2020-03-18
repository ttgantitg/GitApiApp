package com.ttgantitg.gitapiapp.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class ContextModule(context: Context) {
    private val context: Context = context
    @Binds
    abstract fun bindContext(application: Application?): Context?
}