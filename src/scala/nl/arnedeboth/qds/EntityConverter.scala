package nl.arnedeboth.qds

import com.google.cloud.datastore.{Entity, Key}

trait EntityConverter[T] {

  def toEntity(obj: T): Entity
  def fromEntity(entity: Entity): T

  def createKeyFrom(id: String): Key
}
