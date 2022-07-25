package cauBlackHole.photoragephoto.repository

import cauBlackHole.photoragephoto.domain.Photo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PhotoRepository : CrudRepository<Photo, Long>