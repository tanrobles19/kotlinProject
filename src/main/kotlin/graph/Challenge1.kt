import graph.AdjacencyList
import graph.EdgeType
import graph.Vertex
import java.awt.GradientPaint

fun main() {

    val graph = AdjacencyList<String>()

    val A = graph.createVertex("A")
    val B = graph.createVertex("B")
    val C = graph.createVertex("C")
    val D = graph.createVertex("D")
    val E = graph.createVertex("E")

    graph.add(EdgeType.DIRECTED, A, B, null)
    graph.add(EdgeType.DIRECTED, A, C, null)
    graph.add(EdgeType.DIRECTED, A, D, null)
    graph.add(EdgeType.DIRECTED, A, E, null)

    graph.add(EdgeType.DIRECTED, B, D, null)
    graph.add(EdgeType.DIRECTED, B, C, null)

    graph.add(EdgeType.DIRECTED, C, E, null)

    graph.add(EdgeType.DIRECTED, D, E, null)

//    println(graph)

//    graph.edges(A).forEach {
//        println(it)
//    }

    println(sumDistanceBetweenVertices(graph, A, E))

}

//naive algorithm
fun sumDistanceBetweenVertices(graph: AdjacencyList<String>, source: Vertex<String>, destination: Vertex<String>): Int {

    var sum = 0

    graph.edges(source).forEach {
//        println("${it.source.data} to ${it.destination.data}")
        if(it.destination == destination){
            println(1)
            return sum + 1
        }else{
            sum += sumDistanceBetweenVertices(graph, it.destination, destination)
        }
    }

    return sum

}// end fun sumDistanceBetweenVertices()