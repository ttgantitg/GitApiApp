package com.ttgantitg.gitapiapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ttgantitg.gitapiapp.data.model.SearchModel
import com.ttgantitg.gitapiapp.data.repository.SearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val searchRepository: SearchRepository) : ViewModel() {

    private val disposable = CompositeDisposable()
    private var modelMutableLiveData = MutableLiveData<List<SearchModel?>>()

    fun loadData(user: String): MutableLiveData<List<SearchModel?>> {
        disposable.add(
            searchRepository.searchUserRepos(user = user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<SearchModel?>>() {
                    override fun onNext(t: List<SearchModel?>) {
                        modelMutableLiveData.value = t
                    }
                    override fun onComplete() {}
                    override fun onError(e: Throwable) {}
                })
        )
        return modelMutableLiveData
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}