class Instrument(
    val instrumentType: InstrumentsType,
    val serialNumber: String,
    val price: Double,
    val specs: InstrumentSpecs,
)

data class InstrumentSpecs(val properties: Map<String, Any>) {

    fun getPropery(propertyName) = properties[propertyName]

    fun matches(other: InstrumentSpecs): Boolean {
        properties.forEach { (key, value) ->
            if (value != other.properties[key]) return false
        }
        return true
    }
}


class Inventory {
    private val inventory: MutableList<Instrument> = mutableListOf()

    fun addInstrument(instrumentsType: InstrumentsType, serialNumber: String, price: Double, spec: InstrumentSpecs) {
        val instrument = Instrument(instrumentsType, serialNumber, price, spec)
        inventory += instrument
    }

    fun search(specs: InstrumentSpecs) =
        inventory.filter { it.specs.matches(specs) }

    fun get(serialNumber: String) =
        inventory.first { it.serialNumber == serialNumber }
}

enum class InstrumentsType(val typeName: String) {
    GUITAR("Guitar")
    MANDOLIN("Mandolin")
}