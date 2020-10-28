class Link(override val id: Int,override val ownerId: Int): ContentInterface {
    override val type: ContentType = ContentType.LINK
    var title: String = ""
    var caption: String? = null
    var description: String = ""
    var previewPage: String = ""
    var previewUrl: String = ""

}