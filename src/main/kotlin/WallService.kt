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
               posts[index] = postToUpdate
                return true
            }
        }
        return false
    }
}