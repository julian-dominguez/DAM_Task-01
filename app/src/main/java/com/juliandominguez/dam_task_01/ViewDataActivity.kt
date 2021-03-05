package com.juliandominguez.dam_task_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juliandominguez.dam_task_01.databinding.ActivityViewDataBinding

class ViewDataActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityViewDataBinding

    /**
     * Se crean constantes con las llaves de los datos del intent
     */

    companion object{
        const val HERO_HEY = "hero_key"
        const val POWER_HERO_KEY = "power_hero_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityViewDataBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        /**
         * Tomo los valores que vienen de la activity principal
         */
        val intent:Bundle = intent.extras!!

        /**
         * Se setean los valores en la vista
         */
        viewBinding.tvNameHeroA2.text = intent.getString(HERO_HEY)
        viewBinding.rbPowerRatingA2.rating = intent.getFloat(POWER_HERO_KEY)
    }
}