import scala.io.Source
import scala.xml.{MetaData, NamespaceBinding, NodeSeq}
import scala.xml.parsing.ConstructingParser
import scala.xml.transform.RuleTransformer

/**
  * Created by Geoff on 5/1/16.
  */
class svgParser(input: Source, preserveWS: Boolean, rule: scala.xml.transform.RuleTransformer) extends ConstructingParser(input: Source, preserveWS: Boolean) {

  override def elem(pos: Int, pre: String, label: String, attrs: MetaData,
    pscope: NamespaceBinding, empty: Boolean, nodes: NodeSeq): NodeSeq = {
      rule.transform(super.elem(pos, pre, label, attrs, pscope, empty, nodes))
  }
}
