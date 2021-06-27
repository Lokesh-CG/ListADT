package com.dsa.listadt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dsa.listadt.adt.DoublyLinkedList
import com.dsa.listadt.adt.SinglyLinkedList
import com.dsa.listadt.problems.SinglyListProblems

private val TAG = MainActivity::class.simpleName!!

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Main Activity onCreate")

        //LinkedList.flattenLinkedList()
        //SinglyListProblems.flattenLinkedList2()
        SinglyListProblems.mergeLinkedLists()

        //singlyLinkedListTests()
        //doublyLinkedListTests()
    }

    /**
     * Tower of hanoi problem
     */
/*    private fun hanoi(n: Int, fromPeg: Char, auxPeg: Char, toPeg: Char) {
        if (n == 1) {
            Log.d("@@@", "Move disk 1 from $fromPeg to $toPeg")
            return
        } else {
            hanoi(n - 1, fromPeg, toPeg, auxPeg)
            Log.d("@@@", "Move disk $n from $fromPeg to $toPeg")
            hanoi(n - 1, auxPeg, fromPeg, toPeg)
        }
    }*/

    private fun singlyLinkedListTests() {
        val linkedList = SinglyLinkedList<Int>()
        linkedList.insertFirst(5)
        linkedList.insertAtPosition(3, 0)
        linkedList.insertLast(7)
        linkedList.insertFirst(2)
        linkedList.insertAtPosition(6, 3)
        linkedList.insertAtPosition(12, 10)
        linkedList.insertAtPosition(4, 2)
        linkedList.insertFirst(1)
        linkedList.insertLast(8)

        Log.d(TAG, "Size of the list after add: ${linkedList.size}")
        linkedList.printList()

        linkedList.deleteFirst()
        // this should return false as we don't have node with 2 value
        Log.d(TAG, "Deleted value ${linkedList.deleteGivenNode(2)}")
        // Node with value 7 is present in the list so it should return true
        Log.d(TAG, "Deleted value2 ${linkedList.deleteGivenNode(7)}")
        linkedList.deleteLast()
        linkedList.deleteNodeAtGivenPosition(1)

        Log.d(TAG, "Node with value 5 contains in list: ${linkedList.contains(5)}")
        Log.d(TAG, "Node with value 12 contains in list: ${linkedList.contains(12)}")
        Log.d(TAG, "Size of the list after delete: ${linkedList.size}")
        linkedList.printList()
    }

    private fun doublyLinkedListTests() {
        val doublyList = DoublyLinkedList<Int>()
        doublyList.insertFirst(5)
        doublyList.insertAtPosition(3, 0)
        doublyList.insertLast(7)
        doublyList.insertFirst(2)
        doublyList.insertAtPosition(6, 3)
        doublyList.insertAtPosition(12, 10)
        doublyList.insertAtPosition(4, 2)
        doublyList.insertFirst(1)
        doublyList.insertLast(8)

        Log.d(TAG, "Size of the list after add: ${doublyList.getSize()}")
        doublyList.printList()
        Log.d(TAG, "Print in reverse order")
        doublyList.printListInReverse()

        doublyList.deleteFirst()
        doublyList.deleteLast()
        doublyList.deleteNodeWithData(4)
        doublyList.deleteNodeAtPosition(10)
        doublyList.deleteNodeAtPosition(2)
        doublyList.deleteNodeWithData(55)
        doublyList.deleteLast()

        Log.d(TAG, "Size of the list after add: ${doublyList.getSize()}")
        doublyList.printList()
        Log.d(TAG, "Print in reverse order")
        doublyList.printListInReverse()
    }
}
