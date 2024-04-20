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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.refresh()

        binding.recView.layoutManager =LinearLayoutManager(context)
        binding.recView.adapter = beritaListAdapter

        binding.refreshLayout.setOnRefreshListener {
            binding.recView.visibility = View.GONE
            binding.txtError.visibility = View.GONE
            binding.progressBar.visibility = View.GONE
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    private fun observeViewModel(){
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

        viewModel.loadingLD.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
                binding.recView.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.recView.visibility = View.VISIBLE
            }
        }
    }

}