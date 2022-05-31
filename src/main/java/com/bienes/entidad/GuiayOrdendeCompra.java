package com.bienes.entidad;

import java.sql.Date;

public class GuiayOrdendeCompra {

		public int codigoguiacompra;
		public String nom_provee;
		public Date fecha_compra;
		public String descripcionguiacompra;
		public String cantidadguiacompra;
		public Double precioguiacompra;
		
		public int getCodigoguiacompra() {
			return codigoguiacompra;
		}
		public void setCodigoguiacompra(int codigoguiacompra) {
			this.codigoguiacompra = codigoguiacompra;
		}
		public String getNom_provee() {
			return nom_provee;
		}
		public void setNom_provee(String nom_provee) {
			this.nom_provee = nom_provee;
		}
		public Date getFecha_compra() {
			return fecha_compra;
		}
		public void setFecha_compra(Date fecha_compra) {
			this.fecha_compra = fecha_compra;
		}
		public String getDescripcionguiacompra() {
			return descripcionguiacompra;
		}
		public void setDescripcionguiacompra(String descripcionguiacompra) {
			this.descripcionguiacompra = descripcionguiacompra;
		}
		public String getCantidadguiacompra() {
			return cantidadguiacompra;
		}
		public void setCantidadguiacompra(String cantidadguiacompra) {
			this.cantidadguiacompra = cantidadguiacompra;
		}
		public Double getPrecioguiacompra() {
			return precioguiacompra;
		}
		public void setPrecioguiacompra(Double precioguiacompra) {
			this.precioguiacompra = precioguiacompra;
		}
		
}
