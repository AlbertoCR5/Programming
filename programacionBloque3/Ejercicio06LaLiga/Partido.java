package Ejercicio06LaLiga;

public class Partido {

	private final char VICTORIA = '1';
	private final char EMPATE = 'X';
	private final char DERROTA = '2';
	private final char SEPARADOR = '-';
	private final int VALOR_MINIMO = 0;
	private final int JORNADAS = 38;
	
	private int jornada;
	private Equipo local, visitante;
	String resultado;
	int golesLocal, golesVisitante;
	char resultadoQuiniela;
	boolean esDisputado = false;
	
	public Partido(int jornada, Equipo local, Equipo visitante, String resultado) throws LaLigaException {
		
		if (local.getNombreEquipo().equals(visitante.getNombreEquipo())) {
			throw new LaLigaException("El partido debe disputarse entre distintos equipos");
		}
		setJornada(jornada);
		this.local = local;
		this.visitante = visitante;
		esDisputado = true;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) throws LaLigaException {
		
		if (jornada > JORNADAS || jornada <= VALOR_MINIMO) {
			throw new LaLigaException("La jornada introducida no existe" + jornada);
		}
		this.jornada = jornada;
	}

	public Equipo getLocal() {
		return local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) throws LaLigaException {
		
		if (golesLocal < VALOR_MINIMO) {
			throw new LaLigaException("Los goles no pueden tener valor negativo");			
		}
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) throws LaLigaException {
		
		if (golesVisitante < VALOR_MINIMO) {
			throw new LaLigaException("Los goles no pueden tener valor negativo");			
		}
		this.golesVisitante = golesVisitante;
	}

	public char getResultado() {
		return resultadoQuiniela;
	}

	
	@Override
	public String toString() {
		
		String msg;
		if (esDisputado) {
			msg = "Partido entre " + local + " y " + visitante + " todavía no se ha jugado";
		}
		else {
			msg = "Partido entre " + local + " y " + visitante + " jugado en el estadio " 
					+ local.getNombreEstadio() + " de la ciudad " + local.getCiudad() + " "
					+ "ha finalizado " + golesLocal + "-" + golesVisitante + " y Resultado " + resultadoQuiniela 
					+ " en la quiniela";
		}
		return msg;
	}

	public void setResultadoQuiniela(char resultadoQuiniela) {
		
		if(golesLocal > golesVisitante) {
			resultadoQuiniela = VICTORIA;
			this.local.incrementarPartidosGanados();
		}
		else {
			if (golesLocal == golesVisitante) {
				resultadoQuiniela = EMPATE;
			}
			else {
				resultadoQuiniela = DERROTA;
				this.visitante.incrementarPartidosGanados();
			}
		}
		
		this.resultadoQuiniela = resultadoQuiniela;
	}
	
	public void ponerResultado(String resultado) throws NumberFormatException, LaLigaException {
		
		int posicionGuion = resultado.indexOf(SEPARADOR);
		
		if (posicionGuion <= 0) {
			throw new LaLigaException("Error, formato del resultado invalido");
		}
		setGolesLocal(Integer.parseInt(resultado.substring(0, posicionGuion)));
		setGolesVisitante(Integer.parseInt(resultado.substring(posicionGuion + 1, resultado.length())));
		
	}
}
