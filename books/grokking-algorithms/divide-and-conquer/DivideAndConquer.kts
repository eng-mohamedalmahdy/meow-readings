/*
[1,2,3,4,5,7]
Q : Sum this array in rec

sum([]) = 0
sum([5]) = 5
sum([5,7]) = sum([5])+sum([7]) = 5 + 7 = 12
sum([5,7,8]) = sum([5]) + sum([7,8]) = 5 + sum([7,8]) = 5 + sum([7])+sum([8]) = 5 + 7 + 8 = 20

 */

fun iterativeSum(list: List<Int>): Int {
    var sum = 0
    for (i in 0 until list.size) {
        sum += list[i]
    }
    return sum
}

fun recSum(list: List<Int>): Int {
    if (list.isEmpty()) return 0
    else if (list.size == 1) return list[0]
    else return list[0] + recSum(list.subList(1, list.size))
}

val list = listOf(1, 2, 3, 4, 5)
println(list)
println(iterativeSum(list))
println(recSum(list))