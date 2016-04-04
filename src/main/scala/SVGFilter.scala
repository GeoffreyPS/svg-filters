import java.io.{File, FileInputStream, FileOutputStream}

import jdk.internal.org.xml.sax.InputSource
import jdk.internal.util.xml.impl.XMLWriter
import org.xml.sax.helpers.XMLReaderFactory

object SVGStrokeFilter {
	//def main(args: Array[String]) : Unit = { println(function(inputSVG)}

	def function(svg: scala.xml.Elem) = println(svg)

  def functioname {
    val inputSVG = XML.loadFile("src/main/resources/svg/svg0.svg")
    val svgFile: File = File.createTempFile("exportsvg", "svg")
    val xr = XMLReaderFactory.createXMLReader
    val svgFilter: IsolateSVGFilter = new IsolateSVGFilter() // probably a custom class
    svgFilter.setParent(xr)


    val in: FileInputStream = new FileInputStream(inputSVG)
    val is = new InputSource(in)
    is.setSystemID(inputSVG.getAbsolutePath)

    val writer: XMLWriter = new XMLWriter
    writer.setOutputStream(new FileOutputStream(svgFile))

    layerFilter.setContentHandler(writer)
    layerFilter.parse(is)
    //call filters on stream

    in.close()
    svgFile // return finished file
  }
//	def handleNode(node: Node) = {
//		node match{
//			case _ \ "@stroke-width" => adjustLineWeight(node)
//			case node.child => handleNode(node.child) // pseudocode
//			case node.child == 0 => node // when node has no children
//		}
//
//		def adjustLineWeight(node: Node => new_node: Node) = {
//			string = (node \ "@stroke-width").text
//			handleString(string)
//			new_node = node.attributes("stroke-width") =
//		}
//		def handleString(string: String => (num: Float, units: String)) = {
//			val num = """(\d*\.\d*)\w*""".r
//			val units = """\d*\.\d*(\w*)""".r
//			(num, units)
//		}
//	}
//
//	def increase_value((num: Float, units: String), multiplier: Float => String ){
//		val msg = ""
//	}

}



//function parses the xml -- each element and its children

/*each element  gets matched 
-has line weight attribute -> gets changed
-has children -> recurse further
-has no children, return node

each element should get passed to an accumulator which will save/return the transformed svg.


