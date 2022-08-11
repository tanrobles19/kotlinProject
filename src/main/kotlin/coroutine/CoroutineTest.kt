import java.net.URL

private const val BASE_URL = "http://kotlin-book.bignerdranch.com/2e"
private const val FLIGHT_ENDPOINT = "$BASE_URL/flight"

fun main() {

    println("Start fetching process...")
    println(fetchFlight())
    println("End fetching process...")

}

fun fetchFlight(): String = URL(FLIGHT_ENDPOINT).readText()