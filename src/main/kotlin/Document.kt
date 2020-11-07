class Document(override val id: Int,override val ownerId: Int): ContentInterface {
    override val type: ContentType = ContentType.DOCUMENT
    var size: Int = 0
    val title: String =""
    val ext: String = ""
    val url: String = ""
    val date: Int = 0
    val docType: Int = 1

}