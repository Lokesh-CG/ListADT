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
        linkedList.insertAtFirst(Node(5))
        linkedList.insertAtLast(Node(10))
        Log.d(TAG, "Size of the list: ${linkedList.size}")
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
