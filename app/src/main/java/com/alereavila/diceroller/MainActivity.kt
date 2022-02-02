package com.alereavila.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //forma correcta
    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var diceImage3 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //FORMA CORRECTA
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)

        val resultText : TextView = findViewById(R.id.result_text)
        resultText.text=(1..100).random().toString()




        val rollButton: Button = findViewById(R.id.roll_button)
        val sumaButton: Button =findViewById(R.id.roll_button2)
        val giraDados : Button = findViewById(R.id.gira_button_dado)
        val textoPrueba : TextView = findViewById(R.id.texto_prueba)
        textoPrueba.text="Hola amigos"
        giraDados.setOnClickListener { rollDice() }
       rollButton.setOnClickListener { resultText.text=rollDiceGirarDado(8).toString() }

        sumaButton.setOnClickListener { resultText.text=rollDice2((resultText.text.toString()).toInt()).toString() }


    }
    private fun rollDice() {
        //val diceImage1: ImageView = findViewById(R.id.dice_image1)
        diceImage1.setImageResource(escogerImagen())

        //val diceImage2: ImageView = findViewById(R.id.dice_image2)
        diceImage2.setImageResource(escogerImagen())

        //val diceImage3: ImageView = findViewById(R.id.dice_image3)
        diceImage3.setImageResource(escogerImagen())
    }

    private fun rollDiceGirarDado(numero:Int) : Int{
        Toast.makeText(this, (1..100).random().toString(),
            Toast.LENGTH_SHORT).show()

        diceImage1.setImageResource(R.drawable.empty_dice)


        diceImage2.setImageResource(R.drawable.empty_dice)


        diceImage3.setImageResource(R.drawable.empty_dice)
        println("llega" +numero)
        return (1..100).random()

    }

    private fun rollDice2(numero:Int) : Int {
        print(numero)
        Toast.makeText(this, "Apretaste el botón",
            Toast.LENGTH_LONG).show()
    return numero+1
    }

    private fun escogerImagen () : Int {
        val drawableResource : Int = when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }
}