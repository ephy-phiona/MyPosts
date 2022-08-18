package dev.phiona.myposts


data class Post(var userId:String,
                var id:String,
                var title:String,
                var body:String)

data class Comment(var PostId:Int,
                  var Id: Int,
                  var name:String,
                  var email:String,
                  var body:String
                  )
fun <T> compareId(item1:T,item2:T) {
    var output=(item1.toString()+item2.toString())
    println(output)


}
