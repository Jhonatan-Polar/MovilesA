package pe.edu.pucp.proyecto.ui.recomendados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.pucp.proyecto.databinding.FragmentRecomendadosBinding

class RecomendadosFragment : Fragment() {

    private lateinit var recomendadosViewModel: RecomendadosViewModel
    private var _binding: FragmentRecomendadosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recomendadosViewModel =
            ViewModelProvider(this).get(RecomendadosViewModel::class.java)

        _binding = FragmentRecomendadosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        recomendadosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}