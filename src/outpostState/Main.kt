package outpostState

import outpostState.OutpostManager
import outpostState.ObservableResource
import outpostState.StateStorage

fun main(){

    val manager = OutpostManager()

    println("\n--- Первое обращение к ресурсам ---")
    manager.printlAll()

    println("\n--- Изменение ресурсов ---")
    manager.add(ObservableResource(1,"Minerals",100))
    manager.add(ObservableResource(2,"Gas", 450))

    println("\n--- Состояние после изменений ---")
    manager.printlAll()

    println("\n--- Загрузка состояния ---")
    val load = StateStorage.load()

    println("Загруженные ресурсы:")
    load.forEach {
        println("${it.name}: ${it.amount}")
    }
}