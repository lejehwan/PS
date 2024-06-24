import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = StringTokenizer(readLine())
    var sum = 0L
    while (input.hasMoreTokens()) sum += input.nextToken().toLong()
    println(sum)
}