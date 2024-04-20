package com.ubaya.uts_anmp_160420009.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ubaya.uts_anmp_160420009.R
import com.ubaya.uts_anmp_160420009.databinding.FragmentLoginBinding
import com.ubaya.uts_anmp_160420009.viewmodel.LoginModel

class LoginFragment : Fragment() {
    private lateinit var loginModel:LoginModel
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //loginModel = ViewModelProvider(this)[LoginModel::class.java]
        binding.btnSignin.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()

            if(username == "donny" && password == "yung"){
                val action = LoginFragmentDirections.actionSignin()
                Navigation.findNavController(it).navigate(action)
                Toast.makeText(requireContext(), "Login Berhasil", Toast.LENGTH_SHORT)
            }else{
                Toast.makeText(requireContext(), "Login Gagal", Toast.LENGTH_SHORT)
            }
        }
    }
}