import scala.xml.XML

object SVGPrinter {
	def main(args: Array[String]) : Unit = { println(function(svg_original))}

	def function(svg: scala.xml.Elem) = println(svg)

	def handleNode(node: Node) = {
		node match{
			case _ \ "@stroke-width" => adjustLineWeight(node)
			case node.child => handleNode(node.child) // pseudocode
			case node.child == 0 => node
		}

		def adjustLineWeight(node: Node => new_node: Node) = {
			string = (node \ "@stroke-width").text
			handleString(string)
			new_node = node.attributes("stroke-width") = 
		}
		def handleString(string: String => (num: Float, units: String)) = {
			val num = """(\d*\.\d*)\w*""".r
			val units = """\d*\.\d*(\w*)""".r
			(num, units)
		}
	}

	def increase_value((num: Float, units: String), multiplier: Float => String ){
		val msg = ""
	}

	val svg_original = XML.loadFile("src/main/resources/svg/svg0.svg")
}



//function parses the xml -- each element and its children

/*each element  gets matched 
-has line weight attribute -> gets changed
-has children -> recurse further
-has no children, return node

each element should get passed to an accumulator which will save/return the transformed svg.


