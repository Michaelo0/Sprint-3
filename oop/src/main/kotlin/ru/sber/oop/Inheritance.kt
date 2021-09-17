package ru.sber.oop

open class Room(open val name: String, open val size: Int) {

    protected open val dangerLevel = 5
    val goblin : Monster = Goblin("goblin power", 6,  "goblin", "just a goblin",3)

    fun description() = "Room: $name"

    open fun load() = goblin.getSalutation()

    constructor(_name : String) : this(name = _name, 100) {}

}

//TODO: create class TownSquare here...
class TownSquare(override val name: String = "Town Square", override val size: Int = 1000) : Room(name, size){

    override val dangerLevel = super.dangerLevel - 3
    final override fun load() = "TownSquare is loading"
}