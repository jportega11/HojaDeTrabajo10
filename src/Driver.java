import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Driver {

	public static void main(String[] args) {
		BufferedReader reader;
		String linea = "";
		int cantLineas = 0;
		int contador = 0;
		
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
			
			digrafo.addEdge(v1, v2, Integer.parseInt(parte[2]));
			
		}
		System.out.println(digrafo.getEdges());
		System.out.println(digrafo.toString());
	}

}
