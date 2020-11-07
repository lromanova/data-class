data class Comment (
        val postID: Int = 0,
        val id: Int = 0,
        val fromId: Int = 0,
        val date: Int = 0,
        val text: String ="",
        val replyToUser: Int = 0,
        val replyToComment: Int = 0,
        val attachments: List<ContentInterface>? = null,
        val parrentStack: Array<Comment>? = null,
        val thread: Thread? = null
)