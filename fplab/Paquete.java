
package fplab;


public class Paquete {
    
	private int identificador;
        private int peso;
        private int costo;
        private String fechaRecepcion;
        private String fechaentrega;
        private String direccion;
        private boolean estado;
        private Persona person;
    
	public int getIdentificador() {
		return identificador;
	}
        public void setEstado(boolean e) {
		estado = e;
	}
        
        public boolean getEstado() {
		return estado;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public String getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
        public void setPersona(Persona Pers) {
		person = Pers;
	}
	public Persona getPersona() {
		return person;
	}
    
}
