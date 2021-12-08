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
            field = if (value.isEmpty()) "" else value
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

    public fun agregarResenia(usuario: Usuario, libro: Libro, comentario: String){
        resenias.add(Resenia(usuario,libro,comentario))
    }
}