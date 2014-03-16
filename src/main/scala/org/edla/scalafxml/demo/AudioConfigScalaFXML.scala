package org.edla.scalafxml.demo

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.text.Text
import scalafx.scene.control.Slider
import scalafx.scene.control.ChoiceBox
import scalafx.scene.control.CheckBox
import javafx.beans.binding.StringBinding

@sfxml
class AudioConfigPresenter(
    private val volume: Text,
    private val slider: Slider,
    private val genre: ChoiceBox[String],
    private val mute: CheckBox) {

  val acModel = new AudioConfigModel()
  genre.items = acModel.genres

  //mandatory
  import scalafx.Includes.jfxSingleSelectionModel2sfx
  acModel.genreSelectionModel = genre.selectionModel()
  acModel.addListenerToGenreSelectionModel()
  acModel.genreSelectionModel.selectFirst
  slider.min = acModel.minDecibels
  slider.max = acModel.maxDecibels
  slider.value <==> acModel.selectedDBs
  slider.disable <== acModel.muting
  volume.text <== acModel.selectedDBs.asString.concat(" dB")
  mute.selected <==> acModel.muting

}

import scalafxml.core.FXMLView
import scalafx.application.JFXApp
import scalafxml.core.NoDependencyResolver
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
//import scalafx.stage.Stage.sfxStage2jfx
//mandatory
import scalafx.Includes.jfxParent2sfx

object AudioConfigScalaFXML extends JFXApp {

  import java.io.IOException
  val resource = getClass.getResource("audio.fxml")
  if (resource == null) {
    throw new IOException("Cannot load resource: audio.fxml")
  }

  val root = FXMLView(resource, NoDependencyResolver)

  stage = new PrimaryStage() {
    title = "Audio Configurator"
    scene = new Scene(root)

  }
}