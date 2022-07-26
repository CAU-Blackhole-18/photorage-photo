package cauBlackHole.photoragephoto.service.impl

import cauBlackHole.photoragephoto.domain.Photo
import cauBlackHole.photoragephoto.repository.PhotoRepository
import cauBlackHole.photoragephoto.service.PhotoService
import org.springframework.stereotype.Service

@Service
class PhotoServiceImpl(private val photoRepository: PhotoRepository) : PhotoService {
    override fun getPhoto(id: Long): Photo = photoRepository.findById(id).orElseThrow()
    override fun createPhoto(photos: List<Photo>) = photoRepository.saveAll(photos).toList()
    override fun updatePhoto(photo: Photo): Photo = photoRepository.save(photo)
}

