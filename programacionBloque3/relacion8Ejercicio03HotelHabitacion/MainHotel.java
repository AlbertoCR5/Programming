package relacion8Ejercicio03HotelHabitacion;

public class MainHotel {

	public static void main(String[] args) {
		
		int numeroHabitacion;
		try {
			Hotel hotel=new Hotel( 3,4,2);
			System.out.println(hotel);
			
			numeroHabitacion=hotel.checkIn("SIMPLE");
			System.out.println("Le corresponde la habitacion " + numeroHabitacion);
			
			numeroHabitacion=hotel.checkIn("DOBLE");
			System.out.println("Le corresponde la habitacion " + numeroHabitacion);
			
			numeroHabitacion=hotel.checkIn("DOBLE");
			System.out.println("Le corresponde la habitacion " + numeroHabitacion);
			
			hotel.checkOut(5);
			
			numeroHabitacion=hotel.checkIn("DOBLE");
			System.out.println("Le corresponde la habitacion " + numeroHabitacion);
			
			numeroHabitacion=hotel.checkIn("TRIPLE");
			System.out.println("Le corresponde la habitacion " + numeroHabitacion);
			
			numeroHabitacion=hotel.checkIn("TRIPLE");
			System.out.println("Le corresponde la habitacion " + numeroHabitacion);
			
			System.out.println(hotel);
			
			numeroHabitacion=hotel.checkIn("TRIPLE");
			System.out.println("Le corresponde la habitacion " + numeroHabitacion);
			
		}catch( HotelException e) {
			System.out.println(e.getMessage());
		}

	}

}