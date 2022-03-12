import java.util.Deque
import java.util.LinkedList

val graph = mapOf<String, List<String>>(
    "A" to listOf("B", "C"),
    "B" to listOf("E"),
    "C" to listOf("D", "F"),
    "D" to listOf("E"),
    "F" to listOf("E"),
    "E" to listOf("G"),
    "G" to listOf<String>()
)
val dqueue: Deque<String> = LinkedList<String>()
val end = "G"
val start = "A"
dqueue.add(start)
print("Searching ")
while (dqueue.isNotEmpty()) {
    val value = dqueue.pop()
    print("$value ")
    if (graph[value]!!.contains(end)) {
        println("\nValue found")
        break
    } else {
        dqueue.addAll(graph[value]!!)
    }
}
