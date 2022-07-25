package cauBlackHole.photoragephoto.web.rest.dto

import org.springframework.web.multipart.MultipartFile


data class PhotoCreateDTO (
    var albumId: Long,
    var memberId: Long,
    var images: List<MultipartFile>,
)