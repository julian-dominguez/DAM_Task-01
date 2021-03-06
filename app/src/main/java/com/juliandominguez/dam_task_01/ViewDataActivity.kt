package com.juliandominguez.dam_task_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juliandominguez.dam_task_01.`class`.Constant
import com.juliandominguez.dam_task_01.`class`.Hero
import com.juliandominguez.dam_task_01.databinding.ActivityViewDataBinding

class ViewDataActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityViewDataBinding

    /**
     * Se crean constantes con las llaves de los datos del intent
     */

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
        val hero: Hero = intent.getParcelable<Hero>(Constant.HERO_KEY) as Hero

        viewBinding.tvNameHeroA2.text = hero.nameHero
        viewBinding.rbPowerRatingA2.rating = hero.ratingPower
        viewBinding.ivFotoA2.setImageBitmap(hero.photo)

        viewBinding.fabReturn.setOnClickListener {
            finish()
        }


    }
}