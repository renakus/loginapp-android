package net.renakus.loginapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show.*

class show : AppCompatActivity() {

    var uname: String? = null
    var pass: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        ambilData()
    }

    private fun ambilData() {
        val bundle: Bundle? = intent.extras

        uname = bundle?.getString("uname")
        pass = bundle?.getString("pass")

        txthello.text = uname
    }


}
