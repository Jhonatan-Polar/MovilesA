package pe.edu.pucp.proyecto.ui.recomendados

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecomendadosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is recomendados Fragment"
    }
    val text: LiveData<String> = _text
}