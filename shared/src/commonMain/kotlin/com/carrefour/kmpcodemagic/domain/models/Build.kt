package com.carrefour.kmpcodemagic.domain.models

data class Build(
    val id : String,
    val name : String,
    val author : String,
    val branch : String,
    val commit : String,
    val url : String,
    val status : Status,
)