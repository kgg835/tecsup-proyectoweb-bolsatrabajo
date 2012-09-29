package trastienda.modelo;

import java.util.Collection;

public class Categoria {

	private int idCategoria;
	private String nombre;
	private String descripcion;
	private Collection<Producto> productos;

	// 1. Escribir constructor vacío
	// 2. Generar constructor con campos
	// 3. Generar getters y setters

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public Categoria(int idCategoria, String nombre, String descripcion,
			Collection<Producto> productos) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.productos = productos;
	}

	public Categoria() {
		super();
	}

}
