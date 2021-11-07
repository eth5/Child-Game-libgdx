package pro.it_dev.childgame.domain

class Binary (
    id:Long,
    var name: String = "",
    var type: Type = Type.UNDEFINED,
    var tag:String? = null,
    var binary: ByteArray? = null
    ): BaseEntity(id){
    enum class Type{
        UNDEFINED,
        IMG,
        FX,
        SOUND,
        MUSIC
    }
}