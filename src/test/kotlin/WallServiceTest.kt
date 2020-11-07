import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun getNextPostID() {
        val testId = 1
        val wallservice: WallService = WallService()
        val nextPostId = wallservice.getNextPostID()

        assertEquals(testId,nextPostId)
    }

    @Test
    fun add() {
        val wallservice: WallService = WallService()

        val ownerId = 1
        val createdBy = 2
        val fromId = 3
        val date = 12359737
        val text = "test post to add"

        val postId =  wallservice.getNextPostID()

        val postToAdd= Post(postId,ownerId, fromId, createdBy, date, text)
        val postRes =  wallservice.add(postToAdd)

        assertEquals(postRes,postToAdd)
    }

    @Test
    fun updateReturnTrue() {
        val wallservice: WallService = WallService()

        val ownerId = 1
        val createdBy = 2
        val fromId = 3
        val date = 12359737
        val text = "test post to add"

        val postId =  wallservice.getNextPostID()

        val postToAdd1 = Post(postId,ownerId, fromId, createdBy, date, text)
        wallservice.add(postToAdd1)
        val postToAdd2 = Post(wallservice.getNextPostID(),ownerId, fromId, createdBy, date, text)
        wallservice.add(postToAdd2)

        val postToUpdate= Post(postId,ownerId + 1, fromId + 1, createdBy + 1, date, text + "updated")
        val res = wallservice.update(postToUpdate)

        assertTrue(res)
    }

    @Test
    fun updateReturnFalse() {
        val wallservice: WallService = WallService()

        val ownerId = 1
        val createdBy = 2
        val fromId = 3
        val date = 12359737
        val text = "test post to add"
        val postIdToUpdate = 33333

        val postId =  wallservice.getNextPostID()

        val postToAdd1 = Post(postId,ownerId, fromId, createdBy, date, text)
        wallservice.add(postToAdd1)
        val postToAdd2 = Post(wallservice.getNextPostID(),ownerId, fromId, createdBy, date, text)
        wallservice.add(postToAdd2)

        val postToUpdate= Post(postIdToUpdate,ownerId + 1, fromId + 1, createdBy + 1, date, text + "updated")
        val res = wallservice.update(postToUpdate)

        assertFalse(res)
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrow() {
        val wallservice: WallService = WallService()
        val ownerId = 1
        val createdBy = 2
        val fromId = 3
        val date = 12359737
        val text = "test post to add"
        val postId =  555

        val postToAdd = Post(postId,ownerId, fromId, createdBy, date, text)
        wallservice.add(postToAdd)

        val comment: Comment = Comment(postID = postId + 10,id=1, text = "test comment")
        wallservice.createComment(comment)

    }

    @Test
    fun shouldAddComment() {
        val wallservice: WallService = WallService()
        val ownerId = 1
        val createdBy = 2
        val fromId = 3
        val date = 12359737
        val text = "test post to add"
        val postId =  555

        val postToAdd = Post(postId,ownerId, fromId, createdBy, date, text)
        wallservice.add(postToAdd)

        val comment: Comment = Comment(postID = postId,id=1, text = "test comment")
        wallservice.createComment(comment)

    }
}