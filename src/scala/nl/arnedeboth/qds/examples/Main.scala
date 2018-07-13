package nl.arnedeboth.qds.examples

import nl.arnedeboth.qds.{FooEntityConverter, QDatastore}

object Main extends App {

  private val qds = new QDatastore[Foo](new FooEntityConverter)
  qds.save(Foo("id1", "bar"))

  private val foo: Foo = qds.getById("id1")
  println(foo)

}

case class Foo(id: String, value: String)