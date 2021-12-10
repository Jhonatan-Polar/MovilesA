package pe.edu.pucp.proyecto.ui.busqueda

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.widget.SearchView.OnQueryTextListener
import kotlinx.android.synthetic.main.fragment_busqueda.*
import pe.edu.pucp.proyecto.databinding.FragmentBusquedaBinding
import pe.edu.pucp.proyecto.ui.busqueda.BusquedaViewModel
import pe.edu.pucp.proyecto.ui.libro.LibroFragment
import android.R
import android.view.MenuItem
import android.widget.*
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.w3c.dom.Text
import pe.edu.pucp.proyecto.*
import pe.edu.pucp.proyecto.databinding.ActivityBottomNavigationBinding
import pe.edu.pucp.proyecto.ui.LibroActivity
import pe.edu.pucp.proyecto.ui.ReseniaAdapter
import java.text.Normalizer
import android.widget.AdapterView

import android.widget.AdapterView.OnItemClickListener




var libroSeleccionado : Libro = Libro("","","","")

class BusquedaFragment : Fragment() {

    private lateinit var busquedaViewModel: BusquedaViewModel
    private var _binding: FragmentBusquedaBinding? = null
    private var REQUEST_CODE = 2345
    private var matchingBooks : MutableList<Libro> = mutableListOf()
    lateinit var arrayAdapter : ArrayAdapter<Libro>
    private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()
    private var mapa_Original_Filtrado = mutableMapOf<Int,Int>()

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

        binding.txtNoResults.visibility = TextView.INVISIBLE
        /*
        val txtNombreUsuario: TextView = binding.textBusqueda
        busquedaViewModel.text.observe(viewLifecycleOwner, Observer {
            txtNombreUsuario.text = it
        })
         */

        var textoABuscar : String = ""
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                textoABuscar = newText
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                textoABuscar = query
                binding.btnBuscar.callOnClick()
                return false
            }
        })

        binding.gridViewBusqueda.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            if(mapa_Original_Filtrado[id.toInt()] != null){
                libroSeleccionado = libros[mapa_Original_Filtrado[id.toInt()]!!]
                usuarioActual.agregarLibroAHistorial(libroSeleccionado)
            }
            else{
                libroSeleccionado = Libro("","","","")
            }
            mostrarLibro()
        })

        binding.btnBuscar.setOnClickListener {
            matchingBooks = mutableListOf()
            libroSeleccionado = Libro("","","","")
            buscarLibros(libros,textoABuscar)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun buscarLibros(listaLibros : MutableList<Libro>, texto : String){
        var i = 0
        for((j,lib) in listaLibros.withIndex()){
            if (lib.titulo.unaccent().contains(texto.unaccent(),ignoreCase = true)  ||
                lib.autor.unaccent().contains(texto.unaccent(),ignoreCase = true) ||
                lib.descripcion.unaccent().contains(texto.unaccent(),ignoreCase = true) ||
                lib.categoria.unaccent().contains(texto.unaccent(),ignoreCase = true)
            ){
                matchingBooks.add(listaLibros[j])
                mapa_Original_Filtrado.put(i,j)
                i++
            }
        }

        arrayAdapter = BusquedaAdapter(requireActivity().applicationContext, pe.edu.pucp.proyecto.R.layout.layout_grid_busqueda, matchingBooks)
        binding.gridViewBusqueda.adapter = arrayAdapter

        binding.txtNoResults.visibility = if(matchingBooks.size == 0) TextView.VISIBLE else TextView.INVISIBLE
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

    private fun CharSequence.unaccent(): String {
        val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
        return REGEX_UNACCENT.replace(temp, "")
    }
}