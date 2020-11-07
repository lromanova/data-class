class Photo(override val id: Int,override val ownerId: Int): ContentInterface {
    override val type: ContentType = ContentType.PHOTO
    val albumId: Int =0
    val userId: Int = 0
    val text: String =""
    val date: Int = 0
    val width: Int = 0
    val height: Int = 0
}