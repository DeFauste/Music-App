package com.example.daggerexample.data

import javax.inject.Inject

class Processor @Inject constructor() {
    override fun toString() = "ADADW123"
}

class Motherboard @Inject constructor() {
    override fun toString() = "X7"
}

class RAM @Inject constructor() {
    override fun toString() = "16 GB"
}

data class Computer @Inject constructor(
    val processor: Processor,
    val motherboard: Motherboard,
    val ram: RAM
)
