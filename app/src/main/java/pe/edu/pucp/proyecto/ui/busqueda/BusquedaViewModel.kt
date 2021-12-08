package pe.edu.pucp.proyecto.ui.busqueda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BusquedaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is busqueda Fragment"
    }
    val text: LiveData<String> = _text
}