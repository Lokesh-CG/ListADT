package com.dsa.listadt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dsa.listadt.adt.SinglyLinkedList
import com.dsa.listadt.adt.SinglyLinkedList.Node

private val TAG = MainActivity::class.simpleName!!

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Main Activity onCreate")
        val linkedList = SinglyLinkedList<Int>()
        linkedList.insertAtPosition(Node(7), 0)
        linkedList.insertFirst(Node(5))
        linkedList.insertLast(Node(10))
        linkedList.insertFirst(Node(2))
        linkedList.insertAtPosition(Node(1), 3)
        Log.d(TAG, "Size of the list: ${linkedList.size}")
        printList(linkedList)
    }

    private fun printList(linkedList: SinglyLinkedList<Int>) {
        var currentNode = linkedList.dataList
        while (currentNode != null) {
            Log.d(TAG, "@@@ Value: ${currentNode.data}")
            currentNode = currentNode.next
        }
    }

/*    private fun hanoi(n: Int, fromPeg: Char, auxPeg: Char, toPeg: Char) {
        if (n == 1) {
            Log.d("@@@", "Move disk 1 from $fromPeg to $toPeg")
            return
        } else {
            hanoi(n -1, fromPeg, toPeg, auxPeg)
            Log.d("@@@", "Move disk $n from $fromPeg to $toPeg")
            hanoi(n - 1, auxPeg, fromPeg, toPeg)
        }
    }*/
}
