package graph

class AdjacencyList<T: Any> : Graph<T> {

    private val adjacencyList : HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencyList.count(), data)
        adjacencyList[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencyList[source]?.add(edge)
    }

    override fun addUnDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when(edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUnDirectedEdge(source, destination, weight)
        }
    }

    override fun edges(source: Vertex<T>) = adjacencyList[source]?: arrayListOf()

    // Retrieving the weight of an edge
    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull{ it.destination == destination }?.weight
    }

    override fun toString(): String {
        return buildString {
            adjacencyList.forEach{vertex, edge ->
                val edgeString = edge.joinToString { it.destination.data.toString() }
                append("${vertex.data} --> [ $edgeString ] \n")

            }
        }
    }

}