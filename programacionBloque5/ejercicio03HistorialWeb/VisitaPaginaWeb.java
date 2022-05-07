package ejercicio03HistorialWeb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VisitaPaginaWeb implements Comparable<VisitaPaginaWeb>{

	private String direccionWeb;
	private LocalDateTime fechaHora;
		
	public VisitaPaginaWeb(String direccionWeb) throws VisitaPaginaWebException  {

		setDireccionWeb(direccionWeb);
		this.fechaHora = LocalDateTime.now();
	}

	public String getDireccionWeb() {
		return direccionWeb;
	}
	
	public void setDireccionWeb(String direccionWeb) throws VisitaPaginaWebException {
		
		if(direccionWeb.length() < 9) {
			throw new VisitaPaginaWebException("Error");
		}
		this.direccionWeb = direccionWeb;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccionWeb == null) ? 0 : direccionWeb.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitaPaginaWeb other = (VisitaPaginaWeb) obj;
		if (direccionWeb == null) {
			if (other.direccionWeb != null)
				return false;
		} else if (!direccionWeb.equals(other.direccionWeb))
			return false;
		return true;
	}

	@Override
	public int compareTo(VisitaPaginaWeb otro) {

		return this.getFechaHora().compareTo(otro.getFechaHora());
	}

	@Override
	public String toString() {
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/uuuu hh:mm");
		
		return "Pagina Web: " + direccionWeb + ", visitada " + dateFormat.format(fechaHora);
	}

}
