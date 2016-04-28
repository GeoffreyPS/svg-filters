import scala.xml.{Node, NodeSeq}

/**
  * Created by geoff on 4/28/16.
  */
class NamespacedFillTransformer(color: String, namespace: String, attribute: String, set: Set[String]) extends FillTransformer(color: String, attribute: String, set: Set[String]) {
 override def checkID(n: Node, s: Set[String]): Boolean = {
   n.attribute(n.getNamespace(namespace), attribute) match {
     case id @ None =>
       false
     case id @ _ =>
       s contains id.head.text
   }
 }
}
