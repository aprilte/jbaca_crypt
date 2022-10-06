fun main() {
    // write your code here
    parseElem(readln())
}

fun parseElem(uri: String) {
    if (!uri.contains("?")) return
    val spr = uri.split("?")[1].split("&")
    spr.forEach {
        val sep = it.split("=")
        if (sep.last() != "") println("${sep.first()} : ${sep.last()}") else println("${sep.first()} : not found")
    }
    spr.forEach {
        val sep = it.split("=")
        if (sep.contains("pass")) println("password : ${sep.last()}")
    }
}