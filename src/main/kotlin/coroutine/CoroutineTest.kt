import kotlinx.coroutines.*
import java.lang.Math.log
import java.net.URL

private const val BASE_URL = "http://kotlin-book.bignerdranch.com/2e"
private const val FLIGHT_ENDPOINT = "$BASE_URL/flight"

fun main() {

    parallelNetworkRequest()

//    sequentialNetworkRequest()

}

// async and await
fun parallelNetworkRequest() {

    runBlocking {
        println("parallel start")

        println("parallel: " + fetchFlight(FLIGHT_ENDPOINT))
    }

}


//Sequential Implementation
fun sequentialNetworkRequest() {

    println("1")

    runBlocking {

        println("Started")

        launch {
            // Sequential network request
            println("call flight")
            println("Flight Info" + fetchFlight(FLIGHT_ENDPOINT))

            println("call loyalty")
            println("Loyalty" + fetchFlight("http://kotlin-book.bignerdranch.com/2e/loyalty"))
        }

        println("End")

    }

    println("2")

}// end fun sequentialNetworkRequest()

fun unManagedThread() {
    GlobalScope.launch {
        println("I am GlobalCoroutine!")
    }

// you need to execute another task to show the GlobalScope
    (1..1000).forEach {
        println(it)
    }
}

suspend fun fetchFlight(url: String): String = coroutineScope {

    val flightResponse = async {
        println("call flight")
        withContext(Dispatchers.IO) {
            URL(url).readText()
        }
    }

    val loyaltyResponse = async {
        println("call loyalty")
        withContext(Dispatchers.IO) {
            URL("http://kotlin-book.bignerdranch.com/2e/loyalty").readText()
        }
    }

    println("await flight")
    val flightResponseText = flightResponse.await()
    println("await loyalty")
    val loyaltyResponseText = loyaltyResponse.await()

    println("RESPONSE READY")
    flightResponseText + loyaltyResponseText

}

