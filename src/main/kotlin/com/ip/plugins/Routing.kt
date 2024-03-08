package com.ip.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import sendNotification

fun Application.configureRouting() {
    routing {
        sendNotification()
    }
}
