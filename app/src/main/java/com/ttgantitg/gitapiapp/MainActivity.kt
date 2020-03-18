package com.ttgantitg.gitapiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.gitapiapp.data.model.SearchModel
import com.ttgantitg.gitapiapp.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).getComponent()?.inject(this)
        searchViewModel = ViewModelProvider(this, viewModelFactory).get(SearchViewModel::class.java)

        var inputText: String?

        btn_check.setOnClickListener {
            inputText = textInputEdit.text.toString()
            searchViewModel.loadData(inputText!!)
                .observe(this, Observer<List<SearchModel?>> {
                    recycler_view.adapter = GitAdapter(it as List<SearchModel>)
                })
        }
    }
}
