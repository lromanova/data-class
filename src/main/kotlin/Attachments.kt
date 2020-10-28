class Attachments {

    private var contents = emptyArray<ContentInterface>()

    fun add(attachment: ContentInterface): ContentInterface {
        contents += attachment
        return contents.last()
    }

    fun get(): Array<ContentInterface>{
        return contents
    }

    fun get(type: ContentType):Array<ContentInterface> {
        var attachments = emptyArray<ContentInterface>()

        for ((index, attachment) in attachments.withIndex()) {
            if (attachment.type == type) {
                attachments += attachment
            }

        }
        return attachments
    }

    fun getAudios(): Array<Audio> {
        var audios = emptyArray<Audio>()

        for ((index, attachment) in contents.withIndex()) {
            if (attachment.type == ContentType.AUDIO) {
                audios += attachment as Audio
            }
        }
        return audios
    }

}