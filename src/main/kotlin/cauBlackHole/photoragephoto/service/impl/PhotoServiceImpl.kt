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
    override fun getPhoto(id: Long) = photoMapper.toDto(photoRepository.findById(id).orElseThrow())

    override fun getAlbumPhotos(albumId: Long) = photoMapper.toDto(
        photoRepository.findAllByAlbumId(albumId)
    )

    override fun createPhoto(photos: List<PhotoDTO>) = photoMapper.toDto(
        photoRepository.saveAll(
            photoMapper.toEntity(photos)
        ).toList()
    )

    override fun updatePhoto(id: Long, photoUpdateDTO: PhotoUpdateDTO): PhotoDTO {
        var photo = photoRepository.findById(id).orElseThrow()
        photo.albumId = photoUpdateDTO.albumId
        return photoMapper.toDto(photoRepository.save(photo))
    }

    override fun deletePhoto(id: Long) = photoRepository.deleteById(id)
}

