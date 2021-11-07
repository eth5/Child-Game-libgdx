package pro.it_dev.childgame.domain

import pro.it_dev.childgame.domain.BaseEntity

class GroupCards(
    id: Long,
    var type: String
) : BaseEntity(id){
    var mainCard = -1
    val cards = mutableListOf<Int>()
}