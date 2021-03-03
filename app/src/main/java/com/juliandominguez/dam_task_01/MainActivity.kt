package com.juliandominguez.dam_task_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.juliandominguez.dam_task_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     * Mejora del manejo de findViewById
     * viewBinding permite solo acceder a los elementos de la vista asociada a la
     * actividad, evitando así sobre cargas o acceso indeseado a elementos de otras actividades
     */
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        /**
         * Se activa ek evento de clic en en btn send
         */
        this.viewBinding.btnSend.setOnClickListener {

            /**
             * Se captura el texto que fue digitado en edHeroe y se almacena en una
             * variable al hacer clic en el btn
             */
            var strHeroe: String = viewBinding.etNameHeroe.text.toString()

            /**
             * Se crea la notificación de forma antigua con Toast
             */
            // Toast.makeText(this,"Has enviado el valor: $strHeroe de forma correcta", Toast.LENGTH_LONG).show()

            /**
             * Se crea notificación de forma actual Snackbar
             */
            Snackbar.make(
                it,
                getString(R.string.notification, strHeroe),
                Snackbar.LENGTH_LONG
            ).setAnchorView(R.id.btn_send).show()
        }

    }
}