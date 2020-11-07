fun main (){
    val wallservice: WallService = WallService()
    val postService: PostService = PostService()

    val ownerId = 1
    val createdBy = 2
    val fromId = 3
    val date = 12359737
    val text = "some post number1"

    val postId =  wallservice.getNextPostID()

    val postToAdd1= postService.createPost(postId,ownerId, fromId, createdBy, date, text,null)
    wallservice.add(postToAdd1)

    val postToAdd2= postService.createPost(wallservice.getNextPostID(),ownerId, fromId, createdBy, date, text,null)
    wallservice.add(postToAdd2)

    val postToAUpdate= postService.createPost(postId,ownerId + 1, fromId + 1, createdBy + 1, date, text + " updated", null)

    val res = wallservice.update(postToAUpdate)


}



