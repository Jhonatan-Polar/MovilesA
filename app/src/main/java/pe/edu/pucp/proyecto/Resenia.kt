package pe.edu.pucp.proyecto

class Resenia (usuario: Usuario, libro: Libro, comentario: String) {
     var usuario : Usuario = Usuario("","")
        get(){
            return field
        }
        set(value){
            field = value
        }
     var libro : Libro = Libro("","","", "")
        get(){
            return field
        }
        set(value){
            field = value
        }
     var comentario : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else value
        }

    init {
        this.usuario = usuario
        this.libro = libro
        this.comentario = comentario
    }
}