package com.ubaya.uts_anmp_160420009.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.uts_anmp_160420009.R
import com.ubaya.uts_anmp_160420009.databinding.FragmentHomeBinding
import com.ubaya.uts_anmp_160420009.viewmodel.ListViewModel

class HomeFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private val beritaListAdapter = BeritaListAdapter(arrayListOf())
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = beritaListAdapter

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.beritasLD.observe(viewLifecycleOwner, Observer {
            beritaListAdapter.updateBeritaList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner) {
            if (it) {
                binding.txtError.visibility = View.VISIBLE
            } else {
                binding.txtError.visibility = View.GONE
            }
        }

        viewModel.loadingDoneLD.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            }
        }
    }
}