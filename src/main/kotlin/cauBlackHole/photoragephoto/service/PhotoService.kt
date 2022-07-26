package cauBlackHole.photoragephoto.service

import cauBlackHole.photoragephoto.web.rest.dto.PhotoDTO
import cauBlackHole.photoragephoto.web.rest.dto.PhotoUpdateDTO

interface PhotoService {
    fun getPhoto(id: Long): PhotoDTO

    fun createPhoto(photos: List<PhotoDTO>): List<PhotoDTO>

    fun updatePhoto(id: Long, photoUpdateDTO: PhotoUpdateDTO): PhotoDTO

    fun deletePhoto(id: Long)
}