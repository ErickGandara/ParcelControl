package com.bcv.parcelcontrol

import android.content.res.Configuration
import android.graphics.LinearGradient
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.bcv.parcelcontrol.DeliveriesFragment.OnListFragmentInteractionListener
import com.bcv.parcelcontrol.dummy.DummyContent

import kotlinx.android.synthetic.main.activity_main.*
import models.Delivery

class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: Delivery?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var deliveryFrag: DeliveriesFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        deliveryFrag = supportFragmentManager.findFragmentByTag(DeliveriesFragment.TAG) as? DeliveriesFragment?
        if (deliveryFrag == null) {
            deliveryFrag = DeliveriesFragment()
        }
        val fragTrans = supportFragmentManager.beginTransaction()
        fragTrans.replace(R.id.mainContainer, deliveryFrag, DeliveriesFragment.TAG)
        fragTrans.commit()

        fab.setOnClickListener { view ->

        }
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                //TODO handle configuration changes to dismiss
                val spannableString = SpannableString(getString(R.string.icons8link))
                Linkify.addLinks(spannableString, Linkify.WEB_URLS)
                val txtMsg = TextView(this)
                val padding = 20
                txtMsg.setPadding(padding, padding, padding, padding)
                txtMsg.text = spannableString
                txtMsg.movementMethod = LinkMovementMethod.getInstance()
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setView(txtMsg)
                        .setTitle(R.string.about)
                        .setCancelable(true)
                        .setPositiveButton(R.string.ok, null)
                        .create()
                        .show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
