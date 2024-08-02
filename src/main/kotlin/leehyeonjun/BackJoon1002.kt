package leehyeonjun

import java.io.*
import java.util.*

// https://www.acmicpc.net/problem/1002
class BackJoon1002 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
        val token = StringTokenizer(readLine())
        println(Integer.parseInt(token.nextToken()) * Integer.parseInt(token.nextToken()))
    }
}