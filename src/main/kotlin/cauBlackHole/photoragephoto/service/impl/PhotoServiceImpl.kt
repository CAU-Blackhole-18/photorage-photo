package cauBlackHole.photoragephoto.service.impl

import cauBlackHole.photoragephoto.repository.PhotoRepository
import cauBlackHole.photoragephoto.service.PhotoService
import cauBlackHole.photoragephoto.web.rest.mapper.PhotoMapper
import cauBlackHole.photoragephoto.web.rest.dto.PhotoDTO
import cauBlackHole.photoragephoto.web.rest.dto.PhotoUpdateDTO
import org.springframework.stereotype.Service

@Service
class PhotoServiceImpl(
    private val photoRepository: PhotoRepository,
    private val photoMapper: PhotoMapper,
): PhotoService {
    override fun getPhoto(id: String) = photoMapper.toDto(photoRepository.findById(id).orElseThrow())

    override fun getAlbumPhotos(albumId: String) = photoMapper.toDto(
        photoRepository.findAllByAlbumId(albumId)
    )

    override fun createPhoto(photos: List<PhotoDTO>) = photoMapper.toDto(
        photoRepository.saveAll(
            photoMapper.toEntity(photos)
        ).toList()
    )

    override fun updatePhoto(id: String, photoUpdateDTO: PhotoUpdateDTO): PhotoDTO {
        var photo = photoRepository.findById(id).orElseThrow()
        photo.albumId = photoUpdateDTO.albumId
        return photoMapper.toDto(photoRepository.save(photo))
    }

    override fun deletePhoto(id: String) = photoRepository.deleteById(id)
}

