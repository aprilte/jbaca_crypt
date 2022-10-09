import java.lang.Exception

fun main() {
    // put your code here
    val read = readln()
    read.toCharArray().forEach {
        if(it in '0'..'9') {
            println(it)
            return
        }
    }
}