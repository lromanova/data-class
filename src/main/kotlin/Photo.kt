class Photo(override val id: Int,override val ownerId: Int): ContentInterface {
    override val type: ContentType = ContentType.PHOTO
    var albumId: Int =0
    var userId: Int = 0
    var text: String =""
    var date: Int = 0
    var width: Int = 0
    var height: Int = 0
}