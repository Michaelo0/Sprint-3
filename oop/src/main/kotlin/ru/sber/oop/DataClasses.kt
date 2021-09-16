package ru.sber.oop

data class User(val name: String, val age: Long, var city: String ) {
}

fun main() {
    val user1 = User("Alex", 13, "Omsk")
    val user2 = user1.copy("John")

    val user3 = user1.copy()
    user3.city = "Tomsk"
    println(user1.equals(user3))
    println(user2)
}