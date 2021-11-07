package pro.it_dev.childgame.domain

import pro.it_dev.childgame.domain.BaseEntity

class Card(
    id:Long = -1,
    var name:String,
    var img:Int,
    var type:String,
    val sounds:LongArray = LongArray(5),
    val questions:LongArray = LongArray(5)
): BaseEntity(id) {
}