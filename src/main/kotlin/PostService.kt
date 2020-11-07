class PostService {
    fun createPost(postId:Int, ownerId: Int, fromId: Int, createdBy: Int, date: Int, text: String, attachmentList: List<ContentInterface>?): Post  {

        val currentPost: Post = Post(id = postId,  ownerId = ownerId, fromId = fromId, createdBy = createdBy, date = date, text = text, attachments = attachmentList)

        return currentPost
    }

    fun getAudios(post: Post): List<Audio> {
        var audios = emptyList<Audio>()

        for ((index, attachment) in post.attachments?.withIndex()!!) {
            if (attachment.type == ContentType.AUDIO) {
                audios += attachment as Audio
            }
        }
        return audios
    }
}