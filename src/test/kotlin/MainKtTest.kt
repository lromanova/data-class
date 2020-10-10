import org.junit.Test

import org.junit.Assert.*

class MainKtTest {



    @Test
    fun createPost() {
        val wallservice: WallService = WallService()
        val ownerId = 1
        val createdBy = 2
        val fromId = 3
        val date = 12359737
        val text = "some post number1"

        val postId =  wallservice.getNextPostID()

        val postToAdd= createPost(postId,ownerId, fromId, createdBy, date, text)

        assertEquals(postId,postToAdd.id)
    }
}