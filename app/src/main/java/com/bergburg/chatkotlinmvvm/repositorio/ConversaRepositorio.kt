package com.bergburg.chatkotlinmvvm.model.repositorio

import com.bergburg.chatkotlinmvvm.model.remoto.services.ChatService
import com.bergburg.chatkotlinmvvm.model.entities.Conversa
import com.bergburg.chatkotlinmvvm.model.entities.Dados
import com.bergburg.chatkotlinmvvm.interfaces.APIListener
import com.bergburg.chatkotlinmvvm.repositorio.remoto.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConversaRepositorio {
    private val service = RetrofitClient.classService(ChatService::class.java)

    fun carregarConversas(listener : APIListener<List<Conversa>>){
        val call  = service.getConversas()
        call.enqueue( object : Callback<Dados>{
            override fun onResponse(call: Call<Dados>, response: Response<Dados>) {
                response.body()?.let { listener.onSuccess(it.conversas) }
            }

            override fun onFailure(call: Call<Dados>, t: Throwable) {
                listener.onFailures(t.message.toString())
            }
        })
    }
}