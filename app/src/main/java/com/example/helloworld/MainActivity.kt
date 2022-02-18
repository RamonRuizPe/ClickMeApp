package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() { //Permite la compatibilidad de versiones, así como de JAVA con Kotlin

    private var editText: EditText? = null //Es el PlainText
    private var textView: TextView? = null

    private var numtimesclick = 0
    private val TAG = "MainActivity"
    private val TEXT = "TEXT_CONTENT"
    override fun onCreate(savedInstanceState: Bundle?) { //Bundle es la clase de JAVA que permite la transmisión de datos en la aplicación.
        Log.d(TAG,"OnCreate")
        //Por medio de Bundle persiste la información.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.t1_ramon) //R (Resources) es una super clase de donde se hereda lo demás.
        //En activity_main es donde se guardan las vistas.
        //En R.layout.[Aqui_va_el_XML_a_emplear]
        //Android tiene una memoria de las vistas que se tienen, por eso es posible regresar.

        val userInput: EditText = findViewById<EditText>(R.id.editText) //<EditText> indica el tipo de lo que estás obteniendo.
        val button: Button = findViewById<Button>(R.id.button)
        val buttonClean: Button = findViewById<Button>(R.id.buttonClean)
        textView = findViewById<TextView>(R.id.textView)



        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener(object :View.OnClickListener{ //El signo de interrogación indica que si no existe, no truene
            //La función se encarga de saber cuándo se está dando click y que se ejecute el código posterior.
            override fun onClick(p0: View?) { //El override lo usamos aquí para dar funcionalidad a la función OnClick
                Log.d(TAG,"onClick")
                //numtimesclick += 1
                //textView?.append("$numtimesclick click")
                //if (numtimesclick != 1){
                //    textView?.append("s")
                //}
                //textView?.append("\n")

                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.setText("") //Como se espera que el usuario lo modifique, se accede por medio de sets y gets
                //userInput.text.clear() //Función similar a la de setText("").

            }
        })

        buttonClean?.setOnClickListener(object: View.OnClickListener{

            override fun onClick(p0: View?) {
                textView?.text = ""
            }
        })

    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(TEXT,"xd")
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG,"onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, textView?.text.toString())
        //Si se coloca otro putstring se sobreescribe el anterior.
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
    //Existen 6 override functions que dan funcionalidad.
}