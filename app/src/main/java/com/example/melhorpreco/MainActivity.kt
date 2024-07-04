package com.example.melhorpreco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

  private  lateinit var precoNormal : EditText
    private lateinit var precoPromocao : EditText
    private lateinit var btnCalcular  : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets }

        precoNormal = findViewById(R.id.edit_preco_normal)
        precoPromocao = findViewById(R.id.edit_preco_promocao)
        btnCalcular = findViewById(R.id.btn_calcularpreco)

        btnCalcular.setOnClickListener {


            val intent: Intent = Intent(this, DetalhesActivity::class.java)


            intent.putExtra("precoNormal", precoNormal.text.toString())
            intent.putExtra("precoPromocao", precoPromocao.text.toString())

            if(precoNormal.text.isEmpty() && precoPromocao.text.isEmpty()){
                precoNormal.error = "Campo obrigatório"
                precoPromocao.error = "Campo obrigatório"
            }else startActivity(intent)



        }



    }




}