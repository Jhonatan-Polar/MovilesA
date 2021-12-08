package pe.edu.pucp.proyecto

class Usuario (nombre: String, rol: String) {
    private var nombre : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else value
        }
    private var rol : String = ""
        get(){
            return field
        }
        set(value){
            field = if (value.isEmpty()) "" else value
        }

    private var resenias = mutableListOf<Resenia>()

    init {
        this.nombre = nombre
        this.rol = rol
    }
}