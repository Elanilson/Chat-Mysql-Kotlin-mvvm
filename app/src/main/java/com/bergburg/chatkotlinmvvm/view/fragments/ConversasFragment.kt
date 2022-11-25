package com.bergburg.chatkotlinmvvm.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bergburg.chatkotlinmvvm.R
import com.bergburg.chatkotlinmvvm.databinding.FragmentConversasBinding
import com.bergburg.chatkotlinmvvm.interfaces.AcaoListener
import com.bergburg.chatkotlinmvvm.model.entities.Conversa
import com.bergburg.chatkotlinmvvm.view.activity.ChatActivity
import com.bergburg.chatkotlinmvvm.view.adapter.ConversaAdapter
import com.bergburg.chatkotlinmvvm.viewModel.ConversaViewModel


class ConversasFragment : Fragment(){
    private lateinit var binding: FragmentConversasBinding
    private lateinit var viewModel : ConversaViewModel
    private val adapter = ConversaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConversasBinding.inflate(layoutInflater, container, false)
        configurarRecycleview();

        viewModel = ViewModelProvider(this).get(ConversaViewModel::class.java)

        val listener = object : AcaoListener<Conversa> {
            override fun onClick(objeto: Conversa) {

                val bundle = Bundle()
                bundle.putLong("idUsuario",objeto.idUsuario)
                bundle.putLong("idConversa",objeto.id)
                val intent = Intent(binding.root.context, ChatActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

        adapter.attackListener(listener)
        observe();
        return binding.root
    }

    private fun observe() {
        viewModel.conversas.observe(viewLifecycleOwner){
            adapter.attackConversas(it)
        }
        viewModel.mensagem.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun  configurarRecycleview(){
        binding.recyclerViewConversa.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerViewConversa.adapter = adapter
    }


    override fun onResume() {
        super.onResume()
        viewModel.exibirConversas()
    }


}