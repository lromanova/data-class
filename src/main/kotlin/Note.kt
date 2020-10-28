class Note(override val id: Int,override val ownerId: Int) : ContentInterface {

   override val type: ContentType = ContentType.NOTE
    var title: String =""
    var text: String =""
    var date: Int = 0
    var comments: Int = 0
    var readComments: Int =0
    var viewUrl: String =""

}