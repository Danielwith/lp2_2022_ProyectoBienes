package com.bienes.entidad;

import java.sql.Date;

public class Bienes {

		public int codigo_bien;
		public String descrip_bien;
		public int cantidad_bien;
		public String nom_provee;
		public Date fecha_llegada;
		public String nom_operador;
		public int idproveedor;
		public int codigoOrdendeCompra;
		
		public int getCodigo_bien() {
			return codigo_bien;
		}
		public void setCodigo_bien(int codigo_bien) {
			this.codigo_bien = codigo_bien;
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
		public String getNom_operador() {
			return nom_operador;
		}
		public void setNom_operador(String nom_operador) {
			this.nom_operador = nom_operador;
		}
		public int getIdproveedor() {
			return idproveedor;
		}
		public void setIdproveedor(int idproveedor) {
			this.idproveedor = idproveedor;
		}
		public int getCodigoOrdendeCompra() {
			return codigoOrdendeCompra;
		}
		public void setCodigoOrdendeCompra(int codigoOrdendeCompra) {
			this.codigoOrdendeCompra = codigoOrdendeCompra;
		}
}
