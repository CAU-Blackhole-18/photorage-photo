package cauBlackHole.photoragephoto.web.rest

import cauBlackHole.photoragephoto.web.rest.dto.PhotoResponseDTO
import cauBlackHole.photoragephoto.web.rest.dto.PhotoCreateDTO
import cauBlackHole.photoragephoto.web.rest.dto.PhotoDTO
import cauBlackHole.photoragephoto.service.PhotoService
import cauBlackHole.photoragephoto.web.rest.dto.PhotoUpdateDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PhotoResource (
    private val photoService: PhotoService,
) {
    @GetMapping("/photos/{id}")
    fun getPhoto(@PathVariable id: Long) = PhotoResponseDTO(photoService.getPhoto(id))

    @PostMapping("/photos")
    fun createPhoto(@ModelAttribute photoCreateDTO: PhotoCreateDTO) = PhotoResponseDTO(
        photoService.createPhoto(
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


    @PutMapping("/photos/{id}")
    fun updatePhoto(
        @PathVariable id: Long,
        @RequestBody photoUpdateDTO: PhotoUpdateDTO,
    ) = PhotoResponseDTO(photoService.updatePhoto(id, photoUpdateDTO))
}