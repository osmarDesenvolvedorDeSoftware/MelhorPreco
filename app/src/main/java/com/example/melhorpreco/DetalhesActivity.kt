package com.example.melhorpreco

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment

class DetalhesActivity : AppCompatActivity() {

        lateinit var textnormal: TextView
        lateinit var textpromo: TextView
        lateinit var textmelhor: TextView

    fun Double.format(digits: Int) = "%.${digits}f".format(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textnormal = findViewById(R.id.text_normal)
        textpromo = findViewById(R.id.text_promo)
        textmelhor = findViewById(R.id.text_melhorpreco)

      val bundle: Bundle? = intent.extras

      val precoNormal = bundle?.getString("precoNormal")
      val precoPromo = bundle?.getString("precoPromocao")

      textnormal.setText("Preco: R$$precoNormal")
      textpromo.setText("Promoção: R$${precoPromo}")

       val normal = precoNormal!!.toDouble()
       val promo = precoPromo!!.toDouble()


        val resultado = ((normal - promo) / normal) * 100

        if (normal < promo){
            textmelhor.setText("Preco: R$ $precoNormal")
        }else if(normal == promo){

            textmelhor.setText("Mesmo preço")

        }else{
            textmelhor.setText("Promoção R$$precoPromo com ${resultado.format(0)}% de desconto")
        }




    }

}


