package fplab;


public class Persona {
    private String nombre;
    private String dni;
    private  String celular;
    
    
    public void setNombre(String nomb) {
        nombre = nomb;
    }
        
    
    public String getNombre() {
        return nombre;
    }
        
        
    public void setDni(String DNI) {
        
		
        dni = DNI;
	
    }

    public String getDni() {

        return dni;
	
    }
    
    public void setCelular(String Celular) {

        celular = Celular;
	
    }

    public String getCelular() {

        return celular;
	
    }
    
    public String ToString(){
        return "Nombre: "+nombre+", Dni: "+dni+", Celular: "+celular;
    }
}
