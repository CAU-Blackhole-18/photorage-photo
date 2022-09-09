package cauBlackHole.photoragephoto.web.rest.dto

import org.springframework.web.multipart.MultipartFile


data class PhotoCreateDTO (
    var albumId: String,
    var memberId: String,
    var images: List<MultipartFile>,
)