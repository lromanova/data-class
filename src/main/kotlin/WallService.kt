import java.lang.RuntimeException

class CommentNotFoundException(message: String): RuntimeException(message)

class WallService {
    private var currentId: Int = 0
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun getNextPostID (): Int {

        currentId += 1

        return currentId
    }

    fun createComment(comment: Comment) {
        var res: Boolean = false

        for ((index,post) in posts.withIndex()){
            if(post.id == comment.postID){
                comments += comment
                res = true
            }
        }

        if (!res) throw CommentNotFoundException("No post with id = ${comment.postID}")
    }

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update (postToUpdate: Post): Boolean{
        for ((index,post) in posts.withIndex()){
            if(post.id == postToUpdate.id){
               posts[index] = post.copy( ownerId = postToUpdate.ownerId, date = postToUpdate.date)
                return true
            }
        }
        return false
    }
}