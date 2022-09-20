package polygonsPackage

import scalafx.collections.ObservableBuffer
import scalafx.scene.chart.{LineChart, XYChart}


class GraphPointsAndLines(var lineChart: LineChart[Number, Number]) {


    def createLineChart(listPoints: List[(Int, Int)]) = {

        /*
        val dataRaw = List(
            (4, 24),
            (1, 23),
            (6, 36),
            (8, 45),
            (2, 14),
            (9, 43),
            (7, 22),
            (12, 25),
            (10, 17),
            (5, 34),
            (3, 15),
            (11, 29))

         */
        val dataRaw = listPoints

        val data = ObservableBuffer(dataRaw.map {
            //x =>  Tuple2(x.get("timestamp").get.toString, x.get("goal").get.toString)
            x => (x._1, x._2)
        }: _*).map { case (x, y) => XYChart.Data[Number, Number](x, y) }

        val series = XYChart.Series[Number, Number](name = "test", data = data)

        //lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.None)

        this.lineChart.getData.add(series)
        this.lineChart

    }

}
