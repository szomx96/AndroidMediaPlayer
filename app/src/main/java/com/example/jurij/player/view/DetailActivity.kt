package com.example.jurij.player.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.jurij.player.R

import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    private lateinit var player: MediaPlayer

    private var author: TextView? = null
    private var title: TextView? = null
    private var coloredBackground: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val i = intent
        val authorExtra = i.getStringExtra(EXTRA_AUTHOR)
        val titleExtra = i.getStringExtra(EXTRA_TITLE)
        val drawableResourceExtra = i.getIntExtra(EXTRA_COLOR, 0)
        val uriExtra = i.getStringExtra(EXTRA_URI)

        author = findViewById<View>(R.id.txt_author) as TextView
        author!!.text = authorExtra

        title = findViewById<View>(R.id.txt_title) as TextView
        title!!.text = titleExtra


        coloredBackground = findViewById(R.id.imv_colored_background)
        coloredBackground!!.setBackgroundResource(
            drawableResourceExtra
        )


        player = MediaPlayer.create(this, Uri.parse(uriExtra))
        player.isLooping = false

        buttonPlay.setOnClickListener {
            player.start()
        }

        buttonPause.setOnClickListener {
            player.pause()
        }

        buttonStop.setOnClickListener {
            player.stop()
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStop() {
        super.onStop()
        player?.release()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }


    companion object {

        private val EXTRA_AUTHOR = "EXTRA_AUTHOR"
        private val EXTRA_TITLE = "EXTRA_TITLE"
        private val EXTRA_COLOR = "EXTRA_COLOR"
        private val EXTRA_URI = "EXTRA_URI"
    }
}
