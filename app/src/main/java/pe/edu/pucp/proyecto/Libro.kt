package pe.edu.pucp.proyecto

open class Libro (titulo: String, autor: String, descripcion : String, categoria: String) {
     var titulo : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else value
        }
     var autor : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else value
        }
     var descripcion : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else (if (value.length > 235) (value.substring(0,235) + "...") else value)
        }
     var categoria : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else value
        }

     var resenias = mutableListOf<Resenia>()

    init {
        this.titulo = titulo
        this.autor = autor
        this.descripcion = descripcion
        this.categoria = categoria
    }

    public fun agregarResenia(usuario: Usuario, comentario: String){
        resenias.add(Resenia(usuario,this,comentario))
    }
}