package pe.edu.pucp.proyecto.ui.perfil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.pucp.proyecto.BottomNavigation
import pe.edu.pucp.proyecto.MainActivity
import pe.edu.pucp.proyecto.Usuario
import pe.edu.pucp.proyecto.databinding.FragmentPerfilBinding
import pe.edu.pucp.proyecto.usuarioActual

class PerfilFragment : Fragment() {

    private lateinit var perfilViewModel: PerfilViewModel
    private var _binding: FragmentPerfilBinding? = null
    private var REQUEST_CODE = 9898

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        perfilViewModel =
            ViewModelProvider(this).get(PerfilViewModel::class.java)

        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.txtNombrePerfil.text = usuarioActual.nombre

        binding.btnCerrarSesion.setOnClickListener {
            val cerrarSesionIntent = Intent(activity, MainActivity::class.java)
            startActivityForResult(cerrarSesionIntent,REQUEST_CODE)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}