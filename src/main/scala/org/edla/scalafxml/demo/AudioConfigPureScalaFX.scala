package org.edla.scalafxml.demo

import scalafx.Includes.jfxSingleSelectionModel2sfx
import scalafx.Includes.jfxStringBinding2sfx
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.IntegerProperty.sfxIntegerProperty2jfx
import scalafx.geometry.VPos
import scalafx.geometry.VPos.sfxEnum2jfx
import scalafx.scene.Scene
import scalafx.scene.control.CheckBox
import scalafx.scene.control.ChoiceBox
import scalafx.scene.control.Slider
import scalafx.scene.paint.Color
import scalafx.scene.paint.LinearGradient
import scalafx.scene.paint.Stop
import scalafx.scene.paint.Stop.sfxStop2jfx
import scalafx.scene.shape.Line
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Font
import scalafx.scene.text.FontWeight
import scalafx.scene.text.FontWeight.sfxEnum2jfx
import scalafx.scene.text.Text

object AudioConfigPureScalaFX extends JFXApp {

  val acModel = new AudioConfigModel()

  val genreChoiceBox = new ChoiceBox[String] {
    layoutX = 204
    layoutY = 154
    prefWidth = 93
    items = acModel.genres
  }

  stage = new PrimaryStage {
    title = "Audio Configuration"
    scene = new Scene {
      content = List(
        new Rectangle {
          width = 320
          height = 45
          fill = new LinearGradient(
            endX = 0.0,
            endY = 1.0,
            stops = List(
              Stop(0, Color.web("0xAEBBCC")),
              Stop(1, Color.web("0x6D84A3"))))
        },
        new Text {
          layoutX = 65
          layoutY = 12
          textOrigin = VPos.TOP
          fill = Color.WHITE
          text = "Audio Configuration"
          font = Font.font("SansSerif", FontWeight.BOLD, 20)
        },
        new Rectangle {
          x = 0
          y = 43
          width = 320
          height = 300
          fill = Color.rgb(199, 206, 213)
        },
        new Rectangle {
          x = 9
          y = 54
          width = 300
          height = 130
          arcWidth = 20
          arcHeight = 20
          fill = Color.WHITE
          stroke = Color.color(0.66, 0.67, 0.69)
        },
        new Text {
          layoutX = 18
          layoutY = 69
          textOrigin = VPos.TOP
          fill = Color.web("#131021")
          font = Font.font("SansSerif", FontWeight.BOLD, 18)
          text <== acModel.selectedDBs.asString + " dB"
        },
        new Slider {
          layoutX = 135
          layoutY = 69
          prefWidth = 162
          min = acModel.minDecibels
          max = acModel.maxDecibels
          value <==> acModel.selectedDBs
          disable <== acModel.muting
        },
        new Line {
          startX = 9
          startY = 97
          endX = 309
          endY = 97
          stroke = Color.color(0.66, 0.67, 0.69)
        },
        new Text {
          layoutX = 18
          layoutY = 113
          textOrigin = VPos.TOP
          fill = Color.web("#131021")
          text = "Muting"
          font = Font.font("SanSerif", FontWeight.BOLD, 18)
        },
        new CheckBox {
          layoutX = 280
          layoutY = 113
          selected <==> acModel.muting
        },
        new Line {
          startX = 9
          startY = 141
          endX = 309
          endY = 141
          stroke = Color.color(0.66, 0.67, 0.69)
        },
        new Text {
          layoutX = 18
          layoutY = 154
          textOrigin = VPos.TOP
          fill = Color.web("#131021")
          text = "Genre"
          font = Font.font("SanSerif", FontWeight.BOLD, 18)
        },
        genreChoiceBox)
    }
  }

  acModel.genreSelectionModel = genreChoiceBox.selectionModel()
  acModel.addListenerToGenreSelectionModel()
  acModel.genreSelectionModel.selectFirst
}