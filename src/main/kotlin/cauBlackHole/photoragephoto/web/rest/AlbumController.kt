package cauBlackHole.photoragephoto.web.rest

import cauBlackHole.photoragephoto.service.PhotoService
import cauBlackHole.photoragephoto.web.rest.dto.PhotoResponseDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/albums")
class AlbumController (private val photoService: PhotoService) {
    @GetMapping("/{albumId}")
    fun getAlbumPhotos(@PathVariable albumId: String) = PhotoResponseDTO(photoService.getAlbumPhotos(albumId))
}