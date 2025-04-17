package com.selcanasirova.newscatcher.unit.exceptions

import java.io.IOException

sealed class NetworkException (message: String) : IOException(message) {
    class Unauthorized(message: String) : NetworkException("Geçərsiz giriş")
    class NotFound(message: String) : NetworkException("Tapılmadı")
    class ServerError(val code: Int) : NetworkException("Server Xətası $code")
    class Error(message: String) : NetworkException(message)
}