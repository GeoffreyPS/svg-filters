/**
  * Created by geoff on 4/26/16.
  */
import scala.xml._

class FillTransformer(color: String, attribute: String, set: Set[String]) extends scala.xml.transform.RewriteRule {

  override def transform(n: Node): Seq[Node] = n match {
    case elem @ Elem(_, "g", _, _, _, _*) =>
      if (rightChild(elem)) addFill(elem, color)
      else elem
    case other => other
  }

  def rightChild(n: Node): Boolean = {
    n.child.exists(checkID(_, `set`))
  }

  def checkID(n: Node, s: Set[String]): Boolean = {
    val id = (n \ s"@$attribute").text
    s contains id
  }

  def addFill(n: Node, color: String): Elem = {
    n.asInstanceOf[Elem] % Attribute("fill", Text(color), Null)
  }
}
