package example

import example.OrderStatus.Created
import example.OrderStatus.Paid
import example.OrderStatus.Shipped

sealed class NetworkResult {
    data class Succes(val data: String) : NetworkResult()
    data class Error(val message: String, val code: Int) : NetworkResult()
    object Loading : NetworkResult()
}
fun handleResult(result: NetworkResult){
    when(result) {
        is NetworkResult.Succes -> {
            println("Успех: ${result.data}")
        }

        is NetworkResult.Error -> {
            println("Ошибка ${result.code}: ${result.message}")
        }

        NetworkResult.Loading -> {
            println("Загрузка...")
        }
    }
}

sealed class OrderStatus{
    object Created: OrderStatus()
    object Paid : OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()
}

fun handleOrder(status: OrderStatus){
    when (status){
        Created -> println("Заказ создан")
        Paid -> println("Заказ оплачен")
        Shipped -> println("Заказ отправлен")
        is OrderStatus.Cancelled -> println("Отменен: ${status.reason}")
    }
}

fun main(){
//    val success = NetworkResult.Succes("Данные получены")
//    val error = NetworkResult.Error("Сервер не отвечает",500)
//    val loading = NetworkResult.Loading
//    handleResult(success)
//    handleResult(error)
//    handleResult(loading)

    handleOrder(OrderStatus.Created)
    handleOrder(Paid)
    handleOrder(Shipped)
    handleOrder(OrderStatus.Cancelled("Нет товара на складе"))
}