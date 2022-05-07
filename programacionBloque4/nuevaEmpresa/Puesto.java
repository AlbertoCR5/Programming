package nuevaEmpresa;

public enum Puesto {
	
	ADMINISTRATIVO(Empleado.SUELDO_ADMINISTRATIVO), 
	OPERARIO (Empleado.SUELDO_OPERARIO),
	CONTABLE(Empleado.SUELDO_CONTABLE);
	
	private int sueldo;
	
	private Puesto( int sueldo) {
		this.sueldo=sueldo;
	}
	
	public int getSueldo() {
		return sueldo;
	}
}