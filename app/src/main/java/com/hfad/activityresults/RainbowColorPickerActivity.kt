package com.hfad.activityresults

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RainbowColorPickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rainbow_color_picker)
        val colorPickerClickListener = View.OnClickListener {
            when (it.id) {

                R.id.red_button -> dispatchRainbowColor(getString(R.string.red), R.color.red)

                R.id.orange_button -> dispatchRainbowColor(
                    getString(R.string.orange),
                    R.color.orange
                )

                R.id.yellow_button -> dispatchRainbowColor(
                    getString(R.string.yellow),
                    R.color.yellow
                )

                R.id.green_button -> dispatchRainbowColor(getString(R.string.green), R.color.green)

                R.id.blue_button -> dispatchRainbowColor(getString(R.string.blue), R.color.blue)

                R.id.indigo_button -> dispatchRainbowColor(
                    getString(R.string.indigo),
                    R.color.indigo
                )

                R.id.violet_button -> dispatchRainbowColor(
                    getString(R.string.violet),
                    R.color.violet
                )

                else -> {

                    Toast.makeText(this, getString(R.string.unexpected_color), Toast.LENGTH_LONG)
                        .show()

                }

            }
        }
        findViewById<View>(R.id.red_button).setOnClickListener(colorPickerClickListener)

        findViewById<View>(R.id.orange_button).setOnClickListener(colorPickerClickListener)

        findViewById<View>(R.id.yellow_button).setOnClickListener(colorPickerClickListener)

        findViewById<View>(R.id.green_button).setOnClickListener(colorPickerClickListener)

        findViewById<View>(R.id.blue_button).setOnClickListener(colorPickerClickListener)

        findViewById<View>(R.id.indigo_button).setOnClickListener(colorPickerClickListener)

        findViewById<View>(R.id.violet_button).setOnClickListener(colorPickerClickListener)
    }

    private fun dispatchRainbowColor(colorName: String, color: Int) {

        val intentOfThisClass = Intent()
        intentOfThisClass.putExtra(RAINBOW_COLOR_NAME, colorName)
            .putExtra(RAINBOW_COLOR, color)
        setResult(100, intentOfThisClass)
        finish()
        //onBackPressedDispatcher.onBackPressed()
    }

}