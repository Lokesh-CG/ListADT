package com.dsa.listadt.adt

import android.util.Log
import java.util.*

private const val INVALID_POSITION = -1

/**
 * Singly LinkedList class used to hold list of nodes in which nodes have a reference to its next
 * node if exist. This can traversed only in forward direction.
 */
class SinglyLinkedList<E> {

    // Maintains current length/size of the linked list. # of nodes
    var size = 0
    var dataList: Node<E>? = null

    /**
     * Insert given inputNode as the head of the linked list.
     * @param inputNode inputNode to be inserted in linked list.
     */
    fun insertFirst(inputNode: Node<E>) {
        inputNode.next = dataList
        dataList = inputNode
        size++
    }

    /**
     * Insert given inputNode as last item of the linked list.
     * @param inputNode inputNode to be inserted in linked list.
     */
    fun insertLast(inputNode: Node<E>) {
        if (dataList == null) {
            dataList = inputNode
        }

        var currentNode = dataList!!
        while (currentNode.next != null) {
            currentNode = currentNode.next!!
        }
        currentNode.next = inputNode
        size++
    }

    /**
     * Insert given inputNode in the given position in the linked list.
     * @param inputNode inputNode to be inserted in linked list.
     * @param position Position in linked list where the given inputNode should be inserted.
     * @return Given inputNode insert status, false if given position is not in the range.
     */
    fun insertAtPosition(inputNode: Node<E>, position: Int): Boolean {
        return if (position in (INVALID_POSITION + 1)..size) {
            var counter = 0
            var currentNode = dataList
            while (currentNode != null && ++counter < position - 1) {
                currentNode = currentNode.next
            }

            if (currentNode != null) {
                inputNode.next = currentNode.next
                currentNode.next = inputNode
            } else {
                dataList = inputNode
            }
            size++
            true
        } else false
    }

    fun deleteFirst(): Boolean {
        return if (dataList == null) false
        else {
            val currentNode = dataList!!.next
            dataList = currentNode
            true
        }
    }

    fun deleteLast(): Boolean {

        return if (dataList == null) false
        else if (dataList!!.next == null) {
            dataList = null
            true
        }
        else {
            var currentNode = dataList
            while (currentNode!!.next!!.next != null) {
                currentNode = currentNode.next
            }
            currentNode.next = null
            true
        }
    }

    fun deleteGivenNode(node: Node<E>): Boolean {
        return if (dataList == null) false
        else {
            var currentNode = dataList
            while (currentNode!!.next != null) {
                currentNode = currentNode.next
                if (currentNode!!.data == node.data) {
                    return true
                }
            }
            false
        }
    }

    /**
     * This Checks if given node exist in the list.
     * @param node input node to check if it exist in the list.
     * @return true if given node exists in the list else false.
     */
    fun contains(node: Node<E>): Boolean {
        var currentNode = dataList
        while (currentNode != null) {
            if (currentNode.data != null && currentNode.data == node.data) {
                return true
            }
            currentNode = currentNode.next
        }
        return false
    }

    /**
     * Class to hold data of a node in a linked list.
     * @param data object which holds to data.
     * @param next pointer to next node.
     */
    class Node<E>(val data: E?, var next: Node<E>? = null)
}