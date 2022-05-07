package ejercicio02AlumnoEquipoInteger;

public class MainAlumnoEquipo {

	public static void main(String[] args) {

		try {
			Equipo equipo1, equipo2, equipo3, equipoFusionado, equipoInterseccion;
			
			equipo1 = new Equipo("Equipo1");

			equipo2 = new Equipo("Equipo2");
			equipo3 = new Equipo("Equipo3");
		
			crearEquipo(equipo1, equipo2, equipo3);

			equipo1.borrarAlumno(new Alumno("28663291K", "Cualquiera"));

			System.out.println(equipo1);
			System.out.println(equipo2);
			System.out.println(equipo3);

			equipoFusionado = equipo1.fusionDeEquipos(equipo2, "Equipo 1y2");

			equipoInterseccion = equipo3.intersecionDeEquipos(equipo2, "EquipoRepetidos 2y3");

			System.out.println(equipoFusionado);
			System.out.println(equipoInterseccion);

		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void crearEquipo(Equipo equipo1, Equipo equipo2, Equipo equipo3) {

		Alumno nuevoAlumno;

		try {
			nuevoAlumno = new Alumno("12345678T", "alberto");
			equipo1.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("28663291K", "benito");
			equipo1.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("34567891M", "carlos");
			equipo1.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("45678912F", "david");
			equipo1.insertarAlumno(nuevoAlumno);
//			nuevoAlumno = new Alumno("12345678T", "Otro a");//Este alumno no se inserta
//			equipo1.insertarAlumno(nuevoAlumno);

			nuevoAlumno = new Alumno("56789123Y", "Alumno 5");
			equipo2.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("67891234D", "Alumno 6");
			equipo2.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("45678912F", "david");
			equipo2.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("34567891M", "carlos");
			equipo2.insertarAlumno(nuevoAlumno);

			nuevoAlumno = new Alumno("67891234D", "Alumno 6");
			equipo3.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("12987654P", "Alumno 12");
			equipo3.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("13987654L", "Alumno 13");
			equipo3.insertarAlumno(nuevoAlumno);
			nuevoAlumno = new Alumno("45678912F", "david");
			equipo3.insertarAlumno(nuevoAlumno);
		} catch (EquipoException e) {
			e.getMessage();
		}

	}

}
