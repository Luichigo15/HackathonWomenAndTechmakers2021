package com.reyozic.hackathon.domain.userdata

data class HWTUser(
    val email:String,
    val password:String,
    var token:String = ""
) {
    override fun toString(): String {
        return "HWTUser(email='$email', password='$password', token='$token')"
    }
}