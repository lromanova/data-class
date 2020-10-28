class Audio(override val id: Int,override val ownerId: Int): ContentInterface {
    override val type: ContentType = ContentType.AUDIO
    var artist: String = ""
    var title: String =""
    var duration: Int = 0
    var url: String = ""
    var lyricsId: Int = 0
    var albumId: Int = 0
    var genreId: Int = 0
    var date: Int = 0
    var noSearch: Int? = null
    var isHq: Int = 0
}