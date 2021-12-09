package pe.edu.pucp.proyecto.ui.busqueda

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
import kotlinx.android.synthetic.main.fragment_busqueda.*
import pe.edu.pucp.proyecto.BottomNavigation
import pe.edu.pucp.proyecto.Libro
import pe.edu.pucp.proyecto.MainActivity
import pe.edu.pucp.proyecto.databinding.FragmentBusquedaBinding
import pe.edu.pucp.proyecto.libros
import pe.edu.pucp.proyecto.ui.busqueda.BusquedaViewModel

class BusquedaFragment : Fragment() {

    private lateinit var busquedaViewModel: BusquedaViewModel
    private var _binding: FragmentBusquedaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        busquedaViewModel =
            ViewModelProvider(this).get(BusquedaViewModel::class.java)

        _binding = FragmentBusquedaBinding.inflate(inflater, container, false)
        val root: View = binding.root


        /*
        val textView: TextView = binding.textBusqueda
        busquedaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
         */

        var textoABuscar : String = ""
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                textoABuscar = query
                binding.btnBuscar.callOnClick()
                return false
            }
        })

        binding.btnBuscar.setOnClickListener {
            buscarLibros(libros,textoABuscar)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun buscarLibros(listaLibros : MutableList<Libro>, texto : String){

    }
}