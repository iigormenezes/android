package livrokotlin.com.br

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView


class MainActivity : AppCompatActivity() {

    private lateinit var listaDeCompras: MutableList<String>
    private lateinit var adaptador: ArrayAdapter<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaDeCompras = mutableListOf()
        adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1, listaDeCompras)

        val botaoAdicionar = findViewById<Button>(R.id.botao_adicionar)
        val campoTexto = findViewById<EditText>(R.id.campo_texto)
        val listView = findViewById<ListView>(R.id.listar_campo)

        listView.adapter = adaptador

        botaoAdicionar.setOnClickListener {
            val item = campoTexto.text.toString()
            if (item.isNotEmpty()) {
                listaDeCompras.add(item)
                adaptador.notifyDataSetChanged()
                campoTexto.text.clear()

            }
        }
    }
}



