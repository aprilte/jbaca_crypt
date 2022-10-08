// TODO: provide three functions here

fun generate(functionName: String): (Int) -> Int {
    // TODO: provide implementation here
    when (functionName) {
        "identity", -> return ::identity
        "half", -> return ::half
        "zero", -> return ::zero
        else -> return ::zero
    }
}

fun identity(arg: Int): Int = arg

fun half(arg: Int): Int = (arg / 2)

fun zero(arg: Int): Int = 0