package Q1

/**
  * Created by januslin on 9/10/2016.
  *
  * Q1 - Tabereru
  *
  * The Japanese phrase 'taberareru' translates to "can eat." Some people omit 'ra' and say 'tabereru' instead, because 'taberareru' is somewhat difficult to pronounce. Your task is to write a program that behaves similarly.
  * Your program should take a string consisting of lowercase alphabets as the input, then remove all occurrences of 'ra' from it and print the resulting string.
  * After removing occurrences of 'ra', there may be new occurrences of 'ra', but they should not be removed.
  * For example, suppose that the input is 'rrraaa'. By removing the third and fourth characters, it will become 'rraa'. Print this
  * string without further removal of 'ra'.
  */

object Main {
  def main(args: Array[String]): Unit = {
    val s = io.StdIn.readLine().trim
    var isRA = false
    var ns = ""

    if (s.length < 1 || s.length > 100){
      println(s)
      return
    }

    for (x <- 0 until s.length){
      if (!isRA){
        if (!(x+1 < s.length) || !(s(x) == 'r' && s(x+1) == 'a'))
          ns = ns + s(x)
        else
          isRA = true
      }else
        isRA = false
    }
    println(ns)
  }

}
