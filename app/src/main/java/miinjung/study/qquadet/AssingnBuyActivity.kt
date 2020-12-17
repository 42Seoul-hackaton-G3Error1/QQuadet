package miinjung.study.qquadet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_assingn_buy.*


class AssingnBuyActivity : AppCompatActivity() {
    companion object key {
        val minuteMax = 59
        val hourMax = 12
    }

    private var num1 = 0
    private var num2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assingn_buy)
        clickFirstBtnM()
        clickFirstBtnP()
        clickAssign()
        detectNumHour1()
        detectNumHour2()
        detectNumMinute1()
        detectNumMinute2()
    }

    private fun clickFirstBtnM(){
        findViewById<Button>(R.id.btnFirstMinus).setOnClickListener(){
            if(num1 > 0){
                num1--
                findViewById<TextView>(R.id.tvSecondText2).text = num1.toString()
            }
        }
    }

    private fun clickFirstBtnP(){
        findViewById<Button>(R.id.btnFirstPlus).setOnClickListener(){
            num1++
            findViewById<TextView>(R.id.tvSecondText2).text = num1.toString()
        }
    }

    private fun clickAssign(){
        findViewById<Button>(R.id.btnAssign2).setOnClickListener() {
            Toast.makeText(this,num1.toString()+","+num2.toShort(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun detectNumHour1(){
        val editText = findViewById<EditText>(R.id.arrival_hour)
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("data","before")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("data","ing")
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let{
                    num1 = Integer.parseInt(it.toString())
                    if(num1 > 12) {
                        editText.text = Editable.Factory.getInstance().newEditable(hourMax.toString())
                    }
                }
            }
        })
    }

    private fun detectNumHour2(){
        val editText = findViewById<EditText>(R.id.end_hour)
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("data","before")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("data","ing")
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let{
                    num1 = Integer.parseInt(it.toString())
                    if(num1 > 12) {
                        editText.text = Editable.Factory.getInstance().newEditable(hourMax.toString())
                    }
                }
            }
        })
    }

    private fun detectNumMinute1(){
        val editText = findViewById<EditText>(R.id.arrival_minute)
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("data","before")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("data","ing")
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let{
                    num2 = Integer.parseInt(it.toString())
                    if(num2 > 59) {
                        editText.text = Editable.Factory.getInstance().newEditable(minuteMax.toString())
                    }
                }
            }
        })
    }

    private fun detectNumMinute2(){
        val editText = findViewById<EditText>(R.id.end_minute)
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("data","before")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("data","ing")
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let{
                    num2 = Integer.parseInt(it.toString())
                    if(num2 > 59) {
                        editText.text = Editable.Factory.getInstance().newEditable(minuteMax.toString())
                    }
                }
            }
        })
    }
}