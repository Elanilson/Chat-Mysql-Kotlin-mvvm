package com.bergburg.chatkotlinmvvm.model.repositorio

import com.bergburg.chatkotlinmvvm.model.remoto.services.ChatService
import com.bergburg.chatkotlinmvvm.model.entities.Contato
import com.bergburg.chatkotlinmvvm.model.entities.Dados

import com.bergburg.chatkotlinmvvm.interfaces.APIListener
import com.bergburg.chatkotlinmvvm.repositorio.remoto.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContatoRepositorio {
    private val service = RetrofitClient.classService(ChatService::class.java)

    fun carregarContatos(listener : APIListener<List<Contato>>){
        val call = service.getContatos()
        call.enqueue(object  : Callback<Dados>{
            override fun onResponse(call: Call<Dados>, response: Response<Dados>) {
                response.body()?.let { listener.onSuccess(it.contatos) }
            }

            override fun onFailure(call: Call<Dados>, t: Throwable) {
                listener.onFailures(t.message.toString())
            }
        })
    }
}