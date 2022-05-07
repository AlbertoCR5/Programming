package ejercicio04ProfesorAlumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public abstract class Persona {
	
	private static final int EDAD_MINIMA = 12;
	
	// Atributos
	private String dni;
	private String nombre;
	private int edad;
	private LinkedList<Mensaje>mensajes;

	
	// Constructor
	public Persona(String dni,String nombre,int edad) throws IESException {
		this.dni=dni;
		this.nombre = nombre;
		
		setEdad(edad);
	}

	// Métodos get y set
	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setEdad(int edad) throws IESException {
		if (edad < EDAD_MINIMA)
			throw new IESException("La edad minima es de" + EDAD_MINIMA);
		this.edad = edad;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public void enviarCorreo(String msg, Persona destinatario) throws IESException{
		
		Mensaje mensaje = new Mensaje(this, msg);
		
		destinatario.mensajes.add(0, mensaje); //Con el 0 hacemos que se anada en la primera posicion, para ser el mensaje mas reciente
	}
	
	public String mostrarMensajes() throws IESException {
		
		StringBuilder sbMensajes = new StringBuilder();
		int numeroMensaje = 1;
		
		if (mensajes.size() == 0) {
			throw new IESException("No hay ningun mensaje en el buzon");
		}
		
		for (Mensaje mensaje : mensajes) {
			System.out.print(numeroMensaje);
			sbMensajes.append(mensaje + "\n");
			numeroMensaje++;
		}
		
		return sbMensajes.toString();
	}
	
	public void borrarMensaje(int numeroMensaje) throws IESException {
		
		if (numeroMensaje <= 0 || numeroMensaje > mensajes.size()) {
			throw new IESException("No existe el mensaje seleccionado");
		}
		
		mensajes.remove(numeroMensaje-1);
	}
	
	public String mostrarMensajesOrdenadosPorRemitente() throws IESException {
		
		StringBuilder sbMensajesOrdenados = new StringBuilder();
		
		if (mensajes.size() == 0) {
			throw new IESException("No hay ningun mensaje en el buzon");
		}
		
		ArrayList<Mensaje> mensajesOrdenados = new ArrayList<Mensaje>(mensajes);//WHAT!!!!????
		Collections.sort(mensajes);
		
		for (Mensaje mensaje : mensajes) {
			sbMensajesOrdenados.append(mensaje + "\n");
		}
		
		return sbMensajesOrdenados.toString();		
	}
	
	public String buscarMensajeConTexto(String texto) throws IESException {
		
		StringBuilder sbMensajesConTextoBuscado = new StringBuilder();
		
		for (Mensaje mensaje : mensajes) {
			if (mensaje.getTexto().contains(texto)) {
				sbMensajesConTextoBuscado.append(mensaje + "\n");
			}
		}
		
		if (sbMensajesConTextoBuscado.length() == 0) {
			throw new IESException("No hay ningun mensaje en el buzon con el texto seleccionado");
		}
		
		return sbMensajesConTextoBuscado.toString();		
	}
	
}

