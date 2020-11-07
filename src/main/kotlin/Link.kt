class Link(override val id: Int,override val ownerId: Int): ContentInterface {
    override val type: ContentType = ContentType.LINK
    val title: String = ""
    val caption: String? = null
    val description: String = ""
    val previewPage: String = ""
    val previewUrl: String = ""

}