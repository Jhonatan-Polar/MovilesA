package pe.edu.pucp.proyecto.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelStore
import androidx.navigation.findNavController
import pe.edu.pucp.proyecto.databinding.ActivityLibroBinding
import pe.edu.pucp.proyecto.ui.busqueda.libroSeleccionado

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import kotlinx.android.synthetic.main.activity_libro.*
import pe.edu.pucp.proyecto.*


class LibroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLibroBinding
    lateinit var arrayAdapter : ArrayAdapter<Resenia>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // showing the back button in action bar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        //Ejemplo:: Llenar datos del libro(depende de la vista busqueda para llenar por el id de la lista)
        llenarDatosDelLibro()

        evaluarSiYaEscribioResenia()

        binding.btnEscribe.setOnClickListener{
            addRev()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun evaluarSiYaEscribioResenia(){
        if (libroSeleccionado.resenias.find { r -> r.usuario == usuarioActual } != null) {
            binding.btnEscribe.visibility = Button.INVISIBLE
            binding.txtResenia.updateLayoutParams<ConstraintLayout.LayoutParams> {
                topToBottom = binding.vdescripcion.id
                topMargin = 64
            }
        }
        else {
            binding.btnEscribe.visibility = Button.VISIBLE
        }
    }

    private fun llenarDatosDelLibro() {
        llenarDatosPrincipalesDelLibro()
        arrayAdapter = ReseniaAdapter(this, R.layout.layout_list_resenia, libroSeleccionado.resenias)
        binding.listViewResenias.adapter = arrayAdapter
    }

    private fun llenarDatosPrincipalesDelLibro() {
        binding.vtitulo.setText(libroSeleccionado.titulo)
        binding.vcategoria.setText(libroSeleccionado.categoria)
        binding.vautor.setText(libroSeleccionado.autor)
        binding.vdescripcion.setText(libroSeleccionado.descripcion)
    }

    private fun addRev(){
        binding.btnEscribe.setVisibility(View.INVISIBLE)
        binding.vdescripcion.setVisibility(View.INVISIBLE)
        binding.txtDescripcion.setVisibility(View.INVISIBLE)
        binding.btnEscribe.setVisibility(View.INVISIBLE)
        binding.txtResenia.setVisibility(View.INVISIBLE)
        binding.listViewResenias.setVisibility(ListView.INVISIBLE)

        binding.reseLabel.setVisibility(View.VISIBLE)
        binding.nuevaRese.setVisibility(View.VISIBLE)
        binding.btnGuardar.setVisibility(View.VISIBLE)

        binding.btnGuardar.setOnClickListener{
            libroSeleccionado.agregarResenia(usuarioActual, binding.nuevaRese.text.toString())

            binding.btnEscribe.setVisibility(View.INVISIBLE)

            binding.vdescripcion.setVisibility(View.VISIBLE)
            binding.txtDescripcion.setVisibility(View.VISIBLE)
            binding.btnEscribe.setVisibility(View.VISIBLE)
            binding.txtResenia.setVisibility(View.VISIBLE)
            binding.listViewResenias.setVisibility(ListView.VISIBLE)

            binding.reseLabel.setVisibility(View.INVISIBLE)
            binding.nuevaRese.setVisibility(View.INVISIBLE)
            binding.btnGuardar.setVisibility(View.INVISIBLE)

            llenarDatosDelLibro()
            evaluarSiYaEscribioResenia()
        }
    }
}