import javax.swing.text.View

data class Post(val id: Int,
                val ownerId: Int,
                val fromId: Int,
                val createdBy: Int,
                val date: Int,
                val text: String,
                val replyOwnerId: Int,
                val replyPostId: Int,
                val friendsOnly: Boolean = false,
                val comments: Comments,
                val copyright: String,
                val likes: Likes,
                val reposts: Reposts,
                val views: Views,
                val postType: String = "post",
                val signerId: Int,
                val canPin: Boolean = false,
                val canDelete: Boolean = false,
                val canEdit: Boolean = false,
                val isPinned: Boolean = false,
                val markedAsAds: Boolean = false,
                val isFavorite: Boolean = false,
                val postponedId: Int = 0
)
{

}