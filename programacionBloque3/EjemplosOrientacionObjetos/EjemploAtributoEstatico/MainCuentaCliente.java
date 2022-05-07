package EjemplosOrientacionObjetos.EjemploAtributoEstatico;

public class MainCuentaCliente {

	public static void main(String[] args) {
		try {
			Cuenta c1 = new Cuenta(100);
			Cuenta c2 = new Cuenta(200);
			Cuenta c3 = new Cuenta(300);

//			c1.realizarIngreso(50);
//			c2.realizarIngreso(500);
//			Cuenta c4=new Cuenta(50);
//			c3.realizarIngreso(600);
			
			c1.transferencia( 101, c3);
			
			System.out.println(c1);
			System.out.println(c3);

		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		}

	}

}
