package com.dsa.listadt.problems

object SinglyListProblems {

    /**
     * Merge sorted linked lists.
     * Brute force way - merge one by one
     * time complexity - no.of list * O(n)
     */
    fun mergeLinkedLists() {

        val list = addNode(Node(3))
        addNode(Node(5), list)
        addNode(Node(6), list)
        addNode(Node(15), list)
        addNode(Node(19), list)

        val list2 = addNode(Node(1))
        addNode(Node(2), list2)
        addNode(Node(3), list2)
        addNode(Node(6), list2)
        addNode(Node(9), list2)
        addNode(Node(10), list2)
        addNode(Node(15), list2)
        addNode(Node(99), list2)

        val list3 = addNode(Node(15))
        addNode(Node(21), list3)
        addNode(Node(99), list3)
        addNode(Node(104), list3)

        printList(list)
        printList(list2)
        val result = mergeTwoLists(list, list2)
        mergeTwoLists(result, list3)
    }

    private fun mergeTwoLists(head: Node?, head2: Node?): Node? {

        var result: Node? = null    // holds the merged lists
        var local = head
        var local2 = head2
        var next: Node?

        while (local != null || local2 != null) {
            if (local == null || local2 == null) {
                result = appendNode(local ?: local2!!, result, true)
                break
            } else if (local.data < local2.data) {
                next = local.next
                result = appendNode(local, result)
                local = next
            } else if (local.data > local2.data) {
                next = local2.next
                result = appendNode(local2, result)
                local2 = next
            } else {
                // add one node from each list
                next = local.next
                result = appendNode(local, result)
                local = next

                // add from second list
                next = local2.next
                result = appendNode(local2, result)
                local2 = next
            }
        }
        println("@@@ Results @@@")
        printList(result)
        return result
    }

    private fun appendNode(node: Node, head: Node?, addAll: Boolean = false): Node? {

        if (addAll.not()) node.next = null

        return head?.let {
            var local = head
            while (local?.next != null) {
                local = local.next
            }
            local?.next = node
            head
        } ?: kotlin.run {
            node
        }
    }

    /**
    1 -> 3
    |           = 1 -> 2 -> 3
    2
     */
    fun flattenLinkedList() {

        val subLink = addNode(
            Node(3)
        )
        addNode(
            Node(
                4
            ), subLink
        )
        addNode(
            Node(
                5
            ), subLink
        )
        val link = addNode(
            Node(2, link = subLink)
        )

        val link7 = addNode(
            Node(8)
        )
        addNode(
            Node(
                9
            ), link7
        )
        addNode(
            Node(
                10
            ), link7
        )

        val link6 = addNode(
            Node(7, link7)
        )

        val head = addNode(
            Node(0)
        )
        addNode(
            Node(
                1,
                link = link
            ), head
        )
        addNode(
            Node(
                6,
                link6
            ), head
        )
        addNode(
            Node(
                11
            ), head
        )
        printList(head)
        flatSubList(head)
        printList(head)
    }

    /**
    1 -> 3
    |           = 1 -> 3 -> 2
    2
     */
    fun flattenLinkedList2() {

        val subLink = addNode(
            Node(4)
        )
        addNode(
            Node(
                5
            ), subLink
        )
        addNode(
            Node(
                6
            ), subLink
        )
        val link = addNode(
            Node(3, link = subLink)
        )

        val head = addNode(
            Node(0)
        )
        addNode(
            Node(
                1,
                link = link
            ), head
        )
        addNode(
            Node(
                2
            ), head
        )

        printList(head)
        flatSubList2(head)
        printList(head)
    }

    /**
      1 -> 3
      |           = 1 -> 2 -> 3
      2
    */
    private fun flatSubList(head: Node?) {

        var local = head

        while (local?.link == null)
            local = local?.next

        while (local != null) {
            local.link?.let { link ->
                val next = local?.next
                local?.next = link
                local?.link = null
                local = local?.next

                if (local?.link != null)
                    flatSubList(local)

                while (local?.next != null) {
                    local = local?.next
                    local?.link?.let {
                        flatSubList(
                            local
                        )
                    }
                }
                local?.next = next
            }
            local = local?.next
        }
    }

    /**
    1 -> 3
    |           = 1 -> 3 -> 2
    2
     */
    private fun flatSubList2(head: Node?) {

        var local = head
        while (local != null) {
            local.link?.let {
                moveLinkToLast(local!!)
            }
            local = local.next
        }
    }

    private fun moveLinkToLast(head: Node) {

        var local: Node? = head
        val link = head.link
        head.link = null

        while (local?.next != null)
            local = local.next

        local?.next = link
    }

    /**
     * Create a list and reverse that list and print data in that list.
     */
    fun reverseLinkedList() {

        val head = addNode(
            Node(1)
        )
        addNode(
            Node(
                2
            )
        )
        addNode(
            Node(
                3
            )
        )
        printList(head)
        val reverseList = reverse(head)
        printList(reverseList)
    }

    /**
     * Reverse a given linked list.
     *
     * @param head source list
     * @return reversed list.
     */
    private fun reverse(head: Node? = null): Node? {
        head?.let {
            var localHead = head    // used to traverse through the list
            var reverseList: Node? = null // used to hold removed items from source

            while (localHead != null) {
                val headNext = localHead.next // we need to preserve source.next as we are updating source.next with previous
                localHead.next = reverseList  // assign previous nodes in reverse to source.next
                reverseList = localHead
                localHead = headNext    // assign saved source.next to source
            }
            return reverseList
        } ?: return null
    }

    /**
     * Print all nodes data in the list.
     *
     * @param head data source.
     */
    private fun printList(head: Node?) {

        head?.let {
            var localHead = head
            while (localHead != null) {
                println("Value: ${localHead.data}")
                localHead = localHead.next
            }
        }
    }

    /**
     * Add a node to end of the list.
     *
     * @param node node to add to end of the list.
     */
    private fun addNode(node: Node, head: Node? = null): Node? {

        if (head == null) {
            return node
        }
        var localHead = head
        while (localHead?.next != null) {
            localHead = localHead.next
        }
        localHead?.next = node
        return head
    }

    /**
     * Singly LinkedList node class which holds data and next node
     *
     * @property data node data.
     * @property link linked list as data in a node.
     * @property next holds next node.
     */
    data class Node(var data: Int, var link: Node? = null, var next: Node? = null)
}