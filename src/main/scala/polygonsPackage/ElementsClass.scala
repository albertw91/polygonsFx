package polygonsPackage


import scalafx.scene.chart.{Axis, LineChart, PieChart}
import scalafx.scene.control._
import scalafxml.core.macros.sfxml
import scalafx.Includes._


@sfxml
class ElementsClass(val uploadButton: Button, val startButton: Button, val fileNameField: TextField, val inputCoorFiled: TextArea,
    var lineChart: LineChart[Number, Number])  {


    val axis: Axis[Number] = lineChart.getYAxis()
    axis.setAutoRanging(false)
    axis.setLayoutY(0.1)


    val graphLinesInstance = new GraphPointsAndLines(lineChart)
    graphLinesInstance.createLineChart()




}
