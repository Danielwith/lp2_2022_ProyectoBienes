package com.bienes.entidad;

import java.sql.Date;

public class InscripcionSUNARP {

		public int codigo_inscri;
		public String descrip_bien;
		public int cantidad_bien;
		public double precio_bien;
		public String nom_provee;
		public Date fecha_llegada;
		
		
		
		public int getCodigo_inscri() {
			return codigo_inscri;
		}
		public void setCodigo_inscri(int codigo_inscri) {
			this.codigo_inscri = codigo_inscri;
		}
		public String getDescrip_bien() {
			return descrip_bien;
		}
		public void setDescrip_bien(String descrip_bien) {
			this.descrip_bien = descrip_bien;
		}
		public int getCantidad_bien() {
			return cantidad_bien;
		}
		public void setCantidad_bien(int cantidad_bien) {
			this.cantidad_bien = cantidad_bien;
		}
		public double getPrecio_bien() {
			return precio_bien;
		}
		public void setPrecio_bien(double precio_bien) {
			this.precio_bien = precio_bien;
		}
		public String getNom_provee() {
			return nom_provee;
		}
		public void setNom_provee(String nom_provee) {
			this.nom_provee = nom_provee;
		}
		public Date getFecha_llegada() {
			return fecha_llegada;
		}
		public void setFecha_llegada(Date fecha_llegada) {
			this.fecha_llegada = fecha_llegada;
		}	
}
