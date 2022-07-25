package cauBlackHole.photoragephoto.web.rest.dto

data class PhotoResponseDTO (
    var photos: List<PhotoDTO>
) {
    constructor(photo: PhotoDTO): this(listOf(photo))
}