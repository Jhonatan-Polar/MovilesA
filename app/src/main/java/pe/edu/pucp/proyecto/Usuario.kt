package pe.edu.pucp.proyecto

class Usuario (nombre: String, rol: String) {
     var nombre : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else value
        }
     var rol : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else value
        }
     var contrasenia : String = "password"

     var resenias = mutableListOf<Resenia>()

    init {
        this.nombre = nombre
        this.rol = rol
    }
}