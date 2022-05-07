package recuperacionAbril2022;

public class Main {

	public static void main(String[] args) {
		Persona ralph = new Persona("Ralph", "Wiggun", "00000X", 666123456);
		
		try {
		Casa casaEnSpringfield = new Casa(1, "Evergreen Terrace 21", Construccion.COEFICIENTE_ENERGETICO_A, 140, 4, 2, 2, true, true, ralph, 2, 300, true); 

		Piso pisoEnChipiona = new Piso(2, "Virgen de regla 1", Construccion.COEFICIENTE_ENERGETICO_A, 70, 2, 1, 0, false, true, ralph, 3, '2');
		
				

		System.out.println("Bienvenido a su casa " + ralph.getNombre() + " " + ralph.getApellidos());
		System.out.println(dibujoCasa);

		System.out.println("Su factura de agua es:" + casaEnSpringfield.facturaAgua(50));
		System.out.println("Su factura de luz es:" + casaEnSpringfield.facturaLuz(300));
		System.out.println("Paga de impuestos:" + casaEnSpringfield.impuestos());

		System.out.println(
				"\nBienvenido a su piso en " + pisoEnChipiona.getDireccion() + ", " + ralph.getNombre() + " " + ralph.getApellidos());
		System.out.println(dibujoEdificio);
		System.out.println("Su factura de agua es:" + pisoEnChipiona.facturaAgua(30));
		System.out.println("Su factura de luz es:" + pisoEnChipiona.facturaLuz(200));
		System.out.println("Paga de impuestos:" + pisoEnChipiona.impuestos());
		} catch (ConstruccionException e) {

			e.printStackTrace();
		}
	}

	public static String dibujoCasa = "      `'::::.\r\n" + "        _____A_\r\n" + "       /      /\\\r\n"
			+ "    __/__/\\__/  \\___\r\n" + "---/__|\" '' \"| /___/\\----\r\n" + "   |''|\"'||'\"| |' '||\r\n"
			+ "   `\"\"`\"\"))\"\"`\"`\"\"\"\"`";

	public static String dibujoEdificio = "    _._._._._._._._._._._._._._._._._   ^\n"
			+ "    | ___   ___    ___    ___   ___ |\n" + "^!^ ||_|_| |_|_|  |_|_|  |_|_| |_|_||\n"
			+ "    |IIIII_IIIII__IIIII__IIIII_IIIII|      ^\n" + "    | ___   ___    ___    ___   ___ |\n"
			+ "    ||_|_| |\\O/|  |_|_|  |_|_| |_|_||\n" + "    |IIIII_IIIII__IIIII__IIIII_IIIII|\n"
			+ " _  | ___   ___    ___    ___   ___ |\n" + "    ||_|_| |_|_|  |_|_|  |_|_| |_|_||\n"
			+ "    |IIIII_IIIII__IIIII__IIIII_IIIII|    /)\n" + "    | ___   ___   _____   ___   ___ | __/ ),\n"
			+ " ~^ ||_|_| |_|_|  o~|~o  |_|_| |_|_||  ~^~^\n" + "..'.|IIIII_IIIII__|_|_|__IIIII_IIIII|'^~^'.',\n"
			+ "., .|'''''''''''' /====\\''''''''''''|.'.'.'.\n" + "`~ ` '^^~ '' ^^~'` ''     `',``~^^'' ~^^'   '~'\n";

}
