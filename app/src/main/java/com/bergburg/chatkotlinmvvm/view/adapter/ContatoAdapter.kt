package com.bergburg.chatkotlinmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bergburg.chatkotlinmvvm.model.entities.Contato
import com.bergburg.chatkotlinmvvm.view.viewholder.ContatoViewHolder

import com.bergburg.chatkotlinmvvm.R

class ContatoAdapter : RecyclerView.Adapter<ContatoViewHolder>() {
    private var contatos : List<Contato> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.layout_contato,parent,false)
        return  ContatoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.bind(contatos[position])
    }

    override fun getItemCount(): Int {
        return contatos.size
    }

    fun attackContatos(contatos : List<Contato>){
        this.contatos = contatos
        notifyDataSetChanged()
    }
}