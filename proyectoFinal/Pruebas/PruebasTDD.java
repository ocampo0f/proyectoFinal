package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Service.Cliente;
import Service.Concesionario;

class PruebasTDD {
//PRUEBAS CLIENTE
	@Test
	public void existeClienteResiveUnCliente () {
		Concesionario concesionario = new Concesionario("el gangazo");
		Cliente cliente = new Cliente("juan","Recreo","311755013","juanj.orozc@uvq.co");
		Cliente cliente2 = new Cliente("juann","Recreoo","4311755013","juanj0.orozc@uvq.nco");
		
		concesionario.agregarCliente(cliente);
		concesionario.agregarCliente(cliente2);
		
		assertTrue(concesionario.getClientes().contains(cliente));
		assertTrue(concesionario.getClientes().contains(cliente2));
		
		assertEquals(2, concesionario.getClientes().size());
	}
	
	@Test
	public void actualizarCliente() {
		Concesionario concesionario = new Concesionario("el gangazo");
		Cliente c = new Cliente("juann","Recreo","311755013","juanj.orozc@uvq.co");
		String nombre = "juan";
		String direccion = "elvira";
		String numeroTelefono = "3165467455";
		String correo = "josejose@gmail.com";
		concesionario.actualizarCliente(nombre, direccion, numeroTelefono, correo, c);
		assertEquals(nombre, c.getNombre());
	}
	@Test
	public void verifacarAgregarcliente() {
		Concesionario concesionario = new Concesionario("el gangazo");
		Cliente c = new Cliente("juann","Recreo","311755013","juanj.orozc@uvq.co");
		concesionario.agregarCliente(c);
		assertEquals(concesionario.buscarCliente(c.getNumeroTelefono()),c);
		
	}
	 @Test
	    public void verificarAgregarClienteConatributoNull() {
	        assertThrows(Throwable.class, () -> new Cliente(null, null, "311755013", "juanj.orozc@uvq.co"));
	    }
	 @Test
	 public void verificarRetornoDeBuscarCliente() {
		 Concesionario concesionario = new Concesionario("el gangazo");
		 Cliente c = new Cliente("juann","Recreo","311755013","juanj.orozc@uvq.co");  
		 concesionario.agregarCliente(c);
		 Cliente cliente=concesionario.buscarCliente("311755013");
		 assertEquals(c,cliente);
	 }
	 @Test
	 public void verificarEliminarCliente() {
		 Concesionario concesionario = new Concesionario("el gangazo");
		 Cliente c = new Cliente("juann","Recreo","311755013","juanj.orozc@uvq.co");  
		 concesionario.agregarCliente(c);
		 boolean estado=concesionario.eliminarCliente("311755013");
		 assertTrue(estado);
	 }
	 @Test
	 public void verificarRetornoMetodoInfoCliente() {
		 Concesionario concesionario = new Concesionario("el gangazo");
		 Cliente c = new Cliente("juann","Recreo","311755013","juanj.orozc@uvq.co");  
		 concesionario.agregarCliente(c);
		 String infoCliente=concesionario.infoCliente(c);
		 assertEquals(infoCliente,"Cliente [nombre=juann, direccion=Recreo, numeroTelefono=311755013, correo=juanj.orozc@uvq.co]");
	 }
	
//PRUEBAS MANTENIMIENTO
}
