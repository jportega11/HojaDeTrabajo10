//Universidad del Valle de Guatemala
//Algoritmos y Estructuras de Datos
//Edwin Coronado, 14148
//Guillermo de Leon, 14022
//Dan Alvarez, 14628
//Jose Pablo Ortega, 14565

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		BufferedReader reader;
		Scanner scan = new Scanner(System.in);
		String linea = "", opcionMenu = "";
		int cantLineas = 0;
		int contador = 0;
		boolean menu = true;
		
		try {//revisa la cantidad de líneas que hay en el archivo
			reader = new BufferedReader(new FileReader("guategrafo.txt"));
			while (reader.readLine() != null) cantLineas++;
			reader.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		String[] lineas = new String [cantLineas];//se instancia un arreglo donde se guardará cada línea del archivo
		try {
			reader = new BufferedReader(new FileReader("guategrafo.txt"));
			while((linea = reader.readLine()) != null)
			{
			    lineas[contador] = linea;//se guarda cada línea del archivo
			    contador++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graph<String> digrafo = new Graph<String>();
		String[] parte;
		for(int i = 0; i < cantLineas; i++){//se revisa cada línea del archivo
			parte = lineas[i].split(" ");//se separa la frase donde se encuentre el espacio
			Vertex<String> v1 = new Vertex<String>(parte[0],parte[0]);
			Vertex<String> v2 = new Vertex<String>(parte[1],parte[1]);
			
			digrafo.addVertex(v1);
			digrafo.addVertex(v2);
			
			v1 = digrafo.findVertexByName(parte[0]);
			v2 = digrafo.findVertexByName(parte[1]);
			
			digrafo.addEdge(v1,v2,Integer.parseInt(parte[2]));
		}
		
		while(menu == true){
			System.out.println("1. Obtener ruta mas corta");
			System.out.println("2. Obtener centro del grafo");
			System.out.println("3. Modificar informacion");
			System.out.println("4. Salir");
			opcionMenu = scan.nextLine();
			
			if(opcionMenu.equals("1")){
				
			}
			else if(opcionMenu.equals("2")){
				
			}
			else if(opcionMenu.equals("3")){
				String origen = "", destino = "";
				int peso = 0;
				Vertex<String> origenV, destinoV;
				
				System.out.println("\n1. Eliminar Comunicacion");
				System.out.println("2. Agregar Comunicacion");
				opcionMenu = scan.nextLine();
				
				if(opcionMenu.equals("1")){
					System.out.print("\nIngrese el origen: ");
					origen = scan.nextLine();
					System.out.print("Ingrese el destino: ");
					destino = scan.nextLine();
					
					origenV = digrafo.findVertexByName(origen);
					destinoV = digrafo.findVertexByName(destino);
					
					if(digrafo.removeEdge(origenV, destinoV) == false){
						System.out.println("\nALERTA: El o los vertices ingresados no existen en el grafo, o los vertices ingresados no tienen conexion");
					}
				}
				else if(opcionMenu.equals("2")){
					System.out.print("\nIngrese el origen: ");
					origen = scan.nextLine();
					System.out.print("Ingrese el destino: ");
					destino = scan.nextLine();
					System.out.print("Ingrese el peso: ");
					peso = scan.nextInt();
					scan.nextLine();
					
					origenV = digrafo.findVertexByName(origen);
					destinoV = digrafo.findVertexByName(destino);
					
					if(digrafo.addEdge(origenV, destinoV, peso) == false){
						System.out.println("\nALERTA: El o los vertices ingresados no existen en el grafo, o el arista que intenta ingresar ya existe");
					}
				}
				else{
					System.out.println("Ha ingresado una opcion invalida");
				}
			}
			else if(opcionMenu.equals("4")){
				menu = false;
			}
			else{
				System.out.println("Ha ingresado una opcion invalida");
			}
			
			System.out.println("\nAristas en formato [origen, destino, peso]");
			System.out.println("------------------------------------------------");
			System.out.println(digrafo.getEdges());
			System.out.println("------------------------------------------------");
			System.out.println("\nVertices");
			System.out.println("------------------------------------------------");
			for (int i = 0; i < digrafo.size(); i++){
				System.out.println(digrafo.getVertex(i));
			}
			System.out.println("------------------------------------------------\n");
		}
	}
}
