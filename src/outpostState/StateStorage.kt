package outpostState

import outpostState.ObservableResource
import java.io.File

object StateStorage{
    private const val FILE_NAME = "outpost_state.txt"
    fun save(resource: List<ObservableResource>){
        val file = File(FILE_NAME)
        file.writeText(resource.joinToString ("\n"){
            "${it.id.toString().padEnd(3)} | ${it.name.padEnd(10)} | ${it.amount}"
        }
        )
        println("Состояние базы сохранено в файл")
    }
    fun load(): List<ObservableResource>{
        val file =File(FILE_NAME)
        if(!file.exists()) return emptyList()
        println("Загрузка состояния базы из файла")
        return file.readLines().map{
            val (id,name,amount) = it.split(";")
            ObservableResource(id.toInt(), name, amount.toInt())
        }
    }
}