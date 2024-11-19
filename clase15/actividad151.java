package clase15;

public class actividad151 {
/*
1) El Problema del Viajante (TSP, por sus siglas en inglés) es un problema clásico de optimización que se enmarca dentro de la teoría de grafos y la computación. La premisa es simple:

"Dado un conjunto de ciudades y la distancia entre cada par de ciudades, se busca encontrar la ruta más corta que permita visitar todas las ciudades exactamente una vez y regresar a la ciudad de origen."
Complejidad del Problema

𝑁
N es eñ numero de ciudades, el número de rutas posibles es: (n-1)!/2

2) (15-1)!/2=43,589,145,600 rutas posibles.

3)
Algoritmo del vecino más cercano
este método selecciona la ciudad más cercana que aún no haya sido visitada comienza en una ciudad y va construyendo la ruta paso a paso eligiendo siempre la ciudad más próxima no visitada hasta que todas las ciudades hayan sido visitadas
es rápido y fácil de implementar pero no siempre garantiza la solución óptima

Inserción más cercana
a partir de una ruta parcial inserta la ciudad no visitada que está más cerca de las ciudades en la ruta actual minimizando la distancia total este método trata de construir una ruta completa eligiendo la mejor opción en cada paso

Inserción más lejana
similar a la inserción más cercana pero selecciona la ciudad más lejana no visitada para insertarla en la ruta tratando de distribuir uniformemente las visitas para minimizar la distancia total

Algoritmo de 2-opt
este algoritmo mejora una ruta existente intercambiando dos aristas en la ruta para reducir la distancia total realiza este proceso repetidamente hasta que no se puedan realizar más mejoras
es un método de refinamiento que puede usarse en combinación con otros algoritmos para obtener mejores resultados

Algoritmo de 3-opt
similar al 2-opt pero intercambia tres aristas en lugar de dos lo que permite encontrar mejores soluciones en algunos casos a costa de un mayor tiempo de cálculo

*/
}
