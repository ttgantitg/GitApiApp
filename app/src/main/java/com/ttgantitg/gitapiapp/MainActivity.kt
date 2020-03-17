package com.ttgantitg.gitapiapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ttgantitg.gitapiapp.data.repository.SearchRepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = SearchRepositoryProvider.provideSearchRepository()
        repository.searchUserRepos("ttgantitg")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("Result", it.toString())
            }, {
                it.printStackTrace()
            })
    }
}
