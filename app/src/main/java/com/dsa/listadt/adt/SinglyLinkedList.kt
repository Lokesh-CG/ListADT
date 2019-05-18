package com.dsa.listadt.adt

import android.util.Log

// This indicate start index of the node
private const val FIRST_POSITION = 0
private val TAG = SinglyLinkedList::class.simpleName!!

/**
 * Singly LinkedList class used to hold list of nodes in which nodes have a reference to its next
 * node if exist. This can traversed only in forward direction.
 */
class SinglyLinkedList<E> {

    // Maintains current length/size of the linked list. # of nodes
    var size = 0
    var firstNode: Node<E>? = null

    /**
     * Insert given data as the head of the linked list.
     * @param data input data to be inserted in linked list as first item.
     */
    fun insertFirst(data: E) {
        val node = Node(data, firstNode)
        firstNode = node
        size++
    }

    /**
     * Insert given data as last item of the linked list.
     * @param data input data to be inserted in linked list as last item.
     */
    fun insertLast(data: E) {

        val currentNode = Node(data)
        when {
            firstNode == null -> firstNode = currentNode
            firstNode!!.next == null -> firstNode!!.next = currentNode
            else -> {
                val lastNode = getNode(size)
                lastNode.next = currentNode
            }
        }
        size++
    }

    /**
     * Insert given data in the given position in the linked list.
     * @param data input data to be inserted in linked list at given position.
     * @param position Position in linked list where the given data should be inserted.
     * @return Given data insert status, false if given position is not in the range.
     */
    fun insertAtPosition(data: E, position: Int): Boolean {
        return if (position in FIRST_POSITION..size) {
            val currentNode = Node(data)
            when (position) {
                0 -> insertFirst(data)
                size -> insertLast(data)
                else -> {
                    // get node at one position b4 the given position to insert given input data
                    val nodeBefore = getNode(position)
                    currentNode.next = nodeBefore.next
                    nodeBefore.next = currentNode
                    size++
                }
            }
            true
        } else {
            Log.e(TAG, "Invalid position: $position")
            false
        }
    }

    /**
     * Remove first element or head of the list.
     * @return true if list contains at least one node and got deleted else false.
     */
    fun deleteFirst(): Boolean {
        return if (firstNode == null) {
            Log.e(TAG, "List is empty, Can't delete first item")
            false
        }
        else {
            val currentNode = firstNode!!.next
            firstNode = currentNode
            size--
            true
        }
    }

    /**
     * Remove last element from the list
     * @return true if list contains at least one node and got deleted else false.
     */
    fun deleteLast(): Boolean {

        return when {
            firstNode == null -> {
                Log.e(TAG, "List is empty, Can't delete last item")
                false
            }
            firstNode!!.next == null -> {
                firstNode = null
                size--
                true
            }
            else -> {
                val nodeBefore = getNode(size - 1)
                nodeBefore.next = null
                size--
                true
            }
        }
    }

    /**
     * Delete given data from the list.
     * @param data input data to delete a node with same data in the list.
     * @return status if given data is present and deleted from the list.
     */
    fun deleteGivenNode(data: E): Boolean {
        return when {
            firstNode == null -> {
                Log.e(TAG, "List is empty, Can't delete given item")
                false
            }
            firstNode!!.data == data -> {
                firstNode = firstNode!!.next
                size--
                true
            } else -> {
                var currentNode = firstNode
                while (currentNode!!.next != null) {
                    if (currentNode.next!!.data == data) {
                        currentNode.next = currentNode.next!!.next
                        size--
                        return true
                    }
                    currentNode = currentNode.next
                }
                false
            }
        }
    }

    /**
     * Delete a node based on given position if available in the list.
     * @param position position of item to be deleted in the list
     * @return true if given position is in the range and got deleted else false.
     */
    fun deleteNodeAtGivenPosition(position: Int): Boolean {
        return if (position in FIRST_POSITION until size) {
            when (position) {
                0 -> deleteFirst()
                size -> deleteLast()
                else -> {
                    val nodeBefore = getNode(position - 1)
                    val deleteNode = nodeBefore.next
                    nodeBefore.next = deleteNode!!.next
                    size--
                }
            }
            true
        } else {
            Log.e(TAG, "Invalid position: $position")
            false
        }
    }

    /**
     * This Checks if given data exist in the list.
     * @param data input data to check if it exist in the list.
     * @return true if given data exists in the list else false.
     */
    fun contains(data: E): Boolean {
        var currentNode = firstNode
        while (currentNode != null) {
            if (currentNode.data != null && currentNode.data == data) {
                return true
            }
            currentNode = currentNode.next
        }
        return false
    }

    /**
     * Returns a node from list based on the given position.
     * @param position position of the node which need to be returned from the list
     * @return node at the given position.
     */
    private fun getNode(position: Int): Node<E> {
        // This function doesn't do any sanity checks and assumes method which call will do all
        // based on the requirements
        var currentNode = firstNode
        for (i in 1 until position){
            currentNode = currentNode!!.next
        }
        return currentNode!!
    }

    /**
     * Class to hold data of a node in a linked list.
     * @param data object which holds to data.
     * @param next pointer to next node.
     */
    class Node<E>(val data: E?, var next: Node<E>? = null)
}