val graph =
    mutableMapOf("S" to mutableMapOf("A" to 6, "B" to 2),
        "A" to mutableMapOf("F" to 1),
        "B" to mutableMapOf("A" to 3, "F" to 5),
        "F" to null)

val costs = mutableMapOf("A" to 6, "B" to 2, "F" to Int.MAX_VALUE)

val paretns = mutableMapOf("A" to "S", "B" to "S", "F" to null)

val processed = mutableListOf<String?>()

println(graph)
println(costs)
println(paretns)

fun getLowestCostNode(costs: Map<String, Int>): String? {
    var lowestCost = Int.MAX_VALUE
    var lowestCostNode: String? = null
    for (node in costs.keys) {
        val cost = costs[node]
        if (costs[node]!! < lowestCost && node !in processed) {
            lowestCost = cost ?: Int.MAX_VALUE
            lowestCostNode = node
        }
    }
    return lowestCostNode
}

var node = getLowestCostNode(costs)
while (node != null) {
    val cost = costs[node]
    println(node)
    println(cost)
    val neighbors = graph[node]
    if (neighbors != null) {
        for (n in neighbors.keys) {
            val newCost = cost!! + neighbors[n]!!
            if (costs[n]!! > newCost) {
                costs[n] = newCost
                paretns[n] = node
                processed += node
            }
        }
    } else {
        break
    }
    node = getLowestCostNode(costs)
}