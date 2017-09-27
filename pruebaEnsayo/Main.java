package pruebas.pruebaEnsayo;

import java.util.Scanner;

import pruebas.pruebaEnsayo.tragos.*;

public class Main {
  
  private static Scanner scanner;

public static void main(String[] args) {
	  
	Integer opcion = null;
	Tragos seleccionado = null;
	
    scanner = new Scanner(System.in);
    // 2. interactuamos con el usuario
    System.out.println("Ingrese la cantidad de calorías que puede consumir: ");
    Double calorias = scanner.nextDouble();
    
   
    // 3. Preguntamos que tipo de alcohol le gusta más
    System.out.println("¿Qué trago prefieres tomar?");
    for (Tragos trago: Tragos.values()) {
      System.out.println(trago.ordinal() + " - " + trago.name().replace("_", " "));
    }
    
    while(true) {
    try {
    // 4. obtenemos la opcion del usuario
    opcion = scanner.nextInt();
    seleccionado = Tragos.values()[opcion];
    break;
    }catch(ArrayIndexOutOfBoundsException exception){
    	System.out.println("No ingresaste un numero de 1 a 7, intenta de nuevo: ");
    }
    }

    // 5. creamos una instancia de trago
    Trago trago = new AguaTonica();
    switch(seleccionado) {
      case AGUA_TONICA:
        break;
      case ESPUMANTE:
        trago = new Espumante();
        break;
      case VINO_TINTO:
        trago = new VinoTinto();
        break;
      case VINO_BLANCO:
        trago = new VinoBlanco();
        break;
      case CERVEZA:
        trago = new Cerveza();
        break;
      case PISCO:
        trago = new Pisco();
        break;
      case RON:
        trago = new Ron();
        break;
      case WHISKY:
        trago = new Whisky();
        break;
    }
    // 6. calculamos la cantidad de trago que puede consumir
    Double cantidad = trago.calculaCantidad(calorias);
    System.out.println("Puedes consumir " + cantidad.intValue() + " ml de " + seleccionado.name().replace("_", " ")); 

  

  
}
}
