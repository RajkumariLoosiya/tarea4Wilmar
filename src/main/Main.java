package main;

import logica_negocio.Logica_negocio;

public class Main {

	public static void main(String[] args) {
		Logica_negocio logicanegocio = new Logica_negocio(); 
		
//		logicanegocio.precioPromedio(logicanegocio.limpiezaDatos());
//		logicanegocio.compraMasCara(logicanegocio.limpiezaDatos());
//		logicanegocio.buscarCliente(logicanegocio.limpiezaDatos());
		logicanegocio.usoBaseDatos(logicanegocio.limpiezaDatos());
	}

}
