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

    }
}