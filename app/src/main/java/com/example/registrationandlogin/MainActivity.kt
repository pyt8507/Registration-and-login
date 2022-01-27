package com.example.registrationandlogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*点击注册按钮，跳转到注册界面*/
        button.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        /*设定并显示原始剩余密码输入次数*/
        var left = 3
        textView6.text = left.toString()

        /*默认记住用户名*/
        val prefs1 = getSharedPreferences("userdata", Context.MODE_PRIVATE)
        editTextTextPersonName.setText(prefs1.getString("username", ""))
        /*若记住了密码则显示密码并勾选记住密码*/
        if (prefs1.getBoolean("check", false))
        {
            editTextTextPersonName2.setText(prefs1.getString("password", ""))
            checkBox.isChecked = true
        }
        /*否则不勾选记住密码*/
        else
            checkBox.isChecked = false

        /*设置登录按钮*/
        button2.setOnClickListener{
            if (left == 0)//若无剩余输入次数则提示并不允许登录
                Toast.makeText(this,R.string.nochance,Toast.LENGTH_SHORT).show()
            else//否则
            {
                val prefs = getSharedPreferences("userdata", Context.MODE_PRIVATE)
                val username = prefs.getString("username", "")
                val password = prefs.getString("password", "")
                if (username == "")//未保存有用户名信息表示为注册，提示需要先注册
                    Toast.makeText(this,R.string.signupfirst,Toast.LENGTH_SHORT).show()
                else if (editTextTextPersonName.text.toString() == "" || editTextTextPersonName2.text.toString() == "")//用户名或密码为输入，提示输入
                    Toast.makeText(this,R.string.input,Toast.LENGTH_SHORT).show()
                /*验证输入*/
                else if (username.equals(editTextTextPersonName.text.toString()) && password.equals(editTextTextPersonName2.text.toString()))//正确
                {
                    Toast.makeText(this,R.string.loginsuccessfully,Toast.LENGTH_SHORT).show()
                    val editor = getSharedPreferences("userdata", Context.MODE_PRIVATE).edit()
                    editor.putBoolean("check", checkBox.isChecked)
                    editor.apply()
                }
                else//错误
                {
                    Toast.makeText(this,R.string.incorrect,Toast.LENGTH_SHORT).show()
                    left--//剩余输入次数减一
                    textView6.text = left.toString()
                }
            }

        }
    }
}