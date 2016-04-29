/**
  * Created by geoff on 4/27/16.
  */
import org.scalatest._
import scala.xml.transform.RuleTransformer

class FillTransformerTest extends FlatSpec with Matchers {

  val originalXML: scala.xml.Node = <g id="example" stroke-width="0.15mm" stroke="#FFFF00">233.11</g>
  val untouchedXML: scala.xml.Node = <g id="not-in-set" stroke-width="0.15mm" stroke="#FFFF00">233.11</g>

  val idSet: Set[String] = Set("example")
  val attribute: String = "id"
  val rule = new RuleTransformer(FillTransformerGenerator("#FFFF99",  attribute, idSet))

  "FillTransformer" should "Add a fill color based on a set of IDs" in {
    val transformedXML = rule(originalXML)
    val newFillColor = transformedXML \ "@fill"

    assert(newFillColor.text == "#FFFF99")
  }

  "FillTransformer" should "not add a fill to XML elements outside of the set of IDs" in {
    val transformedXML = rule(untouchedXML)
    val fillColor = transformedXML \ "@fill"

    assert(fillColor.text == "")
  }

}
