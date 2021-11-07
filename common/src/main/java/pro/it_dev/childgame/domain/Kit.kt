package pro.it_dev.childgame.domain

class Kit(
    val params: Params = Params("", Params.DEFAULT_VALUE, Params.DEFAULT_VALUE, Params.DEFAULT_VALUE),
    var groups:LongArray = LongArray(0)
): BaseEntity(1)// всегда id 1 (синглтон!)