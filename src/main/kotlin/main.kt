fun main (){
    val wallservice: WallService = WallService()

    val ownerId = 1
    val createdBy = 2
    val fromId = 3
    val date = 12359737
    val text = "some post number1"

    val postId =  wallservice.getNextPostID()

    val postToAdd1= createPost(postId,ownerId, fromId, createdBy, date, text)
    wallservice.add(postToAdd1)

    val postToAdd2= createPost(wallservice.getNextPostID(),ownerId, fromId, createdBy, date, text)
    wallservice.add(postToAdd2)

    val postToAUpdate= createPost(postId,ownerId + 1, fromId + 1, createdBy + 1, date, text + " updated")

    val res = wallservice.update(postToAUpdate)


}

fun createPost(postId:Int, ownerId: Int, fromId: Int, createdBy: Int, date: Int, text: String): Post  {

    val currentPost: Post = Post(id = postId,  ownerId = ownerId, fromId = fromId, createdBy = createdBy, date = date, text = text)

    return currentPost
}

