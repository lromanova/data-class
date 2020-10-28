class Document(override val id: Int,override val ownerId: Int): ContentInterface {
    override val type: ContentType = ContentType.DOCUMENT
    var size: Int = 0
    var title: String =""
    var ext: String = ""
    var url: String = ""
    var date: Int = 0
    var docType: Int = 1

}