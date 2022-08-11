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

    // Find the distance between 2 vertices.
//    println(graph.sumDistanceBetweenVertices(D, A))

    // Which mutual Vertices have A and B vertices?

    //Under the hood we have an adjacency list, it is a hash table with a vertex as a key and list as ArrayList of edges.
    graph.findMutualVertices(A, B)

}