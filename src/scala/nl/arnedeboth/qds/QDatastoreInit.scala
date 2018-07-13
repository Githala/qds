package nl.arnedeboth.qds

import com.google.cloud.datastore.{Datastore, DatastoreOptions}

object QDatastoreInit {
  private val datastoreOptions: DatastoreOptions = DatastoreOptions.getDefaultInstance
  val datastore: Datastore = datastoreOptions.getService
  val entityBuilders: List[EntityConverter[_]] = List(new FooEntityConverter)
}
