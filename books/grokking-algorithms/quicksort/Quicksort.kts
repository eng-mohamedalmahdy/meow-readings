fun quickSort(list: List<Int>): List<Int> {
    if (list.size < 2) return list
    else {
        val pivot = list[0]
        val smaller = mutableListOf<Int>()
        val larger = mutableListOf<Int>()
        for (i in 1 until list.size) {
            if (list[i] < pivot) smaller += list[i]
            else larger += list[i]
        }
        return quickSort(smaller) + pivot + quickSort(larger)
    }
}

val list = listOf(5, 2, 7, 3)
println(list)
println(quickSort(list))
