package ejercicio04ProfesorAlumno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje implements Comparable<Mensaje>{

	private Persona remitente;
	private String texto;
	private LocalDateTime hora;
	
	public Mensaje(Persona remitente, String texto) {
		
		this.remitente = remitente;
		this.texto = texto;
		hora = LocalDateTime.now();
	}

	public Persona getRemitente() {
		return remitente;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	@Override
	public String toString() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-uuuu hh:mm");
		return "Mensaje [remitente=" + remitente.getNombre() + ", texto=" + texto + ", Fecha=" + dateFormat.format(hora) + "]";
	}
	
	public int compareTo(Mensaje otro) {
		
		return this.getRemitente().getNombre().compareTo(otro.getRemitente().getNombre());		
	}
	
}
