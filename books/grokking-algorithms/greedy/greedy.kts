var neededStates
= mutableSetOf<String?>("mt", "wa", "or", "id", "nv", "ut", "ca", "az")
val stations = mapOf<String, MutableSet<String?>>(
    "kone" to mutableSetOf<String?>("id", "nv ", "ut"),
    "ktwo" to mutableSetOf<String?>("wa", "id", "mt"),
    "kthree" to mutableSetOf<String?>("or", "nv", "ca"),
    "kfour" to mutableSetOf<String?>("nv", "ut"),
    "kfive" to mutableSetOf<String?>("ca", "az"),
)

var finalStations = mutableSetOf<String?>()

while ((neededStates - finalStations).isNotEmpty()) {
    var bestStation: String? = null
    var statesCoverd = mutableSetOf<String?>()
    for ((station, states) in stations) {
        var covered: MutableSet<String?> = (neededStates intersect states) as MutableSet<String?>
        if (covered.size > statesCoverd.size) {
            bestStation = station
            statesCoverd = covered
        }
    }
    neededStates -= statesCoverd
    finalStations += bestStation
}
println(finalStations)