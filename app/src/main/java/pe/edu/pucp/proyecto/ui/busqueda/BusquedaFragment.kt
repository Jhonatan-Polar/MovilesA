package pe.edu.pucp.proyecto.ui.busqueda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.pucp.proyecto.databinding.FragmentBusquedaBinding
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

        val textView: TextView = binding.textBusqueda
        busquedaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}