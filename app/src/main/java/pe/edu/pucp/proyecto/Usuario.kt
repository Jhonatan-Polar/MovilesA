package pe.edu.pucp.proyecto

class Usuario (nombre: String, rol: String, nombreUsuario : String = "") {
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
    var nombreUsuario : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) this.nombre else value
        }

    var resenias = mutableListOf<Resenia>()
    var historial = mutableListOf<Libro>()
        get(){
            return field
        }

    init {
        this.nombre = nombre
        this.rol = rol
        this.nombreUsuario = nombreUsuario
    }

    fun agregarLibroAHistorial(libro : Libro){
        if(!historial.contains(libro)) {
            historial.add(0, libro)
        }
    }
}