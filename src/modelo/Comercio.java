package modelo;
import java.util.List;
/**
 * @author usuario1
 *
 */
public class Comercio extends Actor {
	private String nombreComercio;
	private long cuit;
	private double CostoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private List<DiaRetiro> lstDiaRetiro;
	private List<Articulo> lstArticulo;
	private List<Carrito> lstCarrito;
	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo, List<DiaRetiro> lstDiaRetiro,
			List<Articulo> lstArticulo, List<Carrito> lstCarrito) {
		super(id, contacto);
		this.nombreComercio = nombreComercio;
		this.cuit = cuit;
		CostoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = lstDiaRetiro;
		this.lstArticulo = lstArticulo;
		this.lstCarrito = lstCarrito;
	}
	public String getNombreComercio() {
		return nombreComercio;
	}
	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public double getCostoFijo() {
		return CostoFijo;
	}
	public void setCostoFijo(double costoFijo) {
		CostoFijo = costoFijo;
	}
	public double getCostoPorKm() {
		return costoPorKm;
	}
	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}
	public int getDiaDescuento() {
		return diaDescuento;
	}
	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}
	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}
	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}
	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}
	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}
	public List<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}
	public void setLstDiaRetiro(List<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}
	public List<Articulo> getLstArticulo() {
		return lstArticulo;
	}
	public void setLstArticulo(List<Articulo> lstArticulo) {
		this.lstArticulo = lstArticulo;
	}
	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}
	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	@Override
	public String toString() {
		return "Comercio [nombreComercio=" + nombreComercio + ", cuit=" + cuit + ", CostoFijo=" + CostoFijo
				+ ", costoPorKm=" + costoPorKm + ", diaDescuento=" + diaDescuento + ", porcentajeDescuentoDia="
				+ porcentajeDescuentoDia + ", porcentajeDescuentoEfectivo=" + porcentajeDescuentoEfectivo
				+ ", lstDiaRetiro=" + lstDiaRetiro + ", lstArticulo=" + lstArticulo + ", lstCarrito=" + lstCarrito
				+ "]";
	}
}
