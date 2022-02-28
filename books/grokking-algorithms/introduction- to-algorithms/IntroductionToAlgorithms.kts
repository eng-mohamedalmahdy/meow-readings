val values = (1..10).toList()
println(values)
val key = 10
var res = -1
println("Linear Search")
for (i in values.indices) {
    print("$i ")
    if (values[i] == key) {
        res = i
        break
    }
}
println()
println(res)
/*
1 2 3 4 5 6 7 8 9 10
    3   5

 */
println("Binary Search")
var upper = values.size - 1
var lower = 0
var binRes = -1
while (upper >= lower) {
    val mid = (upper + lower) / 2
    println(mid)
    if (values[mid] == key) {
        binRes = mid
        break
    } else if (values[mid] > key) {
        upper = mid
    } else {
        lower = mid + 1
    }
}
println(binRes)