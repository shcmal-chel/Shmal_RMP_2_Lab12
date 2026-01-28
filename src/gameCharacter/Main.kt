package gameCharacter

fun main() {
    val character = GameCharacter("Герой")

    printState(character.state)
    character.changeState(CharacterState.run)
    printState(character.state)
    character.changeState(CharacterState.attack(25))
    printState(character.state)
    character.changeState(CharacterState.dead("Неудачно запустил бочку с карбитом"))
    printState(character.state)
}

fun printState(state: CharacterState) {
    when (state) {
        CharacterState.passive -> println("Персонаж бездействует")
        CharacterState.run -> println("Персонаж бежит")
        is CharacterState.attack -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.dead -> println("Персонаж погиб: ${state.reason}")
    }
}