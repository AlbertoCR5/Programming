package ejercicio02Empresa;

public class Operario extends Empleado{

	private static final int SUELDO_MAXIMO_OPERARIOS = 1200;
	private int nave;

	public Operario(String dni, String nombre, int sueldo, int nave) throws EmpleadoException {
		super(dni, nombre, sueldo);
		this.nave = nave;
	}

	public int getNave() {
		return nave;
	}

	public void setNave(int nave) {
		this.nave = nave;
	}

	@Override
	public String toString() {
		return "Operario  " + super.toString() + " Nave " + nave;
	}

	@Override
	public void setSueldo( int sueldo) throws EmpleadoException {
		
		if ( sueldo > SUELDO_MAXIMO_OPERARIOS) {
			throw new EmpleadoException("El sueldo del operario no puede superar los " +SUELDO_MAXIMO_OPERARIOS + " euros");
		}
		//LLama al setSueldo del empleado para darle valor y controlar que sea mayor al sueldo mínimo
		
		super.setSueldo(sueldo);
	}
	
}