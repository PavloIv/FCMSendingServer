import com.google.firebase.messaging.FirebaseMessaging
import com.ip.SendMessageDto
import com.ip.toMessage
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receiveNullable
import io.ktor.server.response.respond
import io.ktor.server.routing.*


fun Route.sendNotification() {
    route("/send"){
        post {
            val body = call.receiveNullable<SendMessageDto>() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            FirebaseMessaging.getInstance().send(body.toMessage())
            call.respond(HttpStatusCode.OK)
        }
    }
    route("/broadcast"){
        post {
            val body = call.receiveNullable<SendMessageDto>() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            FirebaseMessaging.getInstance().send(body.toMessage())
            call.respond(HttpStatusCode.OK)
        }
    }
}