package miinjung.study.qquadet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_assingn_buy.*


class AssingnBuyActivity : AppCompatActivity() {
    companion object key {
        private const val MINUTEMAX = 59
        private const val HOURMAX = 12
    }
    private var snackNum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assingn_buy)
    }

    override fun onStart() {
        super.onStart()
        initEditText()
        initBtn()
    }

    private fun initEditText(){
        initHourEdit()
        initMinuteEdit()
    }

    private fun initBtn(){
        clickFirstBtnM()
        clickFirstBtnP()
        clickAssign()
    }

    private fun clickFirstBtnM(){
        findViewById<Button>(R.id.btnFirstMinus).setOnClickListener {
            if(snackNum > 0){
                snackNum--
                findViewById<TextView>(R.id.tvSecondText2).text = snackNum.toString()
            }
        }
    }

    private fun clickFirstBtnP(){
        findViewById<Button>(R.id.btnFirstPlus).setOnClickListener {
            snackNum++
            findViewById<TextView>(R.id.tvSecondText2).text = snackNum.toString()
        }
    }

    private fun clickAssign(){
        val intent = Intent(this, MainActivity::class.java)
        findViewById<Button>(R.id.btnAssign2).setOnClickListener{
            startActivity(intent)
        }
    }

    private fun hourEditListener(editText : EditText) : View.OnFocusChangeListener {
        Log.d("dddattta", "hour")
        return View.OnFocusChangeListener { _, hasFocus ->
            if(!hasFocus) {
                 val hour = Integer.parseInt(editText.text.toString().toString())
                if(hour > HOURMAX)
                    editText.text = Editable.Factory.getInstance().newEditable(HOURMAX.toString())
            }
        }
    }

    private fun minuteEditListener(editText : EditText) : TextView.OnEditorActionListener{
        Log.d("data","minute")
        return TextView.OnEditorActionListener { num, id, event ->
            num.text?.let{
                val minute = Integer.parseInt(it.toString())
                if(minute > MINUTEMAX) {
                    editText.text = Editable.Factory.getInstance().newEditable(MINUTEMAX.toString())
                }
            }
            return@OnEditorActionListener false
        }
    }

    private fun initHourEdit(){
        val etArriveHour = findViewById<EditText>(R.id.arrivalHour)
        findViewById<EditText>(R.id.arrivalHour).let{
            it.onFocusChangeListener = hourEditListener(it)
        }

        findViewById<EditText>(R.id.endHour).let{
            it.onFocusChangeListener = hourEditListener(it)
        }
    }

    private fun initMinuteEdit(){
        findViewById<EditText>(R.id.arrivalMinute)?.let{
            it.setOnEditorActionListener(minuteEditListener(it))
        }
        findViewById<EditText>(R.id.endMinute)?.let{
            it.setOnEditorActionListener(minuteEditListener(it))
        }
    }

//    private fun detectNumHour2(){
//        val editText = findViewById<EditText>(R.id.end_hour)
//        editText.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                Log.d("data","before")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.d("data","ing")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                s?.let{
//                    num1 = Integer.parseInt(it.toString())
//                    if(num1 > 12) {
//                        editText.text = Editable.Factory.getInstance().newEditable(hourMax.toString())
//                    }
//                }
//            }
//        })
//    }
//
//    private fun detectNumMinute1(){
//        val editText = findViewById<EditText>(R.id.arrival_minute)
//        editText.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                Log.d("data","before")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.d("data","ing")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                s?.let{
//                    num2 = Integer.parseInt(it.toString())
//                    if(num2 > 59) {
//                        editText.text = Editable.Factory.getInstance().newEditable(minuteMax.toString())
//                    }
//                }
//            }
//        })
//    }
//
//    private fun detectNumMinute2(){
//        val editText = findViewById<EditText>(R.id.end_minute)
//        editText.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                Log.d("data","before")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.d("data","ing")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                s?.let{
//                    num2 = Integer.parseInt(it.toString())
//                    if(num2 > 59) {
//                        editText.text = Editable.Factory.getInstance().newEditable(minuteMax.toString())
//                    }
//                }
//            }
//        })
//    }
}