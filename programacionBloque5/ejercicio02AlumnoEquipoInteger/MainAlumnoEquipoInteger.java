package ejercicio02AlumnoEquipoInteger;

public class MainAlumnoEquipoInteger {

	public static void main(String[] args) {

		Equipo<Integer> equipo1, equipo2, equipo3, equipoFusionado, equipoInterseccion;
		try {
			
			equipo1 = new Equipo<Integer>("Equipo1");

			equipo2 = new Equipo<Integer>("Equipo2");
			equipo3 = new Equipo<Integer>("Equipo3");
		
			crearEquipo(equipo1, equipo2, equipo3);

			equipo1.borrarAlumno( Integer.valueOf(1));

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

	private static void crearEquipo (Equipo<Integer> equipo1, Equipo<Integer> equipo2, Equipo<Integer> equipo3) {

		Integer nuevoAlumno;

		try {
			nuevoAlumno = Integer.valueOf(1);
			equipo1.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(2);
			equipo1.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(3);
			equipo1.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(4);
			equipo1.insertarAlumno(nuevoAlumno);
//			nuevoAlumno = new Alumno("12345678T", "Otro a");//Este alumno no se inserta
//			equipo1.insertarAlumno(nuevoAlumno);

			nuevoAlumno = Integer.valueOf(5);
			equipo2.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(6);
			equipo2.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(4);
			equipo2.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(3);
			equipo2.insertarAlumno(nuevoAlumno);

			nuevoAlumno = Integer.valueOf(6);
			equipo3.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(12);
			equipo3.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(13);
			equipo3.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(4);
			equipo3.insertarAlumno(nuevoAlumno);
		} catch (EquipoException e) {
			e.getMessage();
		}

	}

}
