package com.ttgantitg.gitapiapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inputText: String?

        btn_check.setOnClickListener {
            inputText = textInputEdit.text.toString()
            SearchRepositoryProvider.provideSearchRepository()
                .searchUserRepos(inputText!!)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    recycler_view.adapter = GitAdapter(it)
                }, {
                    Toast.makeText(this, "not found", Toast.LENGTH_LONG).show()
                })
        }
    }
}
