package nuevaEmpresa;

public class JefeDepartamento extends Empleado{

	private static final double PORCENTAJE2_AUMENTO_SUELDO = 0.04;
	private static final double PORCENTAJE3_AUMENTO_SUELDO = 0.06;
	private static final double PORCENTAJE1_AUMENTO_SUELDO = 0.03;
	private static final int LIMITE2_NUMERO_SUBORDINADOS = 8;
	private static final int LIMITE1_NUMERO_EMPLEADOS = 3;
	public static final int MAXIMO_SUBORDINADOS = 12;
	public static final int SUELDO_MINIMO_JEFE_DEPARTAMENTO = 1300;
	
	private String nombreDepartamento;
	private Empleado[] subordinados;
	private int numeroSubordinados;
	
	public JefeDepartamento(String dni, String nombre, int sueldo, String nombreDepartamento) throws EmpresaException {
		super(dni, nombre, sueldo);
		this.nombreDepartamento = nombreDepartamento;
		subordinados=new Empleado[MAXIMO_SUBORDINADOS];
		numeroSubordinados=0;
	}

	public void bajaSubordinado( Empleado subordinado ) throws EmpresaException{
		int posicion;
		
		posicion=buscarSubordinado(subordinado);
		
		if ( posicion== -1) { // no lo ha encontrado. lanzo el error
			throw new EmpresaException("No existe el subordinado " + subordinado.getNombre());
		}
		
		subordinados[posicion]=null;
		numeroSubordinados--;
	}
	/**
	 * Devolver la posición de un empleado o -1 si no lo encuentra
	 * @param subordinadoBuscar
	 * @return
	 * @throws EmpresaException
	 */
	private int buscarSubordinado(Empleado subordinadoBuscar) throws EmpresaException {
		
		int posicion=-1;
		boolean encontrado=false;
		
		for (int i = 0; i < subordinados.length && !encontrado; i++) {
			
			if (subordinadoBuscar.equals( subordinados[i])) {
				posicion=i;
				encontrado=true;
			}
		}
		
		return posicion;
		
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	
	public void annadirSubordinado (Empleado empleadoSubordinado) throws EmpresaException {
		
		int posicion;
		if ( empleadoSubordinado.getSueldo() > this.getSueldo()) {
			throw new EmpresaException("El sueldo del subordinado " + empleadoSubordinado.getNombre() + " no puede ser mayor que el del jefe " + this.getNombre());
		}
		//CONTROLAR QUE NO ESTE REPETIDO
		
		if ( buscarSubordinado(empleadoSubordinado) != -1 ) { // ya esta este subordinado. Lanzo error
			
			throw new EmpresaException("El empleado " + empleadoSubordinado.getNombre() + " ya es subordinado de el jefe " + this.getNombre());
		}

		
		posicion=buscarHueco();
		
		subordinados[posicion]=empleadoSubordinado;
		numeroSubordinados++;
	}
	
	private int buscarHueco() throws EmpresaException {
		int posicion=-1;
		boolean encontrado=false;
		
		for (int i = 0; i < subordinados.length && !encontrado; i++) {
			
			if ( subordinados[i]==null) {
				posicion=i;
				encontrado=true;
			}
		}
		if ( !encontrado) {
			throw new EmpresaException("No puede tener más de " + MAXIMO_SUBORDINADOS + " subordinados");
		}
		
		return posicion;
	}

	protected void setSueldo(int sueldo) throws EmpresaException {
		if ( sueldo < SUELDO_MINIMO_JEFE_DEPARTAMENTO) {
			throw new EmpresaException("Los jefes de departamento tienen un sueldo mínimo de " + SUELDO_MINIMO_JEFE_DEPARTAMENTO + " euros");
		}
		super.setSueldo(sueldo);
	}

	public String toString () {
		return super.toString() + "Departamento " + nombreDepartamento + " Numero subordinados " + numeroSubordinados;
	}

	@Override
	public void actualizarSueldo() throws EmpresaException {
		int nuevoSueldo = 0;
		
		if (numeroSubordinados < LIMITE1_NUMERO_EMPLEADOS) {
			nuevoSueldo += PORCENTAJE1_AUMENTO_SUELDO*this.getSueldo()	;
		}
		else {
			if (numeroSubordinados <=LIMITE2_NUMERO_SUBORDINADOS ) {
				nuevoSueldo+= PORCENTAJE2_AUMENTO_SUELDO*this.getSueldo()	;
			}
			else {
				nuevoSueldo+= PORCENTAJE3_AUMENTO_SUELDO*this.getSueldo()	;
			}
		}
		
		setSueldo(nuevoSueldo);
		
	}
	
}
