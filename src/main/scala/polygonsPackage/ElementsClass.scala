package polygonsPackage


import scalafx.scene.chart.{Axis, LineChart, NumberAxis, PieChart}
import scalafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control._
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.scene.layout.Pane
import scalafx.scene.shape.{Line, LineTo, MoveTo, Path}
import scalafx.scene.text.Font


@sfxml
class ElementsClass(val uploadButton: Button, val startButton: Button, val fileNameField: TextField, val inputCoorFiled: TextArea,
    var lineChart: LineChart[Number, Number], val labelArea: Label, val xaxis: NumberAxis, val yaxis: NumberAxis,
    val tabLineas: Tab, val paneLineas: Pane)  {


    val exampeText =
        """50,50
          |50,100
          |100,100
          |100,50""".stripMargin

    inputCoorFiled.setText(exampeText)


    // grafica
    xaxis.scaleX = 0.0
    yaxis.scaleY = 0.0

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

    // Calcular area. está en el xml
    def functionPlay(event: ActionEvent): Unit = {
        // calcula area, hace grafico y grafica poligonos

        val fileNameText = fileNameField.getText
        val pointsListInt: List[(Int, Int)] = if (fileNameText != "") {
            val readFileInstance = new ReadFile(fileNameField)
            val pointsListInt = readFileInstance.readFile(fileNameText)
            pointsListInt
        } else {
            val textPlain = inputCoorFiled.getText
            val pointsListInt: List[(Int, Int)] = textPlain.split("\n").map {
                x =>
                    val spl = x.split(",")
                    (spl(0).toInt, spl(1).toInt)
            }.toList
            pointsListInt
        }

        pointsListInt.foreach(println)

        val graphLinesInstance = new GraphPointsAndLines(lineChart)
        graphLinesInstance.createLineChart(pointsListInt)

        val calculateAreaInstance = new CalculateArea()
        val area = calculateAreaInstance.calculateArea(pointsListInt)

        val genlinesInstance = new GenLines(paneLineas)
        genlinesInstance.genLine(pointsListInt, xaxis, yaxis)
        labelArea.setFont(Font.font ("Consolas", 16))
        labelArea.setText(s"El area es: ${area.toString}")

    }







}
