package com.bergburg.chatkotlinmvvm.model.entities

class Dados {

     var error : String = ""
     var status : Boolean = false
     var  contatos : List<Contato> = listOf()
     var  conversas : List<Conversa> = listOf()
     var  mensagens  : List<Mensagem> = listOf()
     lateinit var  mensagem : Mensagem
}