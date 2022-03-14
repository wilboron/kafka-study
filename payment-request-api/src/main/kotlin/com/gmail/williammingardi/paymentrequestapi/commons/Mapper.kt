package com.gmail.williammingardi.paymentrequestapi.commons

interface Mapper<T, U> {
    fun map(t: T): U
}
