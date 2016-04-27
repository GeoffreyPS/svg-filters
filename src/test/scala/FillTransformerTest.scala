/**
  * Created by geoff on 4/27/16.
  */
import org.scalatest._
import scala.xml.transform.RuleTransformer

class FillTransformerTest extends FlatSpec with Matchers {

  val originalXML: scala.xml.Node = <g id="example" stroke-width="0.15mm" stroke="#FFFF00">233.11</g>

  val idSet: Set[String] = Set("example")

  "FillTransformer" should "Add a fill color based on a set of IDs" in {
    val rule = new RuleTransformer(new FillTransformer("#FFFF00", idSet))
    val transformedXML = rule(originalXML)
    val newFillColor = transformedXML \ "@fill"

    assert(newFillColor.text == "#FFFF00")
  }

}
