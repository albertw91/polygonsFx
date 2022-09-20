package polygonsPackage

import scala.math.{abs, sqrt}


class CalculateArea {

    private def _myPow(number: Double): Double = {
        number * number
    }

    private def _distanceBetweenPoints(pointA: (Double, Double), pointB: (Double, Double)): Double = {
        sqrt(_myPow(pointB._1 - pointA._1) + _myPow(pointB._2 - pointA._2))
    }

    private def _middlePoint(pointA: (Double, Double), pointB: (Double, Double)): (Double, Double) = {
        ((pointA._1 + pointB._1) / 2.0, (pointA._2 + pointB._2) / 2.0)
    }


    private def _findCenterPoint(pointsListsFinal: List[(Double, Double)]) = {
        val xMax: Double = pointsListsFinal.map(x => x._1).reduce {
            (x, y) => if (x > y) x else y
        }
        val xMin: Double = pointsListsFinal.map(x => x._1).reduce {
            (x, y) => if (x < y) x else y
        }
        val yMax: Double = pointsListsFinal.map(y => y._1).reduce {
            (x, y) => if (x > y) x else y
        }
        val yMin: Double = pointsListsFinal.map(y => y._1).reduce {
            (x, y) => if (x < y) x else y
        }

        //(xMin, 0), (xMax, 0), (0, yMin), (0, yMax)

        val middleX = _middlePoint((xMin, 0), (xMax, 0))

        val middleY = _middlePoint((0, yMin), (0, yMax))
        //val centerPoint = middlePoint(middleX, middleY)
        val centerPoint = (middleX._1, middleY._2)
        println(centerPoint)
        centerPoint
    }

    private def _distanceOrtogonal(pointA: (Double, Double), pointB: (Double, Double), pointP: (Double, Double)) = {
        //m = (y2 - y1) / (x2 - x1)
        var m = (pointB._2 - pointA._2) / (pointB._1 - pointA._1)
        println(List((pointB._2, pointA._2), (pointB._1, pointA._1)))
        println(m)
        if ((pointB._1 - pointA._1) == 0) m = 0

        if (m < 0) println("negativo")
        // y - y1 = m(x - x1)
        // y = m(x - x1) + y1
        // y = mx - (m pointA._1) + pointA._2
        // mx - y - m * pointA._1 + pointA._2 = 0
        // Ax + By + C = 0

        // y = mx + b
        // pointA._2 = m * pointA._1 + b
        // pointA._2 / m  - pointA = b    // pointA._2 - (m * pointA._1)

        // y = mx + (pointA._2 / pointA._1 - m)

        // y = mx + (pointA._2 - (m * pointA._1))

        val Ax = m
        val By = -1.0
        val C = pointA._2 - (m * pointA._1) // (pointA._2 / m) - pointA._1 // m * pointA._1 + pointA._2
        //if(C < 0) println("C negativo")

        // d = | Ax + By + C  / sqtr(A ** 2 + B ** 2) |
        println("ax, by")
        //println(myPow(Ax))
        //println(myPow(By))
        val numerador = (Ax * pointP._1) + (By * pointP._2) + C
        val denom = sqrt(_myPow(Ax) + _myPow(By))
        println(numerador)
        println(denom)
        val d = abs(numerador) / abs(denom)
        println("distancia")
        println(d)

        d
    }


    def calculateArea(pointsListInt: List[(Int, Int)]) = {

        val pointsListsDouble = pointsListInt.map(x => (x._1.toDouble, x._2.toDouble))

        val pointsListsFinal = pointsListsDouble ++ List(pointsListsDouble(0))


        val area = (0 to (pointsListsFinal.length - 1)).toList
            .map { x =>
                if (x >= 1) {
                    println((pointsListsFinal(x - 1), pointsListsFinal(x)))
                    val centerPoint = _findCenterPoint(pointsListsFinal)
                    val height = _distanceOrtogonal(pointsListsFinal(x - 1), pointsListsFinal(x), centerPoint)
                    val base = _distanceBetweenPoints(pointsListsFinal(x - 1), pointsListsFinal(x))
                    val indArea = (height * base) / 2.0
                    //if (compareSlope(pointsListsFinal(x), pointsListsFinal(x-1), pointsListsFinal(0), pointsListsFinal.lift(x + 1 ))){
                    //    0.0
                    //val indArea = triangleAlgorithmTwo(pointsListsFinal(x), pointsListsFinal(x+1))
                    // um += x[i+1]*y[i] - x[i]*y[i+1]
                    //
                    indArea
                } else {
                    //val indArea = (height * base) / 2.0
                    //indArea
                    0.0
                }
                //}
                //else 0.0
            }.foldLeft(0.0)((a, b) => a + b) // + triangleAlgorithmFinal(pointsListsFinal(0), pointsListsFinal(pointsListsFinal.length - 2)) // x[0]*y[n-1] - x[n-1]*y[0] // .reduce(_ + _)

        val areaFormat = "%.1f".format(area).toDouble
        println("area total")
        println(areaFormat)
        areaFormat

    }

}
