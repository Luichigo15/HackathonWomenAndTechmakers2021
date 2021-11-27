package com.reyozic.hackathon.api

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.reyozic.hackathon.R

class NotificationsHelper {
    companion object{
        private const val CHANNEL_ID = "General"
        private var notificationId = 0

        fun createChannel(context: Context){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = context.getString(R.string.not_channel)
                val descriptionText = context.getString(R.string.not_description)
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
        }

        fun createNotification(context: Context, title:String, content:String){
            var builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(PendingIntent.getActivity(context, 0, Intent(), 0));


            with(NotificationManagerCompat.from(context)) {
                notify(notificationId++, builder.build())
            }
        }
    }
}