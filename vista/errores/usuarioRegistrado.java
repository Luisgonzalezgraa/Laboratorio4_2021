package errores;

public class usuarioRegistrado extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public usuarioRegistrado(String nombre) {
	super("Error usuario "+ nombre + " ya registrado...");
	}
}