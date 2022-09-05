import java.util.Timer
import java.util.TimerTask

data class DogDoor(var open: Boolean = false, private var allowedBarks: MutableList<Bark> = mutableListOf<Bark>()) {

    fun addAllowedBark(newBark: Bark) {
        allowedBarks += newBark
    }

    fun getAllowedBarks() = allowedBarks

    fun open() {
        open = true
        println("The door is open")
        val timer = Timer()
        val timerTask = object : TimerTask() {
            override fun run() {
                close()
            }
        }
        timer.schedule(timerTask, 5000)
    }

    fun close() {
        open = false
        println("The door is closed")
    }
}

data class Remote(val dogDoor: DogDoor) {
    fun pressButton() {
        if (dogDoor.open) dogDoor.close()
        else dogDoor.open()

    }
}

data class BarkRecoginzer(private val door: DogDoor) {
    fun recognize(bark: Bark) {
        door.getAllowedBarks().forEach {
            if (it == bark) {
                println("Found Voice ${bark.sound}")
                door.open()
                return
            }
        }
    }

}

data class Bark(val sound: String)

val dogDoor = DogDoor()
val remote = Remote(dogDoor)
val recoginzer = BarkRecoginzer(dogDoor)
dogDoor.addAllowedBark(Bark("Woof Woof"))
recoginzer.recognize(Bark("Woof Woof"))