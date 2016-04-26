/**
  * Created by geoff on 4/26/16.
  */
import scala.xml._

class FillTransformer(color: String, set: Set[String]) extends scala.xml.transform.RewriteRule {

  def addFill(n: Node, color: String): Elem = {
    n.asInstanceOf[Elem] % Attribute("fill", Text(color), Null)
  }
}
