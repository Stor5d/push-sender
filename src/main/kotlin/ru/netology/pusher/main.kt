package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData(
            "content", """{
          "userId": 1,
          "userName": "Петя",
          "postId": 2,
          "postAuthor": "ФФФ"
        }""".trimIndent()
        )
        .setToken("dI41L01BRuStp20wzajCTq:APA91bEL9NsiidPpDh9M3S3HD-FFy9Q9K2hoV8QrqL0nk0RfkkUICmLugDlaR-i2GOOfPsr2ZzLf1aRs0VA9h4tBePb01zILZaOhjmR4RDWwzIazmMWK4EeBbB5n1FDPSWIX1o0S_awq")
        .build()

    FirebaseMessaging.getInstance().send(message)
}
