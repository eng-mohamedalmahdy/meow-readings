import kotlin.math.max

data class Item(val name: String, val weight: Int, val price: Int)

val maxWeight = 4
val items = listOf(
    Item("Guitar", 1, 1500),
    Item("Laptop", 3, 2000),
    Item("Stereo", 4, 3000))

val grid = buildList<MutableList<Int>> {
    items.forEachIndexed { rowIdx, item ->
        val row = mutableListOf<Int>()
        repeat(maxWeight + 1) { col ->
            val oldBest = if (rowIdx > 0) this[rowIdx - 1][col] else 0
            val remPrice = if (rowIdx > 0 && col - item.weight >= 0) this[rowIdx - 1][col - item.weight] else 0
            val fitItem = if (item.weight <= col) item.price else 0
            row += max(fitItem + remPrice, oldBest)
        }
        add(row)
    }
}
grid.forEach(::println)
