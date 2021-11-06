package pro.it_dev.childgame.repository

import domain.BaseEntity
import util.Resource
import kotlin.reflect.KClass

interface IRepository {
    fun initial(path:String)
    fun <T:BaseEntity>get(id: Long, type: KClass<T>): T
    fun <T:BaseEntity>getAll(type: KClass<T>, tag:String, intType:Int): List<T>

    fun <T:BaseEntity>put(model: T): Resource<Boolean>
    fun <T:BaseEntity>delete(entity: T)

    fun close()
}

