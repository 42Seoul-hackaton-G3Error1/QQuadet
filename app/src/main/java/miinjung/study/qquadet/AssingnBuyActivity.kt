package miinjung.study.qquadet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.activity_assign_buy.*


class AssingnBuyActivity : AppCompatActivity() {
    companion object key {
        private const val MINUTEMAX = 59
        private const val HOURMAX = 12
    }
    private var snackNum = 0
    private var toggleButtonFirst = 0
    private var toggleButtonSecond = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assign_buy)
    }

    override fun onStart() {
        super.onStart()
        initEditText()
        initBtn()
        initToggleBtn()
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

    private fun initHourEdit(){
        findViewById<EditText>(R.id.arrivalHour).let{
            it.setOnEditorActionListener(hourEditListener(it))
        }

        findViewById<EditText>(R.id.endHour).let{
            it.setOnEditorActionListener(hourEditListener(it))
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

    private fun hourEditListener(editText : EditText) : TextView.OnEditorActionListener {
        Log.d("dddattta", "hour")
        return TextView.OnEditorActionListener { num, id, event  ->
            num.text?.let{
                val minute = Integer.parseInt(it.toString())
                if(minute > HOURMAX) {
                    editText.text = Editable.Factory.getInstance().newEditable(HOURMAX.toString())
                }
            }
            return@OnEditorActionListener false
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

    private fun initToggleBtn(){
        val arriveAM = findViewById<ToggleButton>(R.id.arriveAM)
        val arrivePM = findViewById<ToggleButton>(R.id.arrivePM)
        val endAM = findViewById<ToggleButton>(R.id.endAM)
        val endPM = findViewById<ToggleButton>(R.id.endPM)
        arriveAM?.let{
            it.setOnCheckedChangeListener { compoundButton, b ->
                toggleBtn(arrivePM, b)
            }
        }
        arrivePM?.let{
            it.setOnCheckedChangeListener { compoundButton, b ->
                toggleBtn(arriveAM, b)
            }
        }
        endAM?.let{
            it.setOnCheckedChangeListener { compoundButton, b ->
                toggleBtn(endPM, b)
            }
        }
        endPM?.let{
            it.setOnCheckedChangeListener { compoundButton, b ->
                toggleBtn(endAM, b)
            }
        }
    }

    private fun toggleBtn(BtnOther: ToggleButton, isChecked : Boolean) {
        BtnOther.isChecked = !isChecked
    }

}