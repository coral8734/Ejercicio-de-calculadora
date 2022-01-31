package PracticaCalculadora;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.PrimitiveIterator.OfInt;

import javax.accessibility.AccessibleContext;
import javax.swing.JOptionPane;


public class Controlador {
	
	
	public static double Suma(double num1,double num2) {
		
		  return num1 + num2;
	}
	
	
	public static double Resta(double num1,double num2) {
		
		  return  num1 - num2;
	}
	public static double Multiplicacion(double num1, double num2) {
		
		  return num1 * num2;
	}

	public static double Division(double num1,double num2) {
		
		  return  num1 / num2;
	}
	public static double Porcentaje(double num1,double num2) {
		
		  return  (num1 * num2)/100;
	}
	
	public static double RaizCuadrada(double num1) {
		
		  return  Math.sqrt(num1);
		  	  
	}
	public static double Potencia(double num1, double num2) {
		
		return Math.pow(num1, num2);
		
	}
	
	 public static double Inversa(double num1){
		 
		 return 1/num1;
	 }

	 
	 public static double Coseno(double num1){
			
			return Math.cos(Math.PI/180*num1);
		}
		public static double Seno(double num1){
			
			return Math.sin(Math.PI/180*num1);
		}
		public static double Tangente(double num1){
			
			return Math.tan(Math.PI/180*num1);
		}
		public static double Cotangente(double num1,double cotangente){
			
			return cotangente = Math.cos(Math.PI/180*num1)/Math.sin(Math.PI/180*num1);
		}
		public static double Secante(double num1,double secante){
			
			return  secante = 1 / Math.cos(Math.PI/180*num1);
		}
		
		public static double Cosecante(double num1,double cosecante){
			
			return  cosecante = 1 / Math.sin(Math.PI/180*num1);
		}
		public static double Arcseno(double num1,double arcoseno){
			
			return  arcoseno = Math.asin(num1*180/Math.PI);
		}
		public static double ArcCos(double num1,double arcoseno){
			
			return  arcoseno = Math.acos(num1*180/Math.PI);
		}
	

	
}
