package com.bergburg.chatkotlinmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bergburg.chatkotlinmvvm.view.viewholder.ConversaViewHolder
import com.bergburg.chatkotlinmvvm.model.entities.Conversa
import com.bergburg.chatkotlinmvvm.R
import com.bergburg.chatkotlinmvvm.interfaces.AcaoListener


class ConversaAdapter : RecyclerView.Adapter<ConversaViewHolder>() {
    private var conversas : List<Conversa> = listOf()
    private lateinit var listener: AcaoListener<Conversa>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversaViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.layout_conversa,parent,false)
        return  ConversaViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ConversaViewHolder, position: Int) {
        holder.bind(conversas[position],listener)
    }

    override fun getItemCount(): Int {
        return conversas.size
    }

    fun attackConversas(conversas : List<Conversa>){
        this.conversas = conversas
        notifyDataSetChanged()
    }
    fun attackListener(listener: AcaoListener<Conversa>){
        this.listener = listener
    }
}