import java.lang.RuntimeException
import java.time.LocalDate

class NoteNotFoundException(message: String) : RuntimeException(message)


class ContentService(private val userId: Int) {
    //private var noteCollection: MutableMap<Int, Note> = emptyMap<Int, Note>() as MutableMap<Int, Note>
    //private var commentCollection: MutableMap<Int, NoteComment> = emptyMap<Int, NoteComment>() as MutableMap<Int, NoteComment>
    //private var deletedCommentCollection: MutableMap<Int, NoteComment> = emptyMap<Int, NoteComment>() as MutableMap<Int, NoteComment>

    private var noteCollection: MutableMap<Int, Note> = mutableMapOf<Int,Note>()
    private var commentCollection: MutableMap<Int, NoteComment> = mutableMapOf<Int,NoteComment>()
    private var deletedCommentCollection: MutableMap<Int, NoteComment> = mutableMapOf<Int,NoteComment>()


    private var currentINoteId: Int = 0
    private var currentCommentId: Int = 0

    private fun getNextNoteID(): Int {

        currentINoteId += 1

        return currentINoteId
    }

    private fun getNextCommentID(): Int {

        currentCommentId += 1

        return currentCommentId
    }

    fun add(title: String, text: String, privacyView: String = "all", privacyComment: String = "all"): Note {
        val note = Note(getNextNoteID(), ownerId = userId,
                type = ContentType.NOTE, title = title, text = text, date = LocalDate.now().toEpochDay().toInt())
        noteCollection[note.id] = note

        return note
    }

    fun edit(id: Int, title: String, text: String, privacyView: String = "all", privacyComment: String = "all"): Boolean {
        if (noteCollection.containsKey(id)) {
            val note = noteCollection[id]
            noteCollection.replace(id, note!!.copy(title = title, text = text))
            return true
        } else throw NoteNotFoundException("No note with id = $id")

    }

    fun get(): MutableMap<Int, Note> {

        return noteCollection
    }

    fun getById(id: Int, needWiki: Boolean = false): Note {
        if (noteCollection.containsKey(id)) {
            return noteCollection[id]!!
        } else throw NoteNotFoundException("No note with id = $id")
    }

    fun delete(id: Int): Boolean {
        if (noteCollection.containsKey(id)) {
            noteCollection.remove(id)

            deletedCommentCollection.putAll(commentCollection.filterNot {item: Map.Entry<Int, NoteComment> -> item.value.noteId == id})
            commentCollection = commentCollection.filterNot {item: Map.Entry<Int, NoteComment> -> item.value.noteId == id}.toMutableMap()

            return true
        } else throw NoteNotFoundException("No note with id = $id")
    }

    fun createComment(noteId: Int, replyTo: Int = 0, message: String): NoteComment {
        if (noteCollection.containsKey(noteId)) {
            val comment = NoteComment(noteId = noteId, ownerId = userId, replyTo = replyTo, message = message, guid = getNextCommentID())
            commentCollection.put(comment.guid, comment)
            return comment
        } else throw NoteNotFoundException("No note with id = $noteId")
    }

    fun deleteComment(commentId:Int): Boolean {
        if (commentCollection.containsKey(commentId)) {
            deletedCommentCollection.put(commentId,commentCollection.getValue(commentId))
            commentCollection.remove(commentId)
            return true
        } else throw CommentNotFoundException("No comment with id = $commentId")
    }

    fun editComment(commentId: Int, message:String): Boolean {
        if (commentCollection.containsKey(commentId)) {
            val comment = commentCollection[commentId]
            commentCollection.replace(commentId, comment!!.copy(message = message))
            return true
        } else throw CommentNotFoundException("No comment with id = $commentId")
    }
    fun restoreComment(commentId: Int): Boolean {
        if (deletedCommentCollection.containsKey(commentId)) {
            commentCollection.put(commentId,deletedCommentCollection.getValue(commentId))
            deletedCommentCollection.remove(commentId)
            return true
        } else throw CommentNotFoundException("No comment with id = $commentId")
    }

    fun getComments (noteId: Int): Map<Int,NoteComment> {
        return commentCollection.filter { item: Map.Entry<Int, NoteComment> -> item.value.noteId == noteId}

    }
}