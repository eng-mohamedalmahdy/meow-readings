import java.util.LinkedList

val products: MutableList<Pair<String, Int>> =
    mutableListOf(
        Pair("Chips", 5),
        Pair("Salts", 2),
        Pair("Apples", 7),
        Pair("Ice", 1))

fun hashFunction(string: String) = string.length
products.forEach {
    println(it)
    println(hashFunction(it.first))
}
val hashTable = Array<LinkedList<Int>>(50) { 0 }
products.forEach {
    val idx = hashFunction(it.first)
    hashTable[idx].add(it.second)
}
println("The price of chips is: ${hashTable[hashFunction("Chips")]}")