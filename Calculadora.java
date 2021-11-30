import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculadora {

	static double numero1 , numero2;//operandos aritmeticos
	static int operacion, tipoOperacion;//seleccionar operacion y tipo de operacion
	static boolean salir = false, booleano1 = false, booleano2 = false;//variable bandera y operandos logicos
	static int respuesta;//para repetir operacion
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader (isr);
	
	public static void main(String[] args) throws  IOException {
		
		do {
			try {
				menu();
				elegirMenu(tipoOperacion);
				repetirPrograma();
			}
			catch(NumberFormatException nfe) {
				System.out.println("Eso no es un valor valido.");
			}
		
		
		
		
		}while(salir == false);
		
	}
	
	//ELEGIR ENTRE MENU ARITMETICO O LOGICO
	
	public static void menu() throws IOException, NumberFormatException {
		do {
			System.out.println("Elige que hacer:");
			System.out.println("1.Operación Aritmética");
			System.out.println("2.Operación Lógica");
		
			tipoOperacion = Integer.parseInt(br.readLine());
			if (tipoOperacion < 1 || tipoOperacion > 2) {
				System.out.println("No has elegido una opcion correcta.");
			}
		}while(tipoOperacion < 1 || tipoOperacion > 2);
	}
	
	//EJECUCION DEL MENU ARITMETICO O LOGICO
	
	public static void elegirMenu(int elegir) throws IOException, NumberFormatException {
		switch (elegir) {
		case 1: {
			
			elegirOperacionAritmetica();
			operandosAritmeticos();
			menuAritmetico();
			
			break;
		}
		case 2:{
			elegirOperacionLogica();
			operandosLogicos();
			menuLogico();
			break;
		}
		default:
			System.out.println("No has introducido un numero correcto...");
		}
	}
	
	//SELECCIONAR OPERACION ARITMETICA
	
	public static void elegirOperacionAritmetica() throws  IOException, NumberFormatException {
		do {
			System.out.println("Elige: ");
			System.out.println("1.Sumar");
			System.out.println("2.Restar");
			System.out.println("3.Multiplicar");
			System.out.println("4.Dividir");
			
		
			operacion = Integer.parseInt(br.readLine());
			if (operacion < 1 || operacion > 4) {
				System.out.println("No has elegido una opcion correcta.");
			}
		}while(operacion < 1 || operacion > 4);
	}
	
	//SELECCIONAR OPERACION LOGICA
	
	public static void elegirOperacionLogica() throws  IOException, NumberFormatException {
		do {
			System.out.println("Elige para comparar dos numeros: ");
			System.out.println("1.AND");
			System.out.println("2.OR");
			System.out.println("3.NOT");
			System.out.println("4.XOR");
			System.out.println("5.NAND");
			System.out.println("6.NOR");
		
			operacion = Integer.parseInt(br.readLine());
			if (operacion < 1 || operacion > 6) {
				System.out.println("No has elegido una opcion correcta.");
			}
		}while(operacion < 1 || operacion > 6);
		
	}
	
	//OPERANDOS ARITMETICOS
	
	public static void operandosAritmeticos() throws  IOException {
		System.out.println("Añada el primer numero: ");
		numero1 = Double.parseDouble(br.readLine());
		
		do {
			System.out.println("Añada el segundo numero: ");
			numero2 = Double.parseDouble(br.readLine());
			if(operacion == 4 && numero2 == 0) {
				System.out.println("No se puede dividir un número entre 0.");
				System.out.println("Pruebe de nuevo.");
			}
		}
		while(operacion == 4 && numero2 == 0);
		
		
	}
	
	//OPERANDOS LOGICOS
	
	public static void operandosLogicos() throws  IOException {
		do {
			System.out.println("Añada '1' para 'true' o '0' para 'false': ");
			numero1 = Double.parseDouble(br.readLine());
			if(numero1 == 1)
				booleano1 = true;
			else
				booleano1 = false;
			//System.out.println(b1); comprobación de valor
			if (operacion!=3)	{
				System.out.println("Añada 'true' o 'false': ");
				numero2 = Double.parseDouble(br.readLine());
				if(numero2 == 1)
					booleano2 = true;
				else
					booleano2 = false;
			}	
		
		}while(numero1 != 1 && numero1 != 0 && numero2 != 1 && numero2 != 0);
	}
	
	//ELEGIR OPERACION ARITMETICA
	
	public static void menuAritmetico() {
		switch (operacion) {
		case 1: {
			System.out.println(hacerSuma(numero1,numero2));			
		}break;
		case 2: {
			System.out.println(hacerResta(numero1,numero2));			
		}break;
		case 3: {
			System.out.println(hacerMultiplicacion(numero1,numero2));			
		}break;
		case 4: {
			System.out.println(hacerDivision(numero1,numero2));	
		}break;
		
		default:
			System.out.println("No has elegido una oopcion correcta...");
		}
			
	}
	
	//ELEGIR OPERACION LOGICA
	
	public static void menuLogico() {
		switch (operacion) {
		case 1: {
			System.out.println(hacerAnd(booleano1,booleano2));			
		}break;
		case 2: {
			System.out.println(hacerOr(booleano1,booleano2));			
		}break;
		case 3: {
			System.out.println(hacerNot(booleano1));			
		}break;
		case 4: {
			System.out.println(hacerXor(booleano1,booleano2));			
		}break;
		
		case 5: {
			System.out.println(hacerNand(booleano1,booleano2));			
		}break;
		case 6: {
			System.out.println(hacerNor(booleano1,booleano2));			
		}break;
		
		default:
			System.out.println("No has elegido una oopcion correcta...");
		}
	}
	
	//REPETIR PROGRAMA
	
	public static boolean repetirPrograma() throws IOException, NumberFormatException {

		do {
			
			System.out.println("¿Quieres hacer otra operación? ");
			System.out.println("1.Repetir ");
			System.out.println("0.Salir ");
			respuesta = Integer.parseInt(br.readLine());
			
		}while(respuesta !=0 && respuesta != 1);
		
		if (respuesta == 1) {
			return salir = false;
		}
		else {
			
			System.out.println("Saliendo del programa...");
			return salir = true;
		}
		
		
	}
	
	//OPERACIONES ARITMETICAS
	
	private static double hacerSuma(double numero1, double numero2) {
		return (numero1 + numero2);
	}

	private static double hacerResta(double numero1, double numero2) {
		return (numero1 - numero2);
	}
	
	private static double hacerMultiplicacion(double numero1, double numero2) {
		return (numero1 * numero2);
	}
	
	private static double hacerDivision(double numero1, double numero2) {
		return (numero1 / numero2);
	}
	
	
	
	//OPERACIONES LOGICAS
	
	private static boolean hacerAnd(boolean b1, boolean b2) {
		return (b1 && b2);
	}

	private static boolean hacerOr(boolean b1, boolean b2) {
		return (b1 || b2);
	}
	
	private static boolean hacerNot(boolean b1) {
		return (!b1);
	}
	
	private static boolean hacerXor(boolean b1, boolean b2) {
		return (b1 ^ b2);
	}
	
	private static boolean hacerNand(boolean b1, boolean b2) {
		return (!b1 && !b2);
	}

	private static boolean hacerNor(boolean b1, boolean b2) {
		return (!b1 || !b2);
	}
	
}
