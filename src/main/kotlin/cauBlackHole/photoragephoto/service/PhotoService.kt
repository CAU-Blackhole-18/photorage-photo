package cauBlackHole.photoragephoto.service

import cauBlackHole.photoragephoto.domain.Photo
import cauBlackHole.photoragephoto.web.rest.dto.PhotoCreateDTO
import cauBlackHole.photoragephoto.web.rest.dto.PhotoResponseDTO

interface PhotoService {
    fun getPhoto(id: Long): Photo
    fun createPhoto(photos: List<Photo>): List<Photo>
    fun updatePhoto(photo: Photo): Photo
}