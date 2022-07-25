package cauBlackHole.photoragephoto.web.rest.dto

data class PhotoDTO (
    var id: Long?,
    var albumId: Long,
    var memberId: Long,
    var imageUrl: String,
)