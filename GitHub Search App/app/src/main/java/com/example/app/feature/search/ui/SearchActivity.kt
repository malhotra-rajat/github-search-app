package com.example.app.feature.search.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.common.Failure
import com.example.app.common.Success
import com.example.app.databinding.ActivitySearchBinding
import com.example.app.feature.search.util.SearchAdapter
import com.example.app.feature.search.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private lateinit var viewAdapter: SearchAdapter
    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        observeViewModel()
    }

    private fun initUI() {
        val linearLayoutManager = LinearLayoutManager(this)
        viewAdapter = SearchAdapter(ArrayList())

        val dividerItemDecoration = DividerItemDecoration(
            binding.rvResults.context,
            linearLayoutManager.orientation
        )

        binding.rvResults.apply {
            layoutManager = linearLayoutManager
            adapter = viewAdapter
            addItemDecoration(dividerItemDecoration)
        }

        binding.btnSearch.setOnClickListener {
            search()
        }

        binding.editOrgName.setOnEditorActionListener { _, actionId, _ ->
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
        searchViewModel.reposResult.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
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
        val searchText = binding.editOrgName.text.toString()
        if (searchText.isNotEmpty()) {
            clearList()
            searchViewModel.searchRepos(searchText)
        } else {
            Toast.makeText(this, "Please enter the organization name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearList() {
        viewAdapter.clearData()
        hideKeyboard()
        binding.editOrgName.clearFocus()
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideKeyboard() {
        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = this.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
