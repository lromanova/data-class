data class NoteComment (
        val noteId: Int,
        val ownerId: Int,
        val replyTo: Int = 0,
        val message: String = "",
        val guid: Int
)