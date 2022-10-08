fun main() {  
    val beyondTheWall = readLine()!!.split(',').map { it }.toTypedArray()
    val backFromTheWall = readLine()!!.split(',').map { it }.toTypedArray()    
    // do not touch the lines above
    // write your code here
    println(contains(beyondTheWall.toMutableList(), backFromTheWall.toMutableList()))
}

fun contains(listA: MutableList<String>, listB: MutableList<String>): Boolean {
    var ret: Boolean = true
    listA.forEach {
        if (ret) {
            ret = listB.contains(it)
        }
    }
    return ret
}