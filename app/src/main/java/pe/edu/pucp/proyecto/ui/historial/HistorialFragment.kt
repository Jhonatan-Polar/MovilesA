package pe.edu.pucp.proyecto.ui.historial

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_historial.*
import pe.edu.pucp.proyecto.Libro
import pe.edu.pucp.proyecto.R
import pe.edu.pucp.proyecto.databinding.FragmentHistorialBinding
import pe.edu.pucp.proyecto.libros
import pe.edu.pucp.proyecto.ui.LibroActivity
import pe.edu.pucp.proyecto.ui.busqueda.libroSeleccionado
import pe.edu.pucp.proyecto.usuarioActual

class HistorialFragment : Fragment() {

    private lateinit var historialViewModel: HistorialViewModel
    private var _binding: FragmentHistorialBinding? = null
    lateinit var arrayAdapter : ArrayAdapter<Libro>
    private var REQUEST_CODE = 2378
    private var mapa_Original_Historial = mutableMapOf<Int,Int>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historialViewModel =
            ViewModelProvider(this).get(HistorialViewModel::class.java)

        _binding = FragmentHistorialBinding.inflate(inflater, container, false)
        val root: View = binding.root

        cargarHistorial()

        binding.gridViewHistorial.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            if (mapa_Original_Historial[mapa_Original_Historial.size - id.toInt() - 1] != null) {
                libroSeleccionado = libros[mapa_Original_Historial[mapa_Original_Historial.size - id.toInt() - 1]!!]
            } else {
                libroSeleccionado = Libro("", "", "", "")
            }
            mostrarLibro()
            cargarHistorial()
        })

        return root
    }

    fun mostrarLibro(){
        val verLibroIntent = Intent(activity, LibroActivity::class.java)
        startActivityForResult(verLibroIntent,REQUEST_CODE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun cargarHistorial(){
        var i = 0
        for((j,lib) in libros.withIndex()){
            if(usuarioActual.historial.contains(lib)){
                mapa_Original_Historial.put(i,j)
                i++
            }
        }

        binding.txtNoHistory.visibility = if (usuarioActual.historial.size == 0) TextView.VISIBLE else TextView.INVISIBLE

        arrayAdapter = HistorialAdapter(requireActivity().applicationContext, R.layout.layout_grid_historial, usuarioActual.historial)
        binding.gridViewHistorial.adapter = arrayAdapter
    }
}