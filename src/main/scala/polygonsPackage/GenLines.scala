package polygonsPackage

import scalafx.scene.layout.Pane
import scalafx.scene.shape.Line

class GenLines() {


    def genLine(pointA: (Double, Double), pointB: (Double, Double)) = {

        val lineNew: Line = new Line()
        //lineNew.setLayoutY(50)
        //lineNew.setLayoutX(100)

        lineNew.setStartX(pointA._1)
        lineNew.setStartY(pointA._2)
        lineNew.setEndX(pointB._1)
        lineNew.setEndY(pointB._2)
        lineNew
    }

}
