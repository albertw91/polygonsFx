package polygonsPackage

import scalafx.scene.layout.Pane
import scalafx.scene.shape.{Circle, Line}
import polygonsPackage.CalculateArea
import scalafx.geometry.Point2D
import scalafx.scene.chart.NumberAxis
import scalafx.scene.transform.{Affine, Transform}

class GenLines(paneLineas: Pane) {


    def genLine(pointsListInt: List[(Int, Int)], xaxis: NumberAxis, yaxis: NumberAxis ) = {


        def chartDisplayTransform(xaxis: NumberAxis, yaxis: NumberAxis): Transform  = {
            val affine = new Affine
            println("xaxis.getScale()")
            println(xaxis.getScale())

            affine.mxx = xaxis.getScale()
            affine.mxy = 0
            affine.tx = xaxis.getDisplayPosition(0)

            affine.myy = yaxis.getScale()
            affine.myx = 0
            affine.ty = yaxis.getDisplayPosition(0)

            affine

        }

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
                    genLine.getTransforms().setAll(chartDisplayTransform(xaxis, yaxis))
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
                    genLine.getTransforms().setAll(chartDisplayTransform(xaxis, yaxis))
                    genLine

                } else {
                    new Line()
                }
            }

        val circle = new Circle
        circle.setCenterX(50.0)
        circle.setCenterY(50.0)
        circle.radius = 5.0

        circle.getTransforms.setAll(chartDisplayTransform(xaxis, yaxis))

        val circleList = List(circle)

        //circleList.getTransforms().setAll(chartDisplayTransform(xaxis, yaxis))

        paneLineas.children = listLines ++ linesToCenter ++ circleList


    }

}
