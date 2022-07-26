package cauBlackHole.photoragephoto.web.rest

import cauBlackHole.photoragephoto.web.rest.dto.PhotoResponseDTO
import cauBlackHole.photoragephoto.web.rest.dto.PhotoCreateDTO
import cauBlackHole.photoragephoto.web.rest.dto.PhotoDTO
import cauBlackHole.photoragephoto.web.rest.mapper.PhotoMapper
import cauBlackHole.photoragephoto.service.PhotoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PhotoResource (
    private val photoService: PhotoService,
    private val photoMapper: PhotoMapper,
) {
    @GetMapping("/photos/{id}")
    fun getPhoto(@PathVariable id: Long) = PhotoResponseDTO(
        photoMapper.toDto(
            photoService.getPhoto(id)
        )
    )

    @PostMapping("/photos")
    fun createPhoto(@ModelAttribute photoCreateDTO: PhotoCreateDTO) = PhotoResponseDTO(
        photoMapper.toDto(
            photoService.createPhoto(
                photoMapper.toEntity(
                    photoCreateDTO.images.map {
                        PhotoDTO(
                            null,
                            photoCreateDTO.albumId,
                            photoCreateDTO.memberId,
                            it.toString(),
                        )
                    }
                )
            )
        )
    )

}