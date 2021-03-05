package com.juliandominguez.dam_task_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juliandominguez.dam_task_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSend.setOnClickListener {


            val intent = Intent(this, ViewDataActivity::class.java)

            /**
             * Se capturan los datos de la vista principal
             */
            val nameHero: String = viewBinding.etNameHeroe.text.toString()
            val powerHero: Float = viewBinding.rbRatingPower.rating

            /**
             * Se almacenan los valores para pasarlos de la activity principal a la secundaria.
             */
            intent.putExtra(ViewDataActivity.HERO_HEY, nameHero)
            intent.putExtra(ViewDataActivity.POWER_HERO_KEY, powerHero)
            /**
             * Se lanza la segunda vista
             */
            startActivity(intent)
        }

    }
}