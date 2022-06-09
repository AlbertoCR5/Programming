	//Anade cantidad de algo que ya existe o no existe CLASE RECETA
	public void annadirIngrediente(Ingrediente ingredienteNuevo) throws RecetaException {
		
		boolean esAnnadido = false;
		Ingrediente ingredienteColeccion;
		int nuevaCantidad;
		Iterator<Ingrediente> iterator = ingredientes.iterator(); 
		
		while (iterator.hasNext() && !esAnnadido) {
			ingredienteColeccion = iterator.next();
			
			if (ingredienteNuevo.equals(ingredienteColeccion)) {
				nuevaCantidad = ingredienteNuevo.getCantidad() + ingredienteColeccion.getCantidad();
				ingredienteColeccion.setCantidad(nuevaCantidad);
				esAnnadido = true;
			}
		}
		
		if (!esAnnadido) {
			ingredientes.add(ingredienteNuevo);
		}
		
	}	
	
	//Borrar de un listado
	public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException{
				
		if (!ingredientes.contains(ingredienteABorrar)) {
			throw new RecetaException("ingrediente no encontrado");
		}
		
		ingredientes.remove(ingredienteABorrar);
		
		Iterator<String> it = pasos.iterator();
		
		while (it.hasNext()) {
			String paso = (String) it.next();
			
			if (paso.contains(ingredienteABorrar.getNombreIngrediente())) {
				it.remove();
			}
		}
	}
	//anadir en hashmap
	public void annadirReceta( Receta nuevaReceta) throws RecetaException {
		
		if (recetas.containsKey(nuevaReceta.getNombreReceta())) {
			throw new RecetaException("Receta ya existente");
		}
		
		recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);	
	}
	//Ordenar listado
	public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
		
		StringBuilder sbListaRecetas = new StringBuilder();
		ArrayList<Receta> listaRecetasOrdenadas = new ArrayList<Receta>(recetas.values());
		
		Collections.sort(listaRecetasOrdenadas);
		
		for (Receta receta : listaRecetasOrdenadas) {
			sbListaRecetas.append(receta + "\n");
		}
		
		return sbListaRecetas.toString();
	}
	
	//ordenar cuando anteriormente ya existe un orden
	public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException{
		
		StringBuilder sbListaRecetasOrdenadasPorTiempo = new StringBuilder();
		ArrayList<Receta> listaRecetasConIngrediente = new ArrayList<Receta>(recetas.values());
		
		for (Receta receta : listaRecetasConIngrediente) {
			if (receta.necesitaIngrediente(ingrediente)) {
				listaRecetasConIngrediente.add(receta);
			}
		}
		
		Collections.sort(listaRecetasConIngrediente, new Comparator<Receta>() {
	
			@Override
			public int compare(Receta receta, Receta otraReceta) {
	
				return Integer.compare(receta.getMinutosDePreparacion(), otraReceta.getMinutosDePreparacion());
			}
		});
		
		for (Receta receta : listaRecetasConIngrediente) {
			sbListaRecetasOrdenadasPorTiempo.append(receta + "\n");
		}
		
		return sbListaRecetasOrdenadasPorTiempo.toString();
	}
	
	//CON LINKEDLIST
	//anade si es posible sin tirar excepcion
	public void agregarPedido(Pedido nuevoPedido){
		
		listaDePedidos.offer(nuevoPedido);
	}
	
	//Muestra, y una vez mostrado lo elimina
	public Pedido atenderPedido() throws PizzaException{
		
		Pedido pedido;
		
		if (listaDePedidos.size() == 0) {
			throw new PizzaException("Sin pedidos en cola");
		}
		
		pedido = listaDePedidos.poll();
		
		return pedido;
	}
	
	//anadirlo al final y asociar un numero, uno mas del ultimo
	public void annadirSocio (Socio socio)  throws FeriaException{
	
		boolean esAnnadido;
		
		esAnnadido = socios.add(socio);
		
		if (!esAnnadido) {
			throw new FeriaException("Socio ya existente");
		}
		
		if (socios.size() == 0) {
			socio.setNumeroAsignado(PRIMER_SOCIO);
		}
		else {
			socio.setNumeroAsignado(socios.getLast().getNumeroAsignado()+1);
		}
			
	}
	
	//ordenar Algo por un atributo y listar
	public String listadoCasetasDeUnaCalleOrdenadasPorNumero(String calle) {
		
		StringBuilder sbListadoCasetasDeUnaCalleOrdenadasPorNumero = new StringBuilder();
		ArrayList<Caseta> listaCasetasCalle = new ArrayList<Caseta>(casetas.values());
		
		for (Caseta caseta : listaCasetasCalle) {
			if (caseta.getCalle().equalsIgnoreCase(calle)) {
				listaCasetasCalle.add(caseta);
			}
		}
		
		Collections.sort(listaCasetasCalle);
		
		for (Caseta caseta : listaCasetasCalle) {
			if (caseta.getCalle().equalsIgnoreCase(calle)) {
				sbListadoCasetasDeUnaCalleOrdenadasPorNumero.append("Nombre: " + caseta.getNombre() + " Numero: " + caseta.getNumero());
			}
		}
		
		return sbListadoCasetasDeUnaCalleOrdenadasPorNumero.toString();
	}
	
	//Borrar algo en concreto
	public void borrarCasetaDeUnaCalle(String calle, String nombreCaseta) throws FeriaException{
		
		if (!casetas.containsKey(nombreCaseta)) {
			throw new FeriaException("Caseta no encontrada");
		}
		
		Caseta casetaEncontrada = casetas.get(nombreCaseta);
		
		if (!casetaEncontrada.getCalle().equalsIgnoreCase(calle)) {
			throw new FeriaException("Caseta no encontrada en esa calle"); 
		}
		
		casetas.remove(nombreCaseta);
		
		//**PARA MODIFICAR** ** ES OTRO METODO**
		if (casetaEncontrada.getCalle().equalsIgnoreCase(nuevaCalle)) {
			throw new FeriaException("Ya hay caseta con ese nombre en esa calle"); 
		}
		
		casetaEncontrada.setCalle(nuevaCalle);			
		//**
	}
	
	//Localizar algo
	public Grupo localizarGrupo( int nivel, char letra) {
		
		boolean esEncontrado = false;
		Grupo grupoEncontrado = null;
		Iterator<Grupo> it = grupos.iterator();
		
		while (it.hasNext() && !esEncontrado) {
			Grupo grupo = (Grupo) it.next();
			
			if (grupo.getNivel() == nivel && grupo.getLetra() == letra) {
				grupoEncontrado = grupo;
				esEncontrado = true;
			}
		}
		
		return grupoEncontrado;
	}
	
	//Anadir al ultimo lugar
	public void annadirGrupo (Grupo grupoNuevo) throws ColegioException {
		
		if (grupos.contains(grupoNuevo)) {
			throw new ColegioException("Grupo ya existente");
		}
		
		int posicion = buscarPosicion(grupoNuevo);
		
		grupos.add(posicion, grupoNuevo);	
	}		
	private int buscarPosicion(Grupo grupoNuevo) {
		
		int posicion = 0;
		boolean esEncontrado = false;
		Iterator<Grupo> it = grupos.iterator();
		
		while (it.hasNext() && !esEncontrado) {
			Grupo grupo = (Grupo) it.next();
			
			if (grupo.getNivel() > grupo.getNivel()) {
				esEncontrado = true;
			}
			else {
				posicion++;
			}
		}
		
		return posicion;
	}
	
	//Cambiar de uno a otro
	public void cambiarAlumnoDeGrupo(int numero, char letra, String dniAlumno, 
			int numeroGrupoNuevo, char letraGrupoNuevo) throws ColegioException{
		
		Grupo grupoOriginal = localizarGrupo(numero, letra);
		Grupo grupoNuevo = localizarGrupo(numeroGrupoNuevo, letraGrupoNuevo);
		
		if (grupoOriginal == null) {
			throw new ColegioException("Grupo No encontrado");
		}
		
		if (grupoNuevo == null) {
			throw new ColegioException("Grupo No encontrado");
		}
		
		Alumno alumno = grupoOriginal.localizarAlumnoPorDni(dniAlumno);
		
		if (alumno == null) {
			throw new ColegioException("Grupo No encontrado");
		}
		
		grupoOriginal.eliminarAlumnoDeGrupo(dniAlumno);
		grupoNuevo.annadirAlumnoAGrupo(alumno);
	}
	
	//Eliminar de un punto a otro
	public void eliminarCapitulosDesdeEste(String nombreCapituloInicial) throws SerieException{
		
		if (!capitulos.contains(nombreCapituloInicial)) {
			throw new SerieException("Capitulo no encontrado");
		}
		
		boolean esEncontrado = false;
		Iterator<String> it = capitulos.iterator();
		
		while (it.hasNext()) {
			String capitulo = (String) it.next();
			
			if (capitulo.contains(nombreCapituloInicial)) {
				esEncontrado = true;
				it.remove();
			}
			else {
				if (esEncontrado) {
					it.remove();
				}
			}
		}
	}
	
	//listado
	public  String listadoOrdenadoSeriesDeUnTema( Tema tema)  throws SerieException {
		
		StringBuilder sbListadoOrdenadoTema = new StringBuilder();
		ArrayList<Serie> listaSeries = new ArrayList<>(mapSeries.values());
		
		for (Serie serie : listaSeries) {
			if (serie.getTema().equals(tema)) {
				listaSeries.add(serie);
			}		
		}
		
		if (listaSeries.size() == 0) {
			throw new SerieException("Ya existe esa serie");
		}
		
		Collections.sort(listaSeries);
		
		for (Serie serie : listaSeries) {
			sbListadoOrdenadoTema.append(serie + "\n");
		}
		return sbListadoOrdenadoTema.toString();
	}
	
	//FICHEROS
	public class Ejercicio2 {

		//Tenemos en cuenta nombres de modelo de mas de una palabra
		private static final String PATRON_LINEA = "[0-9]{8}( ([0-9]|10)){1,6}";
		private static final String SUSPENSOS_TXT = "suspensos.txt";
		
		private static Scanner teclado = new Scanner(System.in);

		public static void main(String[] args) {

			String nombreFichero;
			System.out.println("Introduce el nombre del fichero con las matriculas");
			nombreFichero = teclado.nextLine();

			try {
				crearFicheroConSuspensos(nombreFichero);
			} catch (IOException e) {
				System.out.println("Error " + e.getMessage());
				borrarFicheroSuspensos();
			}

		}

		private static void borrarFicheroSuspensos() {
			File fdestino=new File(SUSPENSOS_TXT);
			if (fdestino.exists() && fdestino.isFile()) {
				fdestino.delete();
			}
			
		}

		private static void crearFicheroConSuspensos(String nombreFichero) throws IOException {

			String linea;
			File fdestino=new File(SUSPENSOS_TXT);
			if (fdestino.exists() && fdestino.isFile()) {
				throw new IOException("Ya existe el fichero suspensos " );
			}

			try (BufferedReader filtroLectura = new BufferedReader(new FileReader(nombreFichero));
				PrintWriter filtroEscritura = new PrintWriter( new FileWriter(SUSPENSOS_TXT)); ){
			
				

				linea = filtroLectura.readLine();
				while (linea != null) {
					escribirSiTieneSuspensos(linea, filtroEscritura);

					linea = filtroLectura.readLine();

				}

				System.out.println("Se ha creado correctamente el fichero " + SUSPENSOS_TXT);
			} catch (FileNotFoundException e) {
				System.out.println("No existe el fichero " + nombreFichero);
			} 

		}

		private static void escribirSiTieneSuspensos(String linea, PrintWriter filtroEscritura) throws IOException {
			
			int nota, contSuspensos=0;
			
			if (!linea.matches(PATRON_LINEA)) {
				throw new 	IOException("No encaja con el patron" + linea);
			}
			
			String[] partes= linea.split(" ");
			
			
			for (int i = 1; i < partes.length; i++) {
				nota=Integer.parseInt(partes[i]);
				if ( nota < 5) {
					contSuspensos++;
				}
			}
			
			if ( contSuspensos > 0) {
				filtroEscritura.println("ALUMNO CON DNI= " + partes[0] + " SUSPENSOS= " + contSuspensos + "\n");
			}
		}
	}