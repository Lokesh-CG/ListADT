package com.dsa.listadt.adt

import android.util.Log

private const val FIRST_NODE_POSITION = 0
private val TAG = DoublyLinkedList::class.simpleName!!

/**
 * This holds list of nodes and each node contains pointer to next and previous nodes.
 */
class DoublyLinkedList<E> {

    // size starts with 1
    private var size = 0
    private var firstNode: Node<E>? = null

    /**
     * Returns number of items in this list.
     */
    fun getSize() = size

    /**
     * Insert given node data as first node(head) of the list.
     * @param data Input data of the node that need to be added as first item in the list.
     */
    fun insertFirst(data: E) {
        firstNode = if (firstNode == null) {
            Node(data)
        } else {
            val currentNode = Node(data, null, firstNode)
            firstNode!!.prev = currentNode
            currentNode
        }
        size++
    }

    /**
     * Insert given node data as last item(tail) of the list.
     * @param data Input data of the node that need to be inserted as last item.
     */
    fun insertLast(data: E) {
        when {
            firstNode == null -> firstNode = Node(data)
            firstNode!!.next == null -> {
                val currentNode = Node(data, prev = firstNode)
                currentNode.prev = firstNode
                firstNode!!.next = currentNode
            }
            else -> {
                val nodeBefore = getNode(size - 1)
                val nodeNext = nodeBefore.next
                val currentNode = Node(data, nodeBefore, nodeNext)
                currentNode.prev = nodeBefore
                nodeBefore.next = currentNode
            }
        }
        size++
    }

    /**
     * Insert given node data as a node at given position.
     * @param data Input node data to insert in list.
     * @param position 0 based position at which given nodes need to be inserted.
     * @return true if position is in range else false.
     */
    fun insertAtPosition(data: E, position: Int): Boolean {
        return if (position in FIRST_NODE_POSITION..size) {
            when (position) {
                0 -> insertFirst(data)
                size -> insertLast(data)
                else -> {
                    val nodeBefore = getNode(position - 1)
                    val nodeNext = nodeBefore.next
                    val currentNode = Node(data, nodeBefore, nodeNext)
                    currentNode.prev = nodeBefore
                    nodeBefore.next = currentNode
                    size++
                }
            }
            true
        } else {
            Log.e(TAG, "Given position out of size range")
            false
        }
    }

    /**
     * Delete first node of the list.
     * @return true if list contains at least one node and got deleted else false.
     */
    fun deleteFirst(): Boolean {
        return if (firstNode == null) {
            Log.e(TAG, "List is empty")
            false
        } else {
            firstNode = firstNode?.next
            firstNode?.prev = null
            size--
            true
        }
    }

    /**
     * Delete last node of the list.
     * @return true if list contains at least one node and got deleted else false.
     */
    fun deleteLast(): Boolean {
        return when {
            firstNode == null -> {
                Log.e(TAG, "List is empty")
                false
            }
            firstNode?.next == null -> {
                firstNode = null
                size--
                true
            }
            else -> {
                // size is 1 based and position is 0 based so to get last but one we need to set
                // position as (size - 2)
                val nodeBefore = getNode(size - 2)
                nodeBefore.next = null
                size--
                true
            }
        }
    }

    /**
     * Delete node which has given data.
     * @param data Input data to delete the node which has same
     * @return true if node exist with given data and got deleted else false.
     */
    fun deleteNodeWithData(data: E): Boolean {
        return when {
            firstNode == null -> {
                Log.e(TAG, "List is empty")
                false
            }
            firstNode?.data == data -> {
                deleteFirst()
                true
            }
            else -> {
                var currentNode = firstNode!!
                while (currentNode.next != null) {
                    if (currentNode.next!!.data == data) {
                        val nodeNext = currentNode.next!!
                        nodeNext.next?.prev = currentNode
                        currentNode.next = nodeNext.next
                        size--
                        return true
                    }
                    currentNode = currentNode.next!!
                }
                false
            }
        }
    }

    /**
     * Delete node from the list based on the given position.
     * @param position 0 based index position to access items from the list.
     * @return true if node exist at the given position and got deleted else false.
     */
    fun deleteNodeAtPosition(position: Int): Boolean {
        return if (position !in FIRST_NODE_POSITION until size) {
            Log.e(TAG, "Given position is out of the size range")
            false
        } else {
            when (position) {
                0 -> deleteFirst()
                size - 1 -> deleteLast()
                else -> {
                    val nodeBefore = getNode(position - 1)
                    val deleteNode = nodeBefore.next
                    deleteNode!!.next?.prev = nodeBefore
                    nodeBefore.next = deleteNode.next
                    size--
                }
            }
            true
        }
    }

    /**
     * Print data of all nodes data in the list.
     */
    fun printList() {
        var currentNode = firstNode
        while (currentNode != null) {
            Log.d(TAG, "Value: ${currentNode.data}")
            currentNode = currentNode.next
        }
    }

    /**
     * Returns node at the given position for the list.
     * @param position position of the node in the list that need to returned.
     * @return Node from the list at the given position.
     */
    private fun getNode(position: Int): Node<E> {
        var currentNode = firstNode!!
        for (i in FIRST_NODE_POSITION until position) {
            currentNode = currentNode.next!!
        }
        return currentNode
    }

    /**
     * Class to hold data and pointers to next and previous nodes.
     */
    class Node<E>(val data: E, var prev: Node<E>? = null, var next: Node<E>? = null)
}