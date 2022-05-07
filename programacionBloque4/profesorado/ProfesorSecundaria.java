package profesorado;

public class ProfesorSecundaria extends Profesor{

	private static final int MAXIMO_NOTA = 10;
	private static final int MINIMO_NOTA = 0;

	private static final int ANTIGUEDAD_MINIMA = 2;
	
	private EspecialidadesSecundaria especialidad;
	private int sumaNotas;
	private int totalEvaluaciones;
	
	public ProfesorSecundaria(String nombre, String DNI, String centroAdjudicado, EspecialidadesSecundaria especialidad)throws ProfesoresException {
		super(nombre, DNI, centroAdjudicado);
		this.especialidad = especialidad;
		this.sumaNotas = MINIMO_NOTA;
		this.totalEvaluaciones = 0;
	}

	public EspecialidadesSecundaria getEspecialidad() {
		return especialidad;
	}

	public int getTotalEvaluaciones() {
		return totalEvaluaciones;
	}

	@Override
	public String toString() {
		
		String info = super.toString() + ", especialidad= " + especialidad + "nota media = ";
		
		if (totalEvaluaciones == 0) {
			info = info + " NO EVALUADO";
		}
		else {
			info = info + (double)(sumaNotas / totalEvaluaciones);
		}
		return  info;
	}

	public void cambiarDeCentro(String centroAdjudicado) throws ProfesoresException {
		if (super.getAntiguedad() < ANTIGUEDAD_MINIMA) {
			throw new ProfesoresException("ERROR, Necesitas al menos 2 años de antiguedad para cambiar de centro");
		}
		super.setCentroAdjudicado(centroAdjudicado);;
	}
	@Override
	public void evaluacionAnual(int nota) throws ProfesoresException {
		
		if (nota < MINIMO_NOTA || nota > MAXIMO_NOTA) {
			throw new ProfesoresException("ERROR, la nota introducidad (" + nota + ") esta fuera de rango.");
		}
		
		sumaNotas = sumaNotas + nota;
		totalEvaluaciones++;
		super.antiguedad++;
	}

	
}
