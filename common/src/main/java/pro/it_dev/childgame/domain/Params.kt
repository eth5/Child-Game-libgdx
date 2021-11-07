package pro.it_dev.childgame.domain

import com.google.gson.annotations.Expose

data class Params(
    @Expose
    var name:String,
    @Expose
    var bg:Int,
    @Expose
    var mainColor:Int,
    @Expose
    var secondColor:Int
){
    companion object{
        public const val DEFAULT_VALUE = -1;
    }
}