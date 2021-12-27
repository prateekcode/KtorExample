package co.apploop.ktorexample.repo

import co.apploop.ktorexample.api.KtorClient
import co.apploop.ktorexample.model.Response
import io.ktor.client.request.*

object Repository {
    suspend fun getUserData(): Response {
        return KtorClient.httpClient.use {
            it.get("https://dummy.restapiexample.com/api/v1/employees")
        }
    }
}