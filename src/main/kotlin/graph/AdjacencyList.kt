package graph

class AdjacencyList<T: Any> : Graph<T> {

    private val adjacencyList : HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencyList.count(), data)
        adjacencyList[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        TODO("Not yet implemented")
    }

    override fun addUnDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        TODO("Not yet implemented")
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        TODO("Not yet implemented")
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        TODO("Not yet implemented")
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        TODO("Not yet implemented")
    }

}