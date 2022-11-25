package com.bergburg.chatkotlinmvvm.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bergburg.chatkotlinmvvm.R
import com.bergburg.chatkotlinmvvm.databinding.FragmentContatosBinding
import com.bergburg.chatkotlinmvvm.model.entities.Contato

import com.bergburg.chatkotlinmvvm.view.adapter.ContatoAdapter
import com.bergburg.chatkotlinmvvm.viewModel.ContatoViewModel


class ContatosFragment : Fragment() {
    private lateinit var binding: FragmentContatosBinding
    private val adapter = ContatoAdapter()
    private lateinit var viewModel : ContatoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContatosBinding.inflate(layoutInflater,container,false)

        viewModel = ViewModelProvider(this).get(ContatoViewModel::class.java)

        configurarRecycleview()

        observe()
        return  binding.root
    }

    private fun observe() {
        viewModel.contatos.observe(viewLifecycleOwner){
            adapter.attackContatos(it)
        }
        viewModel.mensagem.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun  configurarRecycleview(){
        binding.recyclerViewContatos.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerViewContatos.adapter = adapter

    }


    override fun onResume() {
        super.onResume()
        viewModel.exibirContatos()
    }

}