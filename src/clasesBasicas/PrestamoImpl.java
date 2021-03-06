package clasesBasicas;

import interfaces.Prestamo;

/* ESTUDIO DE INTERFAZ
 * 
 * Propiedades básicas:
 * 		-> ID: int, consultable
 * 		-> cantidad: double, consultable, modificable
 * 		-> tiempoMeses: int, consultable, modificable
 * 
 * Propiedades derivadas:
 * 		-> mensualidad: double, consultable
 * 	
 * Propiedades compartidas: 
 */

/* INTERFAZ
 *  public int getID();
 *	public double getCantidad();
 *  public int getTiempoMeses();
 *	
 *	public double getMensualidad();
 */

public class PrestamoImpl implements Prestamo, Cloneable
{
	private int ID;
	private double cantidad;
	private int tiempoMeses;
	
	/**
	 * Constructor por defecto.
	 */
	public PrestamoImpl()
	{
		this.ID = 0;
		this.cantidad = 0;
		this.tiempoMeses = 0;
	}
	
	/**
	 * Constructor con parámetros.
	 * 
	 * @param ID El identificador del prestamo.
	 * @param cantidad La cantidad que se presta.
	 * @param tiempoMeses El tiempo en meses en el que se devolverá el préstamo.
	 */
	public PrestamoImpl(int ID, double cantidad, int tiempoMeses)
	{
		this.ID = ID;
		this.cantidad = cantidad;
		this.tiempoMeses = tiempoMeses;
	}
	
	/**
	 * Constructor de copia.
	 * 
	 * @param otro El otro préstamo del cual se desea copiar.
	 */
	public PrestamoImpl(PrestamoImpl otro)
	{
		this.ID = otro.ID;
		this.cantidad = otro.cantidad;
		this.tiempoMeses = otro.tiempoMeses;
	}
	
	public int getID() { return this.ID; }
	public double getCantidad() { return this.cantidad; }
	public int getTiempoMeses() { return this.tiempoMeses; }
	
	public double getMensualidad() { return this.cantidad / this.tiempoMeses; }
	
	@Override
	public int hashCode()
	{
		return (int) (this.ID * 7 + this.cantidad * 11 + this.tiempoMeses * 13);
	}
	
	/**
	 * Representacion como cadena, sus atributos separados por coma.
	 * <br> <b>Ejemplo: "73,25000,120"</b>
	 */
	@Override
	public String toString()
	{
		return "" + this.ID + "," + this.cantidad + "," + this.tiempoMeses;
	}
	
	@Override
	public PrestamoImpl clone()
	{
		PrestamoImpl copia = null;
		
		try
		{
			copia = (PrestamoImpl)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
		return copia;
	}
}
