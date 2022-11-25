package com.bergburg.chatkotlinmvvm.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bergburg.chatkotlinmvvm.view.viewholder.MensagemViewHolder
import com.bergburg.chatkotlinmvvm.model.entities.Mensagem

import com.bergburg.chatkotlinmvvm.R


class MensagemAdapter : RecyclerView.Adapter<MensagemViewHolder>() {
    private var mensagem : List<Mensagem> = listOf()
    private val TIPO_REMETENTE : Int = 0
    private val TIPO_DESTINATARIO : Int = 1
    private lateinit var layout : View
    private  var idUsuarioAtual : Long = 0

  /*  constructor(id : Long){
        idUsuarioAtual = id
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {

        if(viewType == TIPO_REMETENTE){
             layout = LayoutInflater.from(parent.context).inflate(R.layout.adapter_mensagem_remetente,parent,false)
        }else if (viewType == TIPO_DESTINATARIO){
             layout = LayoutInflater.from(parent.context).inflate(R.layout.adapter_mensagem_destinatario,parent,false)
        }
        return  MensagemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MensagemViewHolder, position: Int) {
        holder.bind(mensagem[position])
    }

    override fun getItemViewType(position: Int): Int {
       // return super.getItemViewType(position)
        if(mensagem[position].idUsuario == 1L){
            return TIPO_REMETENTE
        }
        return TIPO_DESTINATARIO
    }

    override fun getItemCount(): Int {
        return mensagem.size
    }

    fun attackMensagens(mensagem : List<Mensagem>){
        this.mensagem = mensagem
        notifyDataSetChanged()
    }
}