package outpostState

import outpostState.ObservableResource

class OutpostManager {

    private val resources = mutableListOf<ObservableResource>()

    fun add(resource: ObservableResource){
        resources.add(resource)
        println("Добавлен ресурс: ${resource.name}")
    }

    fun get(name: String): ObservableResource?{
        return resources.find{ it.name == name}
    }

    fun printlAll(){
        println("Ресурсы базы")
        resources.forEach { println("${it.name}: ${it.amount}") }
    }

    fun getAll(): List<ObservableResource> =resources.toList()

}