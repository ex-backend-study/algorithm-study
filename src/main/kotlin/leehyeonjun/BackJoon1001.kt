package leehyeonjun

import java.io.*
import java.util.*

// https://www.acmicpc.net/problem/1001
class BackJoon1001 {
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
        val token = StringTokenizer(readLine())
        println(Integer.parseInt(token.nextToken()) - Integer.parseInt(token.nextToken()))
    }
}