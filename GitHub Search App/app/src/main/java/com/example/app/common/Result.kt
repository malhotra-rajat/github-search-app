package com.example.app.common

sealed class Result<T: Any?>
class Success<T: Any>(val data: T): Result<T>()
class Failure<T: Any?>(val errorString: String? = null): Result<T>()
