fun selectionSort(input: List<Int>): List<Int> {
    var currentIdx = 0
    val resultList: MutableList<Int> = input.toMutableList()
    for (i in resultList.indices) {
        var lowestIdx = currentIdx
        for (j in currentIdx until resultList.size) {
            if (resultList[j] < resultList[lowestIdx]) lowestIdx = j
        }
        var temp = resultList[currentIdx]
        resultList[currentIdx] = resultList[lowestIdx]
        resultList[lowestIdx] = temp
        currentIdx++
    }
    return resultList
}

val list = listOf(2,8,1,20,4)
val sorted = selectionSort(list)
println(list)
println(sorted)