package pe.edu.pucp.proyecto.ui.libro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_libro.*
import pe.edu.pucp.proyecto.BottomNavigation
import pe.edu.pucp.proyecto.Libro
import pe.edu.pucp.proyecto.MainActivity
import pe.edu.pucp.proyecto.databinding.FragmentLibroBinding
import pe.edu.pucp.proyecto.libros
import pe.edu.pucp.proyecto.ui.libro.LibroViewModel

class LibroFragment : Fragment() {

    private lateinit var libroViewModel: LibroViewModel
    private var _binding: FragmentLibroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        libroViewModel =
            ViewModelProvider(this).get(LibroViewModel::class.java)

        _binding = FragmentLibroBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //Ejemplo:: Llenar datos del libro(depende de la vista busqueda para llenar por el id de la lista)
        binding.vtitulo.setText(libros.get(0).titulo)
        binding.vcategoria.setText(libros.get(0).categoria)
        binding.vautor.setText(libros.get(0).autor)
        binding.vdescripcion.setText(libros.get(0).descripcion)

        binding.vusuario.setText(libros.get(0).resenias.get(0).usuario.nombre)
        binding.vrol.setText(libros.get(0).resenias.get(0).usuario.rol)
        binding.vcomentario.setText(libros.get(0).resenias.get(0).comentario)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}