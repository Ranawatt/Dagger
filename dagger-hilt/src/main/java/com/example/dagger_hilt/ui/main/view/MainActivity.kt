package com.example.dagger_hilt.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger_hilt.R
import com.example.dagger_hilt.data.model.User
import com.example.dagger_hilt.ui.main.adapter.MainAdapter
import com.example.dagger_hilt.ui.main.viewmodel.MainViewModel
import com.example.dagger_hilt.utils.Status
import com.facebook.shimmer.ShimmerFrameLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
                DividerItemDecoration(recyclerView.context,
                        (recyclerView.layoutManager as LinearLayoutManager).orientation))
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.users.observe(this, Observer {
            when(it.status){

                Status.SUCCESS -> {
                    shimmerFrameLayout.stopShimmerAnimation()
                    shimmerFrameLayout.visibility = View.GONE
//                    progressBar.visibility = View.GONE
                    it.data?.let {
                        users -> renderList(users)
                    }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    shimmerFrameLayout.visibility = View.VISIBLE
                    shimmerFrameLayout.maskShape = ShimmerFrameLayout.MaskShape.LINEAR
                    shimmerFrameLayout.startShimmerAnimation()
//                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    shimmerFrameLayout.visibility = View.GONE
//                    progressBar.visibility =View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    override fun onPause() {
        super.onPause()
        shimmerFrameLayout.stopShimmerAnimation()
    }

    override fun onResume() {
        super.onResume()
        shimmerFrameLayout.tilt
        shimmerFrameLayout.startShimmerAnimation()
    }
}