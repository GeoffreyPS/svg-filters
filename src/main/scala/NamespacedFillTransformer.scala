import scala.xml.{Node, NodeSeq}

/**
  * Created by geoff on 4/28/16.
  */
class NamespacedFillTransformer(color: String, namespace: String, attribute: String, set: Set[String]) extends FillTransformer(color: String, attribute: String, set: Set[String]) {
 override def checkID(n: Node, s: Set[String]): Boolean = {
   val id = (n \ generateID(n)).text
   s contains id
 }

  def generateID(n: Node): String = {
    val ns = n.getNamespace(namespace)
    s"@{$ns}$attribute"
  }
}
