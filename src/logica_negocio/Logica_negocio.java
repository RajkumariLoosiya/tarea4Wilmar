package logica_negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import beans.Compra;
import dbrelated.ConexionBaseDatos;

public class Logica_negocio {

	public List<Compra> limpiezaDatos() {

		String direccion = "C:\\Users\\migue\\Desktop\\Ejercicio4\\Datos_de_Compras.txt";
		String linea = "";
		String[] linea2 = null;
		List<Compra> comprasProcesadas = new ArrayList<>();
		int comprasRealizadas = 0;

		try {

			BufferedReader reader = new BufferedReader(new FileReader(direccion));
			while ((linea = reader.readLine()) != null) {

				if (linea.contains("id:")) {
					linea2 = linea.replaceAll("\\s", "").replace("***", ",").substring(1).split(",");
					Compra compra = new Compra(linea2[0].substring(3), linea2[1].substring(9), linea2[2].substring(8),
							linea2[3].substring(9), linea2[4].substring(8));
					comprasProcesadas.add(compra);
					comprasRealizadas++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comprasProcesadas;

	}

	public void precioPromedio(List<Compra> listaEntrada) {

		Double resultado = 0.0;
		Double promedio = 0.0;
		DecimalFormat total = new DecimalFormat("#.##"); 
		
		
		for (Compra i : listaEntrada) {
			resultado = resultado + Double.parseDouble(i.getPrecio());
		}
		
		promedio = resultado / listaEntrada.size();
		String resultado2 = total.format(promedio);
		System.out.println("Este es el promedio : " + resultado2);
		
		BigDecimal decimalGrande = new BigDecimal(promedio);
		decimalGrande = decimalGrande.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(decimalGrande.toString());
	}

	public void compraMasCara(List<Compra> listaEntrada) {

		Double maximo = 0.0;

		for (Compra i : listaEntrada) {

			if (maximo < Double.parseDouble(i.getPrecio())) {
				maximo = Double.parseDouble(i.getPrecio());
			}
		}

		System.out.println("El precio máximo es de :" + maximo);

	}

	public void buscarCliente(List<Compra> listaEntrada) {

		String nombre = "Ana";
		String vacio = "";
		String resultado;

		for (Compra i : listaEntrada) {
			vacio = i.getCliente();
			if (vacio.contains(nombre)) {
				System.out.println(i.toString());
			}

		}

	}
	
	public void usoBaseDatos(List<Compra>listaEntrada) {
		
		ConexionBaseDatos cbd = new ConexionBaseDatos(); 
		
//		String query = "CREATE TABLE IF NOT EXISTS COMPRAS(ID INT,PRODUCTO VARCHAR(50),PRECIO DOUBLE,GARANTIA INT,CLIENTE VARCHAR(50))";
		String query = "INSERT INTO COMPRAS VALUES(?,?,?,?,?)";
		
		try {
			
			PreparedStatement pst = cbd.getConx().prepareStatement(query);
			for(Compra i: listaEntrada) {
			pst.setInt(1, Integer.parseInt(i.getId()));
			pst.setString(2, i.getNombre());
			pst.setDouble(3, Double.parseDouble(i.getPrecio()));
			pst.setInt(4, Integer.parseInt(i.getAñosGaran()));
			pst.setString(5, i.getCliente());
			pst.executeUpdate();
			}
			cbd.closeConx();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	public void impresionCompras(List<Compra> listaEntrada) {

		for (Compra i : listaEntrada) {
			System.out.println(i.toString());
		}

	}

}
