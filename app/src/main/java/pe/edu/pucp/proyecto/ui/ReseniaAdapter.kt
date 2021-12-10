package pe.edu.pucp.proyecto.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import pe.edu.pucp.proyecto.R
import pe.edu.pucp.proyecto.Resenia

class ReseniaAdapter(context: Context, resource: Int, objects: MutableList<Resenia>) :
    ArrayAdapter<Resenia>(context, resource, objects) {

    override fun getView(position: Int, convertViewAux: View?, parent: ViewGroup): View {
        val resenia: Resenia? = getItem(position)

        var convertView = convertViewAux
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_list_resenia, parent, false)
        }

        val tvNombre = convertView!!.findViewById(pe.edu.pucp.proyecto.R.id.tvNombre) as TextView
        val tvRol = convertView!!.findViewById(pe.edu.pucp.proyecto.R.id.tvRol) as TextView
        val tvComentario = convertView!!.findViewById(pe.edu.pucp.proyecto.R.id.tvComentario) as TextView

        tvNombre.setText(resenia?.usuario?.nombre)
        tvRol.setText(resenia?.usuario?.rol)
        tvComentario.setText(resenia?.comentario)

        return convertView!!
    }
}