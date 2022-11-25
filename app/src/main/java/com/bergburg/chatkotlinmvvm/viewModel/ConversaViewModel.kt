package com.bergburg.chatkotlinmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bergburg.chatkotlinmvvm.model.repositorio.ContatoRepositorio
import com.bergburg.chatkotlinmvvm.model.repositorio.ConversaRepositorio
import com.bergburg.chatkotlinmvvm.interfaces.APIListener
import com.bergburg.chatkotlinmvvm.model.entities.Contato
import com.bergburg.chatkotlinmvvm.model.entities.Conversa

class ConversaViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio = ConversaRepositorio()

    private var _Conversas = MutableLiveData<List<Conversa>>()
    var conversas : LiveData<List<Conversa>> = _Conversas

    private var _Mensagem = MutableLiveData<String>()
    var mensagem : LiveData<String> = _Mensagem

    fun exibirConversas(){
        val listener = object : APIListener<List<Conversa>> {
            override fun onSuccess(result: List<Conversa>) {
                _Conversas.value = result
            }

            override fun onFailures(mensagem: String) {
               _Mensagem.value = mensagem
            }
        }

        repositorio.carregarConversas(listener)

    }
}