package profesorado;

public class ProfesorPrimaria extends Profesor{

	private static final int MAXIMO_NOTA = 5;
	private static final int MINIMO_NOTA = 0;
	private static final int ANTIGUEDAD_MINIMA = 3;
	
	private EspecialidadesPrimaria especialidad;
	private double notaUltimaEvaluacion;
	
	public ProfesorPrimaria(String nombre, String DNI, String centroAdjudicado, int antiguedad, EspecialidadesPrimaria especialidad)throws ProfesoresException {
		super(nombre, DNI, centroAdjudicado);
		this.especialidad = especialidad;
		this.notaUltimaEvaluacion = MINIMO_NOTA;
	}
	
	public ProfesorPrimaria(String nombre, String DNI, String centroAdjudicado, int antiguedad)throws ProfesoresException {
		super(nombre, DNI, centroAdjudicado);
		this.especialidad = EspecialidadesPrimaria.GENERAL;
		this.notaUltimaEvaluacion = MINIMO_NOTA;
	}
	
	public EspecialidadesPrimaria getEspecialidad() {
		return especialidad;
	}

	public double getNotaUltimaEvaluacion() {
		return notaUltimaEvaluacion;
	}

	@Override
	public String toString() {
		
		String info = super.toString() + ", especialidad= " + especialidad + ", notaUltimaEvaluacion= ";
		
		if (notaUltimaEvaluacion == MINIMO_NOTA) {
			info = info + " NO_EVALUADO";
		}
		else {
			info = info + notaUltimaEvaluacion;
		}
		
		return info; 
	}

	public void cambiarDeCentro(String centroAdjudicado) throws ProfesoresException {
		if (getAntiguedad() < ANTIGUEDAD_MINIMA) {
			throw new ProfesoresException("ERROR, Necesitas al menos 3 años de antiguedad para cambiar de centro");
		}
		super.setCentroAdjudicado(centroAdjudicado);
	}
	@Override
	public void evaluacionAnual(int nota) throws ProfesoresException {
		
		if (nota < MINIMO_NOTA || nota > MAXIMO_NOTA) {
			throw new ProfesoresException("ERROR, la nota introducidad (" + nota + ") esta fuera de rango.");
		}
		super.antiguedad++; //PREGUNTAR
		
		notaUltimaEvaluacion = nota;
	}

	
}
