package pe.edu.pucp.proyecto.ui.historial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import pe.edu.pucp.proyecto.Libro
import pe.edu.pucp.proyecto.R

class HistorialAdapter(context: Context, resource: Int, objects: MutableList<Libro>) :
    ArrayAdapter<Libro>(context, resource, objects) {

    override fun getView(position: Int, convertViewAux: View?, parent: ViewGroup): View {
        val libro: Libro? = getItem(position)

        var convertView = convertViewAux
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_grid_historial, parent, false)
        }

        val tvNombreH = convertView!!.findViewById(pe.edu.pucp.proyecto.R.id.tv_NombreLibro_H) as TextView
        val ivLibroH = convertView!!.findViewById(pe.edu.pucp.proyecto.R.id.iv_Libro_H) as ImageView

        tvNombreH.setText(libro?.titulo)
        ivLibroH.setImageResource(if (libro?.imagen != null) libro.imagen else R.drawable.ic_baseline_book_24)

        return convertView!!
    }
}