package com.bergburg.chatkotlinmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bergburg.chatkotlinmvvm.model.repositorio.ContatoRepositorio
import com.bergburg.chatkotlinmvvm.model.repositorio.MensagensRepositorio
import com.bergburg.chatkotlinmvvm.interfaces.APIListener
import com.bergburg.chatkotlinmvvm.model.entities.Contato
import com.bergburg.chatkotlinmvvm.model.entities.Dados
import com.bergburg.chatkotlinmvvm.model.entities.Mensagem

class ChatViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio = MensagensRepositorio()

    private var _Mensagems = MutableLiveData<List<Mensagem>>()
    var mensagens : LiveData<List<Mensagem>> = _Mensagems

    private var _Mensagem = MutableLiveData<String>()
    var mensagem : LiveData<String> = _Mensagem


    fun exibirConversas(idUSuario : Long){
        val listener = object : APIListener<List<Mensagem>> {
            override fun onSuccess(result: List<Mensagem>) {
               _Mensagems.value = result
            }

            override fun onFailures(mensagem: String) {
                _Mensagem.value = mensagem
            }
        }

        repositorio.carregarConversas(listener,idUSuario)

    }

    fun enviarMensagem(idUsuario : Long, idConversa : Long, texto : String){
        if(texto.isNotBlank() && texto.isNotEmpty()){
            if(idUsuario != null){
                if(idConversa != null){
                    val listener = object : APIListener<Dados>{
                        override fun onSuccess(result: Dados) {
                            if(result.status){
                                _Mensagem.value = ("Sucesso")
                            }else{
                                _Mensagem.value = ("Não foi possível enviar")
                            }
                        }

                        override fun onFailures(mensagem: String) {
                            _Mensagem.value = mensagem
                        }
                    }
                    repositorio.enviarMensagem(listener,idUsuario,texto,idConversa)
                }else{
                    _Mensagem.value = ("Falta o ID da conversa")
                }
            }else{
                _Mensagem.value = ("Falta o ID do usuário")
            }
        }else{
            _Mensagem.value = ("Sem texto")
        }
    }
}