package leehyeonjun

import java.io.*
import java.util.*

// https://www.acmicpc.net/problem/1000
class BackJoon1000 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
        val token = StringTokenizer(readLine())
        println(Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken()))
    }
}