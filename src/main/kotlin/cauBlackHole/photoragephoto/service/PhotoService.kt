package cauBlackHole.photoragephoto.service

import cauBlackHole.photoragephoto.web.rest.dto.PhotoDTO
import cauBlackHole.photoragephoto.web.rest.dto.PhotoUpdateDTO

interface PhotoService {
    fun getPhoto(id: String): PhotoDTO

    fun getAlbumPhotos(albumId: String): List<PhotoDTO>

    fun createPhoto(photos: List<PhotoDTO>): List<PhotoDTO>

    fun updatePhoto(id: String, photoUpdateDTO: PhotoUpdateDTO): PhotoDTO

    fun deletePhoto(id: String)
}