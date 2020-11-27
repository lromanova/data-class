data class Note(override val id: Int,
           override val ownerId: Int,
           override val type: ContentType = ContentType.NOTE,
           val title: String = "",
           val text: String = "",
           val date: Int = 0,
           val comments: Int = 0,
           val readComments: Int = 0,
           val viewUrl: String = "") : ContentInterface