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
import com.ubaya.uts_anmp_160420009.databinding.FragmentReadBinding
import com.ubaya.uts_anmp_160420009.viewmodel.ListViewModel

class ReadFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private val readListAdapter = ReadListAdapter(arrayListOf())
    private lateinit var binding: FragmentReadBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReadBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.refresh()


        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.beritasLD.observe(viewLifecycleOwner, Observer {
            readListAdapter.updateBeritaList(it)
        })
    }
}