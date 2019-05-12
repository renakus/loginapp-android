package net.renakus.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var unameInput: String = ""
    var passInput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsave.setOnClickListener {
            validasiInput()
        }
    }

    private fun validasiInput() {
        unameInput = edtuname.text.toString()
        passInput = edtpass.text.toString()

        when {
            unameInput.isEmpty() -> edtuname.error = "Username tidak boleh kosong"
            passInput.isEmpty() -> edtpass.error = "Password tidak boleh kosong"

            else -> {
                navigasiKePageLogin()
            }
        }

    }

    private fun navigasiKePageLogin() {
        val intent = Intent(this, login::class.java)

        val bundle = Bundle()
        bundle.putString("uname", unameInput)
        bundle.putString("pass", passInput)

        intent.putExtras(bundle)

        startActivity(intent)
    }
}
