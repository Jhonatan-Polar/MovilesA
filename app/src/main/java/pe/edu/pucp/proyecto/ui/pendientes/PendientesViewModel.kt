package pe.edu.pucp.proyecto.ui.pendientes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PendientesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pendientes Fragment"
    }
    val text: LiveData<String> = _text
}