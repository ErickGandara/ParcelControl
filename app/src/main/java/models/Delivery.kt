package models

import android.text.format.DateUtils
import java.time.chrono.ChronoLocalDateTime
import java.util.*

class Delivery(var contact: Contact, var perishable: Boolean = false, var carrier: String = "") {
    var date: Date = Date()
    constructor(contact: Contact, date: Date) : this(contact) {

    }
}