package com.bcv.parcelcontrol.dummy

import models.Contact
import models.Delivery
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<Delivery> = ArrayList()
    val CARRIERS: MutableList<String> = mutableListOf("USPS", "UPS", "FedEx", "OnTrac")

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, Delivery> = HashMap()

    private val COUNT: Int = (Math.random() * 25).toInt()

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: Delivery) {
        ITEMS.add(item)
        ITEM_MAP.put(item.contact.name, item)
    }

    private fun createDummyItem(position: Int): Delivery {
        val perishable: Boolean = Math.random() < 0.5
        val carrier: Int = (Math.random() * CARRIERS.size).toInt()
        val contact = makeContact(position.toString())
        return Delivery(contact, perishable, CARRIERS.get(carrier))
    }

    private fun makeContact(position: String): Contact {
        val builder = StringBuilder()
        builder.append("Name ").append(position)
        var contact: Contact = Contact(builder.toString(), position)
        return contact
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
