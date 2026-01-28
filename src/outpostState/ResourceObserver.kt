package outpostState
import kotlin.properties.Delegates

object ResourceObserver {
    fun logChange(resourceName: String, oldValue: Int, newValue: Int) {
        println("[Наблюдатель] $resourceName: $oldValue → $newValue")
    }
}

class ObservableResources(private val name: String, initialAmount: Int) {
    var amount: Int by Delegates.observable(initialAmount) { _, old, new ->
        println("Ресурс $name изменён: $old → $new")
        ResourceObserver.logChange(name, old, new)
    }
}
