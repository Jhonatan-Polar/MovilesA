package pe.edu.pucp.proyecto.ui.busqueda

import android.content.Intent
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
import pe.edu.pucp.proyecto.ui.libro.LibroFragment
import android.R
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.w3c.dom.Text
import pe.edu.pucp.proyecto.ui.LibroActivity

var libroSeleccionado : Libro = Libro("","","","")

class BusquedaFragment : Fragment() {

    private lateinit var busquedaViewModel: BusquedaViewModel
    private var _binding: FragmentBusquedaBinding? = null
    private var REQUEST_CODE = 2345

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
        val txtNombreUsuario: TextView = binding.textBusqueda
        busquedaViewModel.text.observe(viewLifecycleOwner, Observer {
            txtNombreUsuario.text = it
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
            /////
            mostrarLibro()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun buscarLibros(listaLibros : MutableList<Libro>, texto : String){

    }

    fun mostrarLibro(){
        //binding.btnBuscar.visibility = Button.INVISIBLE
        //binding.searchView.visibility = SearchView.INVISIBLE
        //binding.txtBuscar.visibility = TextView.INVISIBLE

        //val transaction = activity?.supportFragmentManager?.beginTransaction()
        //transaction?.replace(R.id.content, LibroFragment())
        //transaction?.disallowAddToBackStack()
        //transaction?.commit()


        val verLibroIntent = Intent(activity,LibroActivity::class.java)
        startActivityForResult(verLibroIntent,REQUEST_CODE)
    }
}