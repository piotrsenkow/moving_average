import scala.collection.mutable.{ArrayBuffer, Queue}
import org.scalatest.FunSuite

class TestSuite extends FunSuite {

  test("Simulation of turning args of window sizes to ints and quicksort"){

    val args = Array("1","14","24","10")
    val window_sizes= args.map(_.toInt) //loop over these, inner loop     Array
    scala.util.Sorting.quickSort(window_sizes)
    assert(window_sizes.deep === Array(1,10,14,24).deep)
  }

  test("Max value calculation"){
    val testarray = Array(1,23,15,262,124)
    val MaxVal= testarray.max
    assert(MaxVal===262)
  }

  test("Algo @ initial iteration ") {
    val queue = new scala.collection.mutable.Queue[Int] //queue as data structure to hold "window size" amount of numbers
    val input= Iterator(1,2,3,4,5)
    val windows = Array(1,3)
    val iterator = Iterator.from(1)
    val maxwin = windows.max

    input.hasNext
      val ToBeOutputted = ArrayBuffer[Any]()
      val counter = iterator.next()
      val number = input.next()
      queue.enqueue(number)
      ToBeOutputted.append(number)
      ToBeOutputted.append(counter)

      for (elem <- windows) {
        if(elem<=queue.size){
          ToBeOutputted.append((queue.takeRight(elem).min).toFloat)
          ToBeOutputted.append((queue.takeRight(elem).sum)/elem.toFloat)
          ToBeOutputted.append((queue.takeRight(elem).max).toFloat)
        }
        else{
          ToBeOutputted.append("?")
          ToBeOutputted.append("?")
          ToBeOutputted.append("?")
        }
      }

      if(queue.size>=maxwin){
        queue.dequeue()
      }
  assert(ToBeOutputted === ArrayBuffer(1,1,1.0,1.0,1.0,"?","?","?"))
    }

test ("Algo deep in iterations")
  {
    val queue = Queue(1,2,3,4,5,6,7,8,9,10)  //queue as data structure to hold "window size" amount of numbers
    val input= Iterator(11,12,13,14)
    val windows = Array(1,10)
    val iterator = Iterator.from(11)
    val maxwin = windows.max

    input.hasNext
    val ToBeOutputted = ArrayBuffer[Any]()
    val counter = iterator.next()
    val number = input.next()
    queue.enqueue(number)
    ToBeOutputted.append(number)
    ToBeOutputted.append(counter)

    for (elem <- windows) {
      if(elem<=queue.size){
        ToBeOutputted.append((queue.takeRight(elem).min).toFloat)
        ToBeOutputted.append((queue.takeRight(elem).sum)/elem.toFloat)
        ToBeOutputted.append((queue.takeRight(elem).max).toFloat)
      }
      else{
        ToBeOutputted.append("?")
        ToBeOutputted.append("?")
        ToBeOutputted.append("?")
      }
    }

    if(queue.size>=maxwin){
      queue.dequeue()
    }
    assert(ToBeOutputted === ArrayBuffer(11,11,11.0,11.0,11.0,2.0,6.5,11.0))
  }



}
