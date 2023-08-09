package beans;

public class Compra {
	
	private String id;
	private String nombre; 
	private String precio; 
	private String añosGaran;
	private String cliente;
	
	public Compra(String id, String nombre, String precio, String añosGaran, String cliente) {
		
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.añosGaran = añosGaran;
		this.cliente = cliente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getAñosGaran() {
		return añosGaran;
	}

	public void setAñosGaran(String añosGaran) {
		this.añosGaran = añosGaran;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public String toStringOrdenadoCsv() {
		return id+","+ nombre+","+ precio+","+ añosGaran+","+ cliente;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", añosGaran=" + añosGaran
				+ ", cliente=" + cliente + "]";
	} 

	

	
	
	
	

}
