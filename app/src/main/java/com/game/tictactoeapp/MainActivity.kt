package com.game.tictactoeapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.game.tictactoeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /* with binding we will access views in xml */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        hideSystemBars()
        btnStartGameOnClick()
    }

    /* we make our app fullscreen */
    private fun hideSystemBars() {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return
        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }

    /* we add on click listener to start button */
    private fun btnStartGameOnClick() {
        binding.btnStartGame.setOnClickListener {
            startGame()
        }
    }

    /* we open GameActivity */
    private fun startGame() {
        startActivity(Intent(this, GameActivity::class.java))
    }
}