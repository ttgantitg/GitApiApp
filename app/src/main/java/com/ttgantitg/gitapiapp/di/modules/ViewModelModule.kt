package com.ttgantitg.gitapiapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.gitapiapp.di.ViewModelKey
import com.ttgantitg.gitapiapp.viewmodel.SearchViewModel
import com.ttgantitg.gitapiapp.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindViewModel(searchViewModel: SearchViewModel?): ViewModel?

    @Binds
    abstract fun bindFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?
}