fun factorial(x:Int):Int{
    var res = 1
    repeat(x){ res *= it+1 }
    return res
}
// fact(x) = x * fact(x-1)
// fact(0 & 1) = 1
fun factorial(x: Int): Int {
    if (x == 1 || x == 0) return 1
    return x * factorial(x - 1)
}
val x = factorial(3)


fun pow(base: Int, power: Int): Int {
    var res = 1
    repeat(power) { res *= base }
    return res
}

// 2 3 => 2 * pow(2,2)
// 2 2 => 4 * pow(2,1)
// 2 1 => 4 * 2
fun pow(base: Int, power: Int): Int {
    if (power == 0) return 1
    if (power == 1) return base
    return base * pow(base, power - 1)
}

val x = pow(2, 3)
print(x)

