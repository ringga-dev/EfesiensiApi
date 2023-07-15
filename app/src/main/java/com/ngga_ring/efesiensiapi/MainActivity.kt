package com.ngga_ring.efesiensiapi

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ngga_ring.efesiensiapi.api.Resource
import com.ngga_ring.efesiensiapi.databinding.ActivityMainBinding
import com.ngga_ring.efesiensiapi.models.DataModels
import com.ngga_ring.efesiensiapi.view.DataAdapter
import com.ngga_ring.efesiensiapi.viewmodels.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DataViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecler()
        getdataoffline()


        binding.getData.setOnClickListener {

            val editText = EditText(this)
            editText.inputType = InputType.TYPE_CLASS_NUMBER

                val dialog = AlertDialog.Builder(this)
                    .setTitle("set limit data")
                    .setView(editText)
                    .setPositiveButton("OK") { _, _ ->
                        getData(editText.text.toString())
                    }
                    .setNegativeButton("Cancel", null)
                    .create()

                dialog.show()

        }
    }

    private fun setupRecler() {
        binding.rvDatalist.apply {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            scrollToPosition(0)
            adapter = DataAdapter(mutableListOf(), this@MainActivity)
        }
    }

    private fun viewData(data: List<DataModels>) {
        binding.rvDatalist.adapter?.let { adapter ->
            if (adapter is DataAdapter) {
                adapter.setNews(data)
            }
        }
        binding.rvDatalist.scrollToPosition(0)

    }

    private fun getDataOnline() {
        if (isInternetConnected()) {
            getData()
        } else {
            getdataoffline()
        }
    }

    private fun getdataoffline(){
        viewModel.getoffline().observe(this@MainActivity) {
            it.data?.let { it1 -> viewData(it1) }
            if (it.data?.size!! < 1) {
                getData()
            }
        }
    }

    private fun getData(toString: String?="200") {
        viewModel.getData(toString.toString()).observe(this) {
            Log.e("Ringga ::", it.toString())
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { result ->

                        viewModel.saveData(it.data.data!!).observe(this@MainActivity){
                            getdataoffline()
                        }

                    }
                }

                Resource.Status.ERROR -> {
                    Toast.makeText(
                        this,
                        it.status.toString(),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                else -> {
                    Toast.makeText(
                        this,
                        it.status.toString(),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }
    }

}