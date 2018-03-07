//yes 1 10 | head -1| scala MovingAvg.scala
//for i in {1..20}; do echo $i; done | sbt "run 1 10"
import scala.collection.mutable.ArrayBuffer


trait MovingAvg extends Task with Output[(ArrayBuffer[Any])]
{
  def run(input: Iterator[Int],windows: Array[Int],max: Int) = {

    val queue = new scala.collection.mutable.Queue[Int] //queue as data structure to hold "window size" amount of numbers
    val iterator = Iterator.from(1)

    while(input.hasNext){
      val ToBeOutputted = ArrayBuffer[Any]()
      val counter = iterator.next()
      val number = input.next()
      queue.enqueue(number)
      ToBeOutputted.append("%s".format(number))
      ToBeOutputted.append("%s".format(counter))

      for (elem <- windows) {
        if(elem<=queue.size){
          ToBeOutputted.append("%s".format(queue.takeRight(elem).min).toFloat)
          ToBeOutputted.append("%s".format((queue.takeRight(elem).sum)/elem.toFloat))
          ToBeOutputted.append("%s".format(queue.takeRight(elem).max).toFloat)
        }
        else{
          ToBeOutputted.append("?")
          ToBeOutputted.append("?")
          ToBeOutputted.append("?")
        }
      }

      if(queue.size>=max){
        queue.dequeue()
      }

      doOutput(ToBeOutputted)
      println()
    }
  }
}

object Averager extends Main[(ArrayBuffer[Any])] with MovingAvg


trait Output[Result] {
  def doOutput(result: Result): Unit
}

/** Provides a reusable output observer tied to println/stdout. */
trait OutputToStdOut[Result] extends Output[Result] {
  override def doOutput(result: Result) = println(result)
}

/** Defines a dependency (plug-in contract) on a run method that processes an input stream. */
trait Task {
  def run(input: Iterator[Int],windows: Array[Int],max: Int): Unit
}

/**
  * Provides a reusable main task tied to stdin and stdout.
  * Depends on a suitable run method.
  */
trait Main[Result] extends Task with OutputToStdOut[Result] {

  def main(args: Array[String]): Unit = {

    val lines = scala.io.Source.stdin.getLines
    val input = lines.flatMap(_.split("\\W+").map(_.toInt))


    val window_sizes= args.map(_.toInt) //loop over these, inner loop     Array
    scala.util.Sorting.quickSort(window_sizes)
    val max_window = window_sizes.max

    run(input,window_sizes,max_window)
  }
}

