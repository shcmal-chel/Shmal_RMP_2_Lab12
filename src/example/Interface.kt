package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop(){
        println("Останавливаемся...")
    }
}
class Car(
    override val model: String,
    override val number: String
): Movable {
    override var speed = 60
    override fun move(){
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(
    override val model: String,
    override val number: String
): Movable {
    override var speed = 600
    override fun move(){
        println("Летим на самолете со скоростью $speed км/ч")
    }
    override fun stop()= println("Приземляемся...")
}
fun travel(obj: Movable) = obj.move()

interface Worker{
    fun work()
}
interface Student{
    fun study()
}
class WorkingStudent(val name: String) : Worker, Student {
    override fun work() = println("$name работает")
    override fun study() = println("$name учится")
}

interface VideoPlayable{
    fun play() = println("Play video")
}

interface AudioPlayable{
    fun play() = println("Play audio")
}
class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        println("Star playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }

}

fun main(){
//    val car: Movable = Car()
//    val aircraft: Movable = Aircraft()
//    travel(car)
//    travel(aircraft)

//    val ivan = WorkingStudent("Ivan")
//    ivan.work()
//    ivan.study()

//    aircraft.move()
//    aircraft.stop()

//    val car =Car("Nexia","Ч953МО")
//    val aircraft = Aircraft("Boeing","322")

    val player = MediaPlayer()
    player.play()
}

