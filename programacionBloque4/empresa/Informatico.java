package empresa;

public class Informatico extends Empleado{
	
	public enum Especialidad {DESARROLLO, BD, SISTEMAS}
	
	private static final int SUELDO_MAXIMO_INFORMATICO = 2500;
	private Especialidad especialidad;

	public Informatico(String dni, String nombre, int sueldo, Especialidad especialidad) throws EmpleadoException {
		super(dni, nombre, sueldo);
		this.especialidad=especialidad;
	}

	
	@Override
	public String toString() {
		return "Inform�tico  " + super.toString() + " Especialidad " + especialidad;
	}

	@Override
	public void setSueldo( int sueldo) throws EmpleadoException {
		
		if ( sueldo > SUELDO_MAXIMO_INFORMATICO) {
			throw new EmpleadoException("El sueldo del informatico no puede superar los " +SUELDO_MAXIMO_INFORMATICO + " euros");
		}
		//LLama al setSueldo del empleado para darle valor y controlar que sea mayor al sueldo mínimo
		
		super.setSueldo(sueldo);
	}
	
}
