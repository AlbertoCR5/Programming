package ejercicio04ProfesorAlumno;

public class MainProyectoCorreo {

	public static void main(String[] args) {

		try {
			Profesor profesor1=new Profesor("11", "Pepe", 30);
			Profesor profesor2=new Profesor("12", "Pepa", 32);
			Alumno alumno1 =  new Alumno("283331", "Juan", 15, TipoEnsennanza.ESO, 4);
			Alumno alumno2 =  new Alumno("2833331", "Alberto", 21, TipoEnsennanza.CICLO, 2);
			profesor1.enviarCorreo("Hola hola", profesor2);
			profesor1.enviarCorreo("Adios", profesor2);
			alumno1.enviarCorreo("Adios", alumno2);
			
			System.out.println(profesor2.mostrarMensajesOrdenadosPorRemitente());
		} catch (IESException e) {
			System.out.println(e.getMessage());
		}

	}

}
