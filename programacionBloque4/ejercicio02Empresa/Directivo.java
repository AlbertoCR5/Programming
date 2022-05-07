package ejercicio02Empresa;

public class Directivo extends Empleado {

	private static final int SUELDO_MAXIMO_DIRECTIVO = 3000;
	private String departamento;

	
	public Directivo(String dni, String nombre, int sueldo, String departamento) throws EmpleadoException {
		super(dni, nombre, sueldo);
		setDepartamento(departamento);
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Directivo  " + super.toString() + " Departamento " + departamento;
	}

	@Override
	public void setSueldo( int sueldo) throws EmpleadoException {
		
		if ( sueldo > SUELDO_MAXIMO_DIRECTIVO) {
			throw new EmpleadoException("El sueldo del directivo no puede superar los " +SUELDO_MAXIMO_DIRECTIVO + " euros");
		}
		//LLama al setSueldo del empleado para darle valor y controlar que sea mayor al sueldo mínimo
		
		super.setSueldo(sueldo);
	}
}
