"""
Universidad del Valle de Guatemala
Algoritmos y Estructuras de Datos, Sección 30
Guillermo Javier de León Archila, 14022
Edwin Fernando Coronado Roche, 14148
José Pablo Ortega Grajeda, 14565
Dan Isai Alvarez Ruano, 14628
"""

##modulo networkX a utilizar
import networkx as nx

##se crea el digrafo
guategrafo = nx.DiGraph()

opcion = 0 ##variable para leer opciones del menú

##se lee el archivo y se ingresan los datos al digrafo
file = open("guategrafo.txt","r")
lineas = []
for linea in file:
    lineas.append(linea)

for linea in lineas:
    parte = linea.split()
    guategrafo.add_edge(parte[0], parte[1], weight= int(parte[2]))
    

##se muestra en pantalla la distancia y predecesores con floyd y la lista de adyacencia
predecesor, distancia = nx.floyd_warshall_predecessor_and_distance(guategrafo)
print "Distancia más corta: ", distancia
print "\nPredecesores: ", predecesor
print "\nLista de adyacencia",guategrafo.adj

##menu de opciones
while opcion != "4":
    
    opcion = raw_input("\n1. Obtener ruta más corta entre dos ciudades\n2. Obtener centro del grafo\n3. Modificar información\n4. Salir\n\tOpcion: ")

    ##opción 1: muestra la ruda más corta entre dos ciudades en el grafo
    if opcion == "1":
        desde = raw_input("Ingrese origen: ")
        hasta = raw_input("Ingrese destino: ")
        try:
            print"Ruta: ",nx.shortest_path(guategrafo, desde, hasta)
            print"Nodos recorridos: ",nx.shortest_path_length(guategrafo, desde, hasta)

        except:
            print("No existe ruta entre esas ciudades")

    ##opción 2: muestra el centro del grafo si es posible calcularlo
    elif opcion == "2":
        try:
            print(nx.center(guategrafo))
            
        except:
            print "No se puede calcular el centro porque hay ciudades incomunicadas"

    ##opcion 3: permite eliminar o agregar comunicación
    elif opcion == "3":
        opcion1 = raw_input("a. Eliminar comunicación\nb. Agregar comunicación\n\tOpcion: ")

        ##opcion a: permite eliminar comunicación entre vértices si existe
        if opcion1 == "a":
            desde = raw_input("Ingrese origen: ")
            hasta = raw_input("Ingrese destino: ")
            if guategrafo.has_edge(desde, hasta) == True:
                guategrafo.remove_edge(desde, hasta)
                print("Comunicación eliminada")
            else:
                print("No existe ruta entre esas ciudades")

        ##opcion b: permite agregar comunicación entre vértices (incluidos o no previamente en el digrafo)
        elif opcion1 == "b":
            desde = raw_input("Ingrese origen: ")
            hasta = raw_input("Ingrese destino: ")
            peso = raw_input("Ingrese distancia: ")
            guategrafo.add_edge(desde, hasta, weight=int(peso))
            print("Comunicación agregada")

        ##opción inválida
        else:
            print("Opción inválida")

        ##muestra en pantalla la información del grafo actualizado
        predecesor, distancia = nx.floyd_warshall_predecessor_and_distance(guategrafo)
        print "Distancia más corta: ", distancia
        print "\nPredecesores: ", predecesor
        print "\nLista de adyacencia",guategrafo.adj

    ##opción 4: sale del programa
    elif opcion == "4":
        print("Hasta pronto")

    ##opción inválida
    else:
        print("Opcion inválida")
