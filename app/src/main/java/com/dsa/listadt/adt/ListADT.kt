package com.dsa.listadt.adt

/**
 * Default array size to hold firstNode. When existing array is full the increment it this size.
 */
private const val ARRAY_SIZE = 10

/**
 *
 */
class ListADT<E> {

    /**
     * Q: lateinit modifier is not allowed on properties of a type with nullable upper bound ?
     * A: In kotlin default upper bound (if not specified) is Any? -> So we can't use lateinit
     * modifier for property with generic
     */
    // private lateinit var firstNode: E

    private var mData: E? = null
    private var mSize = 0

}