package polygonsPackage

import scalafx.scene.layout.Pane
import scalafx.scene.shape.Line
import polygonsPackage.CalculateArea

class GenLines(paneLineas: Pane) {


    def genLine(pointsListInt: List[(Int, Int)]) = {

        val pointsListsDouble = pointsListInt.map(x => (x._1.toDouble, x._2.toDouble))

        val pointsListsFinal = pointsListsDouble ++ List(pointsListsDouble(0))

        val calculateAreaInstance = new CalculateArea()
        val centerPoint = calculateAreaInstance.findCenterPoint(pointsListsFinal)

        val listLines: List[Line] = (0 to (pointsListsFinal.length - 1)).toList
            .map { x =>
                if (x >= 1) {
                    val genLine = new Line
                    val pointA = pointsListsFinal(x - 1)
                    val pointB = pointsListsFinal(x)
                    genLine.setStartX(pointA._1)
                    genLine.setStartY(pointA._2)
                    genLine.setEndX(pointB._1)
                    genLine.setEndY(pointB._2)

                    genLine

                } else {
                    new Line()
                }
            }

        val linesToCenter: List[Line] = (0 to (pointsListsFinal.length - 1)).toList
            .map { x =>
                if (x >= 0) {
                    val genLine = new Line
                    val pointA = pointsListsFinal(x)
                    val pointB = centerPoint
                    genLine.setStartX(pointA._1)
                    genLine.setStartY(pointA._2)
                    genLine.setEndX(pointB._1)
                    genLine.setEndY(pointB._2)
                    genLine.setOpacity(0.5)
                    genLine.getStrokeDashArray().addAll(2d)
                    genLine

                } else {
                    new Line()
                }
            }

        paneLineas.children = listLines ++ linesToCenter


    }

}
