package hospitalArray;

import java.util.Arrays;

public class Urgencias {

	private static final int MAXIMO = 100;
	private Paciente[] pacientesAAtender;
	private int numeroPacientes=0;
	
	public Urgencias() {
		pacientesAAtender=new Paciente[MAXIMO];
	}
	public void incluirPaciente(Paciente pacienteNuevo) {
		pacientesAAtender[numeroPacientes]=pacienteNuevo;
		numeroPacientes++;
	}
	
	public Paciente atenderPaciente() {
		
		Paciente pacienteSiguiente = null;
		if (pacientesAAtender.length <= 0) {
			System.out.println("No hay pacientes que atender en este momento");
		}
		else {
			if (numeroPacientes > 1) {
				pacienteSiguiente = siguientePacienteAAtender();
				pacientesAAtender[0] = null;
			} else {
				pacienteSiguiente = pacientesAAtender[0];
				pacientesAAtender[0] = null;
			}
		}
		
		
		return pacienteSiguiente;
		
	}
	
	public Paciente siguientePacienteAAtender() {
		Arrays.sort(pacientesAAtender);
		
		return pacientesAAtender[0];
		
	}
	
}
