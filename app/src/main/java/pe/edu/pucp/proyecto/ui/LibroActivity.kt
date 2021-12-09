package pe.edu.pucp.proyecto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.navigation.findNavController
import pe.edu.pucp.proyecto.R
import pe.edu.pucp.proyecto.databinding.ActivityLibroBinding
import pe.edu.pucp.proyecto.databinding.ActivityMainBinding
import pe.edu.pucp.proyecto.libros
import pe.edu.pucp.proyecto.ui.busqueda.libroSeleccionado

class LibroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLibroBinding
    var libroSeleccionadoAMostrar = libroSeleccionado


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar: ActionBar? = supportActionBar
        // showing the back button in action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        //Ejemplo:: Llenar datos del libro(depende de la vista busqueda para llenar por el id de la lista)
        libroSeleccionadoAMostrar = libros.get(0)
        llenarDatosDelLibro()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun llenarDatosDelLibro() {
        binding.vtitulo.setText(libroSeleccionadoAMostrar.titulo)
        binding.vcategoria.setText(libroSeleccionadoAMostrar.categoria)
        binding.vautor.setText(libroSeleccionadoAMostrar.autor)
        binding.vdescripcion.setText(libroSeleccionadoAMostrar.descripcion)

        binding.vusuario.setText(libroSeleccionadoAMostrar.resenias.get(0).usuario.nombre)
        binding.vrol.setText(libroSeleccionadoAMostrar.resenias.get(0).usuario.rol)
        binding.vcomentario.setText(libroSeleccionadoAMostrar.resenias.get(0).comentario)
    }
}