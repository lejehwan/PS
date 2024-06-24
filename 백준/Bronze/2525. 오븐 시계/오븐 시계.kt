import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val standard = 60
    val now = readLine().split(" ")
    val nowHour = now[0].toInt()
    val nowMin = now[1].toInt()
    val duration = readLine().toInt()

    val totalMin = nowHour * standard + nowMin + duration
    val resultMin = (totalMin) % standard
    val resultHour = totalMin / standard % 24

    println(
        sb.append(resultHour)
        .append(" ")
        .append(resultMin)
        .toString()
    )
}