import org.junit.Test

import org.junit.Assert.*

class ContentServiceTest {

    @Test
    fun addNote() {
        val service: ContentService = ContentService(userId = 15)
        val note = service.add(title = "note_1", text = "text of note 1")
    }

    @Test
    fun editExistingNote() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")
        val note2 = service.add(title = "note_2", text = "text of note 2")

        val res = service.edit(note2.id,"updated_title_2","updatetd text 2")

        assertTrue(res)
    }

    @Test(expected = NoteNotFoundException::class)
    fun editNotExistingNote() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")
        val note2 = service.add(title = "note_2", text = "text of note 2")

        val res = service.edit(111,"updated_title_2","updatetd text 2")
    }


    @Test
    fun getById() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")
        val note2 = service.add(title = "note_2", text = "text of note 2")

        val resNote = service.getById(note1.id)

        assertEquals(note1,resNote)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getByNotExistingId() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")
        val note2 = service.add(title = "note_2", text = "text of note 2")

        val resNote = service.getById(111)
    }

    @Test
    fun deleteNoteWithoutComments() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")
        val note2 = service.add(title = "note_2", text = "text of note 2")

        val res = service.delete(note1.id).apply {

            assertTrue(this)
        }
    }

    @Test
    fun deleteNoteWithComments() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")
        val note2 = service.add(title = "note_2", text = "text of note 2")

        val comment1 =  service.createComment(noteId = note1.id,message = "comment1")
        val comment2 =  service.createComment(noteId = note2.id,message = "comment2")

        val res = service.delete(note1.id)

        assertTrue(res)

        assertEquals(comment2,service.getComments(note2.id).get(comment2.guid))
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteNotExistingNote() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")
        val note2 = service.add(title = "note_2", text = "text of note 2")

        val res = service.delete(666)
    }

    @Test
    fun createComment() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")

        val comment1 =  service.createComment(noteId = note1.id,message = "comment1")

    }

    @Test(expected = CommentNotFoundException::class)
    fun deleteNotExistingComment() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")

        val comment1 =  service.createComment(noteId = note1.id,message = "comment1")

        service.deleteComment(comment1.guid + 10)

    }

    @Test
    fun deleteComment() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")

        val comment1 =  service.createComment(noteId = note1.id,message = "comment1")
        val comment2 =  service.createComment(noteId = note1.id,message = "comment2")

        val res = service.deleteComment(comment1.guid)

        assertTrue(res)
    }

    @Test
    fun editComment() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")

        val comment1 =  service.createComment(noteId = note1.id,message = "comment1")

        val res = service.editComment(comment1.guid, "edited comment1")

        assertTrue(res)
    }
    @Test(expected = CommentNotFoundException::class)
    fun editNotExistingComment() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")

        val comment1 =  service.createComment(noteId = note1.id,message = "comment1")

        val res = service.editComment(comment1.guid+100, "edited comment1")

    }

    @Test
    fun restoreComment() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")

        val comment1 =  service.createComment(noteId = note1.id,message = "comment1")

        service.deleteComment(comment1.guid)
        val res = service.restoreComment(comment1.guid)

        assertTrue(res)
    }
    @Test(expected = CommentNotFoundException::class)
    fun restoreNotDeletedComment() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")

        val comment1 =  service.createComment(noteId = note1.id,message = "comment1")

        service.restoreComment(comment1.guid)

    }

    @Test
    fun getComments() {
        val service: ContentService = ContentService(userId = 15)
        val note1 = service.add(title = "note_1", text = "text of note 1")
        val note2 = service.add(title = "note_2", text = "text of note 2")

        service.createComment(noteId = note1.id,message = "comment1")
        service.createComment(noteId = note1.id,message = "comment2")
        service.createComment(noteId = note2.id,message = "comment3")


        val res = service.getComments(note1.id)

        assertEquals(res.count(),2)
    }
}