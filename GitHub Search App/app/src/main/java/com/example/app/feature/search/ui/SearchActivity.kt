package com.example.app.feature.search.ui

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.R
import com.example.app.common.AppUtils
import com.example.app.common.Failure
import com.example.app.common.Success
import com.example.app.feature.search.viewmodels.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : AppCompatActivity() {

    private lateinit var viewAdapter: SearchAdapter
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        initUI()
        observeViewModel()
    }

    private fun initUI() {
        val linearLayoutManager = LinearLayoutManager(this)
        viewAdapter = SearchAdapter(ArrayList())

        val dividerItemDecoration = DividerItemDecoration(
            rv_results.context,
            linearLayoutManager.orientation
        )

        rv_results.apply {
            layoutManager = linearLayoutManager
            adapter = viewAdapter
            addItemDecoration(dividerItemDecoration)
        }

        btn_search.setOnClickListener {
            search()
        }

        edit_org_name.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    search()
                    true
                }
                else -> false
            }
        }
    }

    private fun observeViewModel() {
        searchViewModel.repos.observe(this, Observer {
            progressBar.visibility = View.GONE
            when (it) {
                is Success -> {
                    it.data.repos?.let { repos ->
                        viewAdapter.updateData(repos)
                    }
                }
                is Failure -> {
                    it.errorString?.let { err ->
                        Toast.makeText(this, err, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun search() {
        val searchText = edit_org_name.text.toString()
        if (searchText.isNotEmpty()) {
            clearList()
            searchViewModel.searchRepos(searchText)
        } else {
            Toast.makeText(this, "Please enter the organization name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearList() {
        viewAdapter.clearData()
        AppUtils.hideKeyboard(this)
        edit_org_name.clearFocus()
        progressBar.visibility = View.VISIBLE
    }
}
