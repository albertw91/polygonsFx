package polygonsPackage


import scalafx.scene.chart.{Axis, LineChart, PieChart}
import scalafx.event.{ActionEvent, EventHandler}

import scalafx.scene.control._
import scalafxml.core.macros.sfxml
import scalafx.Includes._


@sfxml
class ElementsClass(val uploadButton: Button, val startButton: Button, val fileNameField: TextField, val inputCoorFiled: TextArea,
    var lineChart: LineChart[Number, Number], val labelArea: Label)  {


    val axis: Axis[Number] = lineChart.getYAxis()
    axis.setAutoRanging(false)
    axis.setLayoutY(0.1)


    def functionPlay(event: ActionEvent): Unit = {
        println("en funcion")
        val textPlain = inputCoorFiled.getText
        val pointsListInt: List[(Int, Int)] = textPlain.split("\n").map {
            x =>
                val spl = x.split(",")
                (spl(0).toInt, spl(1).toInt)
        }.toList
        pointsListInt.foreach(println)

        val graphLinesInstance = new GraphPointsAndLines(lineChart)
        graphLinesInstance.createLineChart(pointsListInt)

        val calculateAreaInstance = new CalculateArea
        val area = calculateAreaInstance.calculateArea(pointsListInt)

        labelArea.setText(s"El area es: ${area.toString}")

    }







}
