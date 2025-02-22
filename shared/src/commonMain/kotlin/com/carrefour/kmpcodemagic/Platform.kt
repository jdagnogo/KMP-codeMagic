package com.carrefour.kmpcodemagic

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform