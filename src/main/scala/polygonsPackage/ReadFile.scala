package polygonsPackage

import scalafx.scene.control.TextField

import scala.io.Source



class ReadFile(fileNameField: TextField) {

    def readFile(path: String): List[(Int, Int)] = {
        val filename = path
        val listPoints = for (line <- Source.fromFile(filename).getLines) yield {
            val lineSplit: Array[String] = line.split(" ")
            (lineSplit(0).toInt, lineSplit(1).toInt)

        }
        listPoints.toList
    }



}
