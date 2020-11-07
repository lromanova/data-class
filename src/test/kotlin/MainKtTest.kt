import org.junit.Test

import org.junit.Assert.*

class MainKtTest {



    @Test
    fun createPost() {
        val wallservice: WallService = WallService()
        val postService: PostService = PostService()
        val ownerId = 1
        val createdBy = 2
        val fromId = 3
        val date = 12359737
        val text = "some post number1"

        val postId =  wallservice.getNextPostID()

        val postToAdd= postService.createPost(postId,ownerId, fromId, createdBy, date, text,null)

        assertEquals(postId,postToAdd.id)
    }

    fun createPostWithAudioAtachment() {
        val wallservice: WallService = WallService()
        val postService: PostService = PostService()
        val ownerId = 1
        val createdBy = 2
        val fromId = 3
        val date = 12359737
        val text = "some post number1"
        val audio1 = Audio(1,1)
        val audio2 = Audio(1,1)

        val postId =  wallservice.getNextPostID()
        var list: List<ContentInterface> = emptyList<ContentInterface>()
        list = list + audio1
        list = list + audio2

        val postToAdd= postService.createPost(postId,ownerId, fromId, createdBy, date, text, list)

        val audios = postService.getAudios(postToAdd)

        assertEquals(audios.size, 2)
    }
}