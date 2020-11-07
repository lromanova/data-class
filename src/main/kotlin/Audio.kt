class Audio(override val id: Int,override val ownerId: Int): ContentInterface {
    override val type: ContentType = ContentType.AUDIO
    val artist: String = ""
    val title: String =""
    val duration: Int = 0
    val url: String = ""
    val lyricsId: Int = 0
    val albumId: Int = 0
    val genreId: Int = 0
    val date: Int = 0
    val noSearch: Int? = null
    val isHq: Int = 0
}