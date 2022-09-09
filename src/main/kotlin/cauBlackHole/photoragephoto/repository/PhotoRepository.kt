package cauBlackHole.photoragephoto.repository

import cauBlackHole.photoragephoto.domain.Photo
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PhotoRepository : PagingAndSortingRepository<Photo, String> {
    fun findAllByAlbumId(albumId: String): List<Photo>
}