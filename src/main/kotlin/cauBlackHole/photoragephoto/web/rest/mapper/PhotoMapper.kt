package cauBlackHole.photoragephoto.web.rest.mapper

import cauBlackHole.photoragephoto.domain.Photo
import cauBlackHole.photoragephoto.web.rest.dto.PhotoDTO
import org.mapstruct.Mapper

@Mapper
interface PhotoMapper: EntityMapper<PhotoDTO, Photo>