package com.juliandominguez.dam_task_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Se llama el elemento EditText y button de la vista MainActivity mediante su Id
         */
        var edHeroe = findViewById<EditText>(R.id.et_nameHeroe)
        var btnSend = findViewById<Button>(R.id.btn_send)


        /**
         * Se activa ek evento de clic en en btn send
         */
        btnSend.setOnClickListener {

            /**
             * Se captura el texto que fue digitado en edHeroe y se almacena en una
             * variable al hacer clic en el btn
             */
            var strHeroe: String = edHeroe.text.toString()

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