class WallService {
    private var currentId: Int = 0
    private var posts = emptyArray<Post>()

    fun getNextPostID (): Int {

        currentId += 1

        return currentId
    }

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update (postToUpdate: Post): Boolean{
        for ((index,post) in posts.withIndex()){
            if(post.id == postToUpdate.id){
               posts[index] = post.copy(id= postToUpdate.id, ownerId = postToUpdate.ownerId,fromId = postToUpdate.fromId,
                       createdBy = postToUpdate.createdBy, date = postToUpdate.date,text = postToUpdate.text,
                       replyOwnerId = postToUpdate.replyOwnerId,replyPostId = postToUpdate.replyPostId,
                       friendsOnly = postToUpdate.friendsOnly,comments = postToUpdate.comments,copyright = postToUpdate.copyright,
                       likes = postToUpdate.likes,reposts = postToUpdate.reposts,views = postToUpdate.views,
                       postType = postToUpdate.postType,signerId = postToUpdate.signerId,canPin = postToUpdate.canPin,
                       canDelete = postToUpdate.canDelete,canEdit = postToUpdate.canEdit,isPinned = postToUpdate.isPinned,
                       markedAsAds = postToUpdate.markedAsAds,isFavorite = postToUpdate.isFavorite,postponedId = postToUpdate.postponedId)
                return true
            }
        }
        return false
    }
}