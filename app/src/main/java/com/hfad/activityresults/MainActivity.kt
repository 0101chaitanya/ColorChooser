package com.hfad.activityresults

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

const val PICK_RANDOM_COLOR_INTENT = 1 //request code
const val RAINBOW_COLOR_NAME = "RAINBOW_COLOR_NAME"
const val RAINBOW_COLOR = "RAINBOW_COLOR"
const val DEFAULT_COLOR = "#FFFFFF"

class MainActivity : AppCompatActivity() {
    private var activityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d(TAG, "onActivityResult:")
        if (it.resultCode == 100) {
            val intent = it.data
            val colorName = intent?.getStringExtra(RAINBOW_COLOR_NAME)
            val color = intent?.getIntExtra(RAINBOW_COLOR, Color.parseColor(DEFAULT_COLOR))
                ?: Color.parseColor(DEFAULT_COLOR)
            val colorMessage = getString(R.string.color_chosen_message, colorName)
            val rainbowColor = findViewById<TextView>(R.id.rainbow_color).apply {
                setBackgroundColor(ContextCompat.getColor(this@MainActivity, color))
                text = colorMessage
                isVisible = true
            }

        }
    }

    private lateinit var submitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submitButton = findViewById(R.id.submit_button)
        submitButton.setOnClickListener {
            val intent = Intent(this, RainbowColorPickerActivity::class.java)
            activityLauncher.launch(intent)
        }
    }

    companion object {
        private const val TAG = "TAG"
    }
}