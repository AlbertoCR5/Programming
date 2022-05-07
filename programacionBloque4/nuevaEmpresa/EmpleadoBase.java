package nuevaEmpresa;

public class EmpleadoBase extends Empleado{

	private static final double INCREMENTO_SUELDO_EMPLEADOS_BASE = 0.025;
	private Puesto puesto;

	public EmpleadoBase(String dni, String nombre, Puesto puesto) throws EmpresaException {
		super(dni, nombre, puesto.getSueldo());
		this.puesto = puesto;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	@Override
	public String toString() {
		return super.toString() + " Puesto " + puesto ;
	}

	@Override
	public void actualizarSueldo() throws EmpresaException {
		setSueldo( (int) (this.getSueldo() + (INCREMENTO_SUELDO_EMPLEADOS_BASE* this.getSueldo())));
		
	}

	
	
	
	
	
}