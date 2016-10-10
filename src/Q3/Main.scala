package Q3

/**
  * Created by januslin on 9/10/2016.
  *
  * Q2 - Matrix Product
  *
  * You are given a N-by-M matrix A and a M-by-K matrix B.
  * Write a program that finds and prints the product AB.
  * For details on matrix multiplication, refer to the following: https://en.wikipedia.org/wiki/Matrix_multiplication#Matrix_product_.28two_matrices.29
  *
  */

object Main {
  def main(args: Array[String]): Unit = {
    val nmk = io.StdIn.readLine().split(" ")
    val (n, m, k) = (nmk(0).toInt, nmk(1).toInt, nmk(2).toInt)

    var matrix1:Array[Array[Int]] = Array.ofDim[Int](n, m)
    var matrix2:Array[Array[Int]] = Array.ofDim[Int](m, k)

    Map(matrix1 -> Array(n, m), matrix2 -> Array(m, k)).foreach(t=>{
      for (x<- 0 until t._2(0)){
        val temp = io.StdIn.readLine().split(" ")
        for (y<-0 until t._2(1)){
          t._1(x)(y) = temp(y).toInt
        }
      }
    })

    dotProduct(matrix1, matrix2).foreach(a=>{
      a.foreach(b=>{
        print(b+" ")
      })
      print("\n")
    })
  }

  def dotProduct(vector: Array[Array[Int]], matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val (newcolumnSize, newRowSize) = ({ if(matrix.length == vector(0).length) matrix.length else if (matrix.length < vector(0).length) matrix.length else vector(0).length}, { if(matrix(0).length == vector.length) matrix(0).length else if (matrix(0).length < vector.length) matrix(0).length else vector.length })
    var result:Array[Array[Int]] = Array.ofDim[Int](newRowSize, newcolumnSize)
    for (y<- 0 until newRowSize){
      for (x <- 0 until newcolumnSize){
        var colresult = 0
        for (i<- vector(y).indices){
          for (j <- matrix.indices){
            if (i == j)
                colresult += (vector(y)(i) * matrix(j)(x))
          }
        }
        result(y)(x) = colresult
      }
    }
    result
  }

}
