package gameCharacter

sealed class CharacterState {

    object passive : CharacterState()

    object run : CharacterState()

    data class attack(val damage: Int) : CharacterState()

    data class dead(val reason: String) : CharacterState()
}

