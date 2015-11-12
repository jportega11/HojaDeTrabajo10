//Universidad del Valle de Guatemala
//Algoritmos y Estructuras de Datos
//Edwin Coronado, 14148
//Guillermo de Leon, 14022
//Dan Alvarez, 14628
//Jose Pablo Ortega, 14565

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGraph {

	//Test para agregar vertices
	public void AddVertexTest() {
		Graph<String> prueba = new Graph<String>();
		Vertex<String> v = new Vertex<String>("Chiquimula","Chiquimula");

		if(prueba.addVertex(v) == false){ //verifica si se agregó el vértice
			fail("No se agregó el vertice");
		}
		if(prueba.getVertex(0) != v){ //verifica si se agregó el vértice CORRECTAMENTE
			fail("El vertice se agrego pero no correctamente");
		}
	}
	//Test para agregar aristas
	public void AddEdgeTest() {
		Graph<String> prueba = new Graph<String>();
		Vertex<String> v = new Vertex<String>("Chiquimula","Chiquimula");
		Vertex<String> b = new Vertex<String>("Peten","Peten");
		
		prueba.addVertex(v);
		prueba.addVertex(b);
		
		if(prueba.addEdge(v, b, 5) == false){ //verifica si se agregó el arista
			fail("El arista no se agrego");
		}
	}
	//Test para eliminar vertices
	public void RemoveVertexTest() {
		Graph<String> prueba = new Graph<String>();
		Vertex<String> v = new Vertex<String>("Chiquimula","Chiquimula");
		
		prueba.addVertex(v);
		
		prueba.removeVertex(v);
		
		if(prueba.findVertexByName("Chiquimula") != null){
			fail("Vertice no eliminado correctamente");
		}
	}
	//Test para eliminar aristas
	public void RemoveEdgeTest() { 
		Graph<String> prueba = new Graph<String>();
		Vertex<String> v = new Vertex<String>("Chiquimula","Chiquimula");
		Vertex<String> b = new Vertex<String>("Peten","Peten");
		
		prueba.addVertex(v);
		prueba.addVertex(b);
		
		prueba.addEdge(v, b, 5);
		
		if(prueba.removeEdge(v, b) == false){
			fail("Arista no eliminado correctamente");
		}
	}
}
