package com.bergburg.chatkotlinmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bergburg.chatkotlinmvvm.model.remoto.services.ChatService
import com.bergburg.chatkotlinmvvm.model.repositorio.ContatoRepositorio
import com.bergburg.chatkotlinmvvm.interfaces.APIListener
import com.bergburg.chatkotlinmvvm.model.entities.Contato
import com.bergburg.chatkotlinmvvm.model.entities.Conversa
import com.bergburg.chatkotlinmvvm.repositorio.remoto.RetrofitClient

class ContatoViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio = ContatoRepositorio()

    private var _Contatos = MutableLiveData<List<Contato>>()
    var contatos : LiveData<List<Contato>> = _Contatos

    private var _Mensagem = MutableLiveData<String>()
    var mensagem : LiveData<String> = _Mensagem


    fun exibirContatos (){
        val listener = object : APIListener<List<Contato>> {
            override fun onSuccess(result: List<Contato>) {
                _Contatos.value = result
            }

            override fun onFailures(mensagem: String) {
                _Mensagem.value = mensagem
            }
        }

        repositorio.carregarContatos(listener)

    }
}