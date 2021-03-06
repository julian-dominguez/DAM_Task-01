package com.juliandominguez.dam_task_01

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import com.juliandominguez.dam_task_01.`class`.Constant
import com.juliandominguez.dam_task_01.`class`.Hero
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
            val heroPhoto: Bitmap = viewBinding.ivFoto.drawable.toBitmap()

            val hero = Hero(nameHero,powerHero, heroPhoto)

            intent.putExtra(Constant.HERO_KEY, hero)

            /**
             * Se almacenan los valores para pasarlos de la activity principal a la secundaria.
             */
//            intent.putExtra(ViewDataActivity.HERO_HEY, nameHero)
//            intent.putExtra(ViewDataActivity.POWER_HERO_KEY, powerHero)
            /**
             * Se lanza la segunda vista
             */
            startActivity(intent)
        }

        viewBinding.ivFoto.setOnClickListener{
            /**
             * Uso de intent implicito
             */
            val intentImplicito = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intentImplicito,Constant.REQUEST_CODE_PHOTO)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (Constant.REQUEST_CODE_PHOTO == requestCode && resultCode == Activity.RESULT_OK){
            val infoBundle: Bundle? = data?.extras
            val heroImage :Bitmap? = infoBundle?.getParcelable<Bitmap>("data")

            viewBinding.ivFoto.setImageBitmap(heroImage)
        }
    }
}