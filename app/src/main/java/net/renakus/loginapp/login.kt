package net.renakus.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class login : AppCompatActivity() {

    var unameInput: String = ""
    var passInput: String = ""
    var uname: String? = null
    var pass: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnlogin.setOnClickListener{
            login()
        }
    }

    private fun login(){
        unameInput = edtunamelogin.text.toString()
        passInput = edtpasslogin.text.toString()
        ambilData()

        when{
            unameInput.isEmpty() -> edtunamelogin.error = "Username tidak boleh kosong"
            passInput.isEmpty() -> edtpasslogin.error = "Password tidak boleh kosong"

            else-> {
                if (unameInput.equals(uname) && passInput.equals(pass)) {
                    navigasiKePageShow()
                }
            }
        }
    }

    private fun ambilData(){
        val bundle: Bundle? = intent.extras

        uname = bundle?.getString("uname")
        pass = bundle?.getString("pass")
    }

    private fun navigasiKePageShow(){
        val intent = Intent(this, show::class.java)

        val bundle = Bundle()
        bundle.putString("uname", unameInput)
        bundle.putString("pass", passInput)

        intent.putExtras(bundle)

        startActivity(intent)
    }
}
