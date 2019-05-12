package com.dsa.listadt.adt

/**
 * Singly LinkedList class used to hold list of nodes in which nodes have a reference to its next
 * node if exist. This can traversed only in forward direction.
 */
class SinglyLinkedList<E> {

    // Maintains current length/size of the linked list. # of nodes
    var size = 0
    private var mDataList: Node<E>? = null

    /**
     * Insert given node as the head of the linked list.
     * @param node node to be inserted in linked list.
     */
    fun insertAtFirst(node: Node<E>) {
        node.next = mDataList
        mDataList = node
        size++
    }

    /**
     * Insert given node as last item of the linked list.
     * @param node node to be inserted in linked list.
     */
    fun insertAtLast(node: Node<E>) {
        if (mDataList == null) {
            mDataList = node
        }

        var currentNode = mDataList!!
        while (currentNode.next != null) {
            currentNode = currentNode.next!!
        }
        currentNode.next = node
        size++
    }

    /**
     * Insert given node in the given position in the linked list.
     * @param node node to be inserted in linked list.
     * @return Given node insert status, false if given position is not in the range.
     */
    fun insertWithPosition(node: Node<E>, position: Int): Boolean {

        return false
    }

    class Node<E>(data: E?) {
        var next: Node<E>? = null
    }
}