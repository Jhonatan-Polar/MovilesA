package pe.edu.pucp.proyecto.ui.busqueda

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import pe.edu.pucp.proyecto.R
import pe.edu.pucp.proyecto.Libro

class BusquedaAdapter(context: Context, resource: Int, objects: MutableList<Libro>) :
    ArrayAdapter<Libro>(context, resource, objects) {

    override fun getView(position: Int, convertViewAux: View?, parent: ViewGroup): View {
        val libro: Libro? = getItem(position)

        var convertView = convertViewAux
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_grid_busqueda, parent, false)
        }

        val tvNombre = convertView!!.findViewById(pe.edu.pucp.proyecto.R.id.tvNombreLibro) as TextView
        val ivLibro = convertView!!.findViewById(pe.edu.pucp.proyecto.R.id.iv_Libro) as ImageView

        tvNombre.setText(libro?.titulo)
        ivLibro.setImageResource(if (libro?.imagen != null) libro.imagen else R.drawable.ic_baseline_book_24)

        return convertView!!
    }
}