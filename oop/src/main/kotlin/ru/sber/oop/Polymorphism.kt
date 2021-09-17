package ru.sber.oop

interface Fightable {
    val powerType: String
    var healthPoints: Int
    val damageRoll: Int

    fun attack(opponent: Fightable): Int

    fun damageRoll() : Int = (0..damageRoll).random()
}

//TODO: create class Player, Monster, Goblin here...

class Player(override val powerType: String, override var healthPoints: Int, override val damageRoll: Int,
                val name : String, var isBlessed : Boolean) : Fightable {

    override fun attack(opponent: Fightable): Int {
        val damage : Int = damageRoll()
        if (isBlessed){
            opponent.healthPoints -= damage * 2
            return damage * 2
        }

        opponent.healthPoints -= damage
        return damage
    }
}

abstract class Monster : Fightable {
    abstract val name : String
    abstract val description : String

    override fun attack(opponent: Fightable): Int {
        val damage : Int = damageRoll()

        opponent.healthPoints -= damage
        return damage
    }
}

fun Monster.getSalutation() = "hello, ${this.name}"

class Goblin(
    override val powerType: String,
    override var healthPoints: Int,
    override val damageRoll: Int,
    override val name: String,
    override val description: String
) : Monster() {
    override fun damageRoll() : Int = (0..damageRoll).random() / 2
}

