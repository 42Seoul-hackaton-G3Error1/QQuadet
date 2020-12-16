package miinjung.study.qquadet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class AssignBuyActivity : AppCompatActivity() {
    private var num1 = 0
    private var num2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assingn_buy)
        clickFirstBtnM()
        clickFirstBtnP()
        clickAssign()
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
}