package cauBlackHole.photoragephoto.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Photo (
    @Id @GeneratedValue var id: Long? = null,
    var albumId: Long,
    var memberId: Long,
    var imageUrl: String,
)