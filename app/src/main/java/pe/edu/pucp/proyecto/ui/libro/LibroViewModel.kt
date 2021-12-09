package pe.edu.pucp.proyecto.ui.libro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LibroViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is libro Fragment"
    }
    val text: LiveData<String> = _text
}