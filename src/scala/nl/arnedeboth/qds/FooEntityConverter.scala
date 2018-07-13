package nl.arnedeboth.qds

import com.google.cloud.datastore.{Entity, Key, KeyFactory}
import nl.arnedeboth.qds.QDatastoreInit.datastore
import nl.arnedeboth.qds.examples.Foo

class FooEntityConverter extends EntityConverter[Foo] {

  private val keyFactory: KeyFactory = datastore.newKeyFactory().setKind("Foo")

  override def toEntity(foo: Foo) = {
    val key = keyFactory.newKey(foo.id)
    Entity.newBuilder(key)
      .set("value", foo.value)
      .build()
  }

  override def fromEntity(entity: Entity): Foo = {
    Foo(entity.getKey.getName, entity.getString("value"))
  }

  override def createKeyFrom(id: String): Key = keyFactory.newKey(id)
}
