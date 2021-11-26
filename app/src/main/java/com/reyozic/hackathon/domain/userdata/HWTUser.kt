package com.reyozic.hackathon.domain.userdata

data class HWTUser(
    val email:String
) {
    override fun toString(): String {
        return "HWTUser(email='$email')"
    }
}