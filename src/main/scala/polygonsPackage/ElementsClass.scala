package polygonsPackage


import scalafx.scene.chart.{Axis, LineChart, NumberAxis, PieChart}
import scalafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control._
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.scene.layout.Pane
import scalafx.scene.shape.{Line, LineTo, MoveTo, Path}


@sfxml
class ElementsClass(val uploadButton: Button, val startButton: Button, val fileNameField: TextField, val inputCoorFiled: TextArea,
    var lineChart: LineChart[Number, Number], val labelArea: Label, val xaxis: NumberAxis, val yaxis: NumberAxis,
    val tabLineas: Tab, val paneLineas: Pane)  {


    //val axis: Axis[Number] = lineChart.getYAxis()
    //axis.setAutoRanging(false)
    //axis.setLayoutY(0.1)


    yaxis.setAutoRanging(false)
    yaxis.setLowerBound(0)
    yaxis.setUpperBound(100)
    yaxis.setTickUnit(10)

    xaxis.setAutoRanging(false)
    xaxis.setLowerBound(0)
    xaxis.setUpperBound(100)
    xaxis.setTickUnit(10)



    //path.getElements().add(moveTo)
    //path.getElements().addAll(line1, line2)


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

        val calculateAreaInstance = new CalculateArea(paneLineas)
        val area = calculateAreaInstance.calculateArea(pointsListInt)

        labelArea.setText(s"El area es: ${area.toString}")

    }







}
