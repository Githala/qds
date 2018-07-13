package nl.arnedeboth.qds

import com.google.cloud.datastore.{Entity, ReadOption}
import nl.arnedeboth.qds.QDatastoreInit.datastore

class QDatastore[T](entityBuilder: EntityConverter[T]) {
  def save(obj: T) = {
    val entity = entityBuilder.toEntity(obj)
    datastore.put(entity)
  }

  def getById(id: String): T = {
    val key = entityBuilder.createKeyFrom(id)
    val obj: Entity = datastore.get(key, ReadOption.eventualConsistency())
    entityBuilder.fromEntity(obj)
  }

  def getById(id: Long): T = ???
}
