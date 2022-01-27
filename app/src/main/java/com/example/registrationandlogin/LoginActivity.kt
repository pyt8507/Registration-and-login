package com.example.registrationandlogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener{
            this.finish()
        }

        button2.setOnClickListener{
            val editor = getSharedPreferences("userdata", Context.MODE_PRIVATE).edit()
            if (editTextTextPersonName.text.toString()!="" && editTextTextPersonName2.text.toString()!="")//若用户名和密码均不空
            {
                //保存信息
                editor.putString("username", editTextTextPersonName.text.toString())
                editor.putString("password", editTextTextPersonName2.text.toString())
                editor.apply()
                Toast.makeText(this,R.string.signupsuccessfully, Toast.LENGTH_SHORT).show()
                this.finish()
            }
            else//否则提示不能为空
                Toast.makeText(this,R.string.notempty, Toast.LENGTH_SHORT).show()
        }
    }
}