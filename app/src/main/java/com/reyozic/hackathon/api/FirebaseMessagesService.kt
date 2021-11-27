package com.reyozic.hackathon.api

import com.google.android.material.snackbar.Snackbar
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagesService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        NotificationsHelper.createChannel(applicationContext)

        NotificationsHelper.createNotification(
            applicationContext,
            message.notification!!.title!!
            ,message.notification!!.body!!
        )
    }
}