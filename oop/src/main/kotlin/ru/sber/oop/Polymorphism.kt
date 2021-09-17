package ru.sber.oop

interface Fightable {
    val powerType: String
    var healthPoints: Int
    val damageRoll: Int
        get() = (0..damageRoll).random()

    fun attack(opponent: Fightable): Int
}

//TODO: create class Player, Monster, Goblin here...

class Player(
    override val powerType: String, override var healthPoints: Int, override val damageRoll: Int,
    val name: String, var isBlessed: Boolean
) : Fightable {

    override fun attack(opponent: Fightable): Int {
        val damage: Int = damageRoll
        if (isBlessed) {
            opponent.healthPoints -= damage * 2
            return damage * 2
        }

        opponent.healthPoints -= damage
        return damage
    }
}

abstract class Monster : Fightable {
    abstract val name: String
    abstract val description: String

    override fun attack(opponent: Fightable): Int {
        val damage: Int = damageRoll

        opponent.healthPoints -= damage
        return damage
    }
}

fun Monster.getSalutation() = "hello, ${this.name}"

class Goblin(
    override val powerType: String,
    override var healthPoints: Int,
    override val name: String,
    override val description: String
) : Monster() {

    constructor(
        _powerType: String,
        _healthPoints: Int,
        _name: String,
        _description: String,
        _damageRoll: Int
                ) : this(
                    _powerType,
                    _healthPoints,
                    _name,
                    _description,
                ) {
                this.damageRoll = _damageRoll
             }

    override var damageRoll: Int = 0
        get() = (0..damageRoll).random() / 2

}

