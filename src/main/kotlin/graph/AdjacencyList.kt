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
    }// end fun toString

    fun sumDistanceBetweenVertices(source: Vertex<T>, destination: Vertex<T>): Int {

        var sum = 0

        edges(source).forEach {
            if(it.destination == destination)
                return sum + 1
            else
                sum += sumDistanceBetweenVertices(it.destination, destination)
        }

        return sum

    }// end fun sumDistanceBetweenVertices()

    fun findMutualVertices(vertex1: Vertex<T>, vertex2: Vertex<T>) {

        // naive solution
//        var finalList : ArrayList<Edge<T>> = arrayListOf()

        val finalList : HashMap<String, Vertex<T>> = hashMapOf()
        var index = 0

        edges(vertex1).forEach {
            finalList[it.destination.data.toString()] = it.destination
            index++
        }

        edges(vertex2).forEach { edge2 ->
            index++
            //Big O(1)
            finalList.containsKey(edge2.destination.data.toString()).let {
                println(edge2)
            }

        }



// naive solution
//        edges(vertex1).forEach {edge1 ->
//            edges(vertex2).forEach {edge2 ->
//                index++
//                if(edge1.destination == edge2.destination) finalList.add(edge1)
//            }
//        }
        println(index)
//        println(finalList)

    }// end fun findMutualVertices()

}