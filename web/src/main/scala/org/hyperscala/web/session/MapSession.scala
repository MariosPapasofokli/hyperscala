package org.hyperscala.web.session

/**
 * @author Matt Hicks <mhicks@powerscala.org>
 */
class MapSession extends Session {
  private var map = Map.empty[String, Any]

  def apply[T](name: String) = map(name).asInstanceOf[T]

  def get[T](name: String) = map.get(name).asInstanceOf[Option[T]]

  def update(name: String, value: Any) = if (value != null) {
    map += name -> value
  } else {
    remove(name)
  }

  def remove(name: String) = map -= name

  def clear() = map = Map.empty
}