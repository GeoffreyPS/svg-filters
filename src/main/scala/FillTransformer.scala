/**
  * Created by geoff on 4/26/16.
  */
import scala.xml._

class FillTransformer(color: String, set: Set[String]) extends scala.xml.transform.RewriteRule {

  override def transform(n: Node): Seq[Node] = {
    val d = (n \ "@id").text
    n match {
      case set contains d =>
        addFill(elem, color)
      case other => other
    }
  }

  def addFill(n: Node, color: String): Elem = {
    n.asInstanceOf[Elem] % Attribute("fill", Text(color), Null)
  }
}
