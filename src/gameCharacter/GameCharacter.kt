package gameCharacter

class GameCharacter(
    val name: String,
    var state: CharacterState = CharacterState.passive
) {
    fun changeState(newState: CharacterState) {
        state = newState
    }
}