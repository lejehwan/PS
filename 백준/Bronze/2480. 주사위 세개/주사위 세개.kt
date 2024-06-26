import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))){
    val (num1, num2, num3) = readLine().split(" ").map { it.toInt() }

    val result = when {
        num1 == num2 && num2 == num3 -> 10000 + num1 * 1000
        num1 == num2 || num1 == num3 -> 1000 + num1 * 100
        num2 == num3 -> 1000 + num2 * 100
        else -> maxOf(num1, num2, num3) * 100
    }

    println(result)
}