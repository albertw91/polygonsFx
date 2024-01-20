package polygonsPackage

import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafxml.core.{DependenciesByType, FXMLView, NoDependencyResolver}
import scalafx.Includes._


object interfaz extends JFXApp3 {

    override def start(): Unit = {

        val resource = getClass.getResource("fxmlElements.fxml")

        val root = FXMLView(resource, NoDependencyResolver)

        stage = new JFXApp3.PrimaryStage {
            title.value = "Calculate Area"


            /** Metodos reactivos de los botones
             *
             */

            /** Declaracion de la escena
             *
             */
            scene = new Scene(root) {
                //stylesheets = List(getClass.getResource("style.css").toExternalForm)
            }

        }
        stage.centerOnScreen()
        stage.show()
    }
}
