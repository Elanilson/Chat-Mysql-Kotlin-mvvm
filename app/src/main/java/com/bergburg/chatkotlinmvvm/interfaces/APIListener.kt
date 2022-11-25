package com.bergburg.chatkotlinmvvm.interfaces

interface APIListener <T> {
    fun onSuccess(result: T)
    fun onFailures(mensagem : String)
}