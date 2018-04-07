package com.bcv.parcelcontrol

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import com.bcv.parcelcontrol.DeliveriesFragment.OnListFragmentInteractionListener
import com.bcv.parcelcontrol.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_delivery.view.*
import models.Delivery

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyDeliveryRecyclerViewAdapter(
        private val mValues: List<Delivery>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyDeliveryRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Delivery
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_delivery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView?.setText(item.contact.unit)
        holder.mContentView?.setText(item.contact.name)
        holder.mPerishable?.visibility = if (item.perishable) View.VISIBLE else View.INVISIBLE
        holder.mCarrierView?.setText(item.carrier)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.txtUnitNum
        val mContentView: TextView = mView.txtContact
        val mPerishable: AppCompatImageView? = mView.ivPerish
        val mCarrierView: TextView = mView.txtCarrier

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
