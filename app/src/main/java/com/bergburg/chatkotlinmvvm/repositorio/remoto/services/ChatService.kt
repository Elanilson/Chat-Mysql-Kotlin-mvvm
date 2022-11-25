package com.bergburg.chatkotlinmvvm.model.remoto.services

import com.bergburg.chatkotlinmvvm.model.entities.Dados
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ChatService {
    @GET("getUsuarios.php")
    fun getContatos() : Call<Dados>
    @GET("getConversas.php")
    fun getConversas() : Call<Dados>

    @POST("getMensagens.php/")
    @FormUrlEncoded
    fun getMensagens(@Field("idUsuario") idUsuario: Long): Call<Dados>

    @POST("salvarMensagem.php/")
    @FormUrlEncoded
    fun enviarMensagem(
        @Field("idUsuario") idUsuario: Long,
        @Field("texto") texto: String,
        @Field("idConversa") idConversa: Long
    ): Call<Dados>
}