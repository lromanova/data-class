import javax.swing.text.View

data class Post(
                val id: Int,
                val ownerId: Int,
                val fromId: Int,
                val createdBy: Int,
                val date: Int,
                val text: String,
                val replyOwnerId: Int = 0,
                val replyPostId: Int = 0,
                val friendsOnly: Boolean = false,
                val comments: Comments = Comments(),
                val copyright: String ="",
                val likes: Likes = Likes(),
                val reposts: Reposts = Reposts(),
                val views: Views = Views(),
                val postType: String = "post",
                val signerId: Int = 0,
                val canPin: Boolean = false,
                val canDelete: Boolean = false,
                val canEdit: Boolean = false,
                val isPinned: Boolean = false,
                val markedAsAds: Boolean = false,
                val isFavorite: Boolean = false,
                val postponedId: Int = 0


)
{
    var postSource: PostSource? =null
    var geo: Geo? = null
    var copyHistory: CopyHistory? = null
    var attachments: Attachments = Attachments()
}
