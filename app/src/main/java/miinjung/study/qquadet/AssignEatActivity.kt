package miinjung.study.qquadet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AssignEatActivity : AppCompatActivity() {
    private var num1 = 0
    private var num2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assign_eat)
        clickFirstBtnM()
        clickFirstBtnP()
        clickSecondBtnM()
        clickSecondBtnP()
        clickAssign()
    }

    private fun clickFirstBtnM(){
        findViewById<Button>(R.id.btnFirstM).setOnClickListener(){
            if(num1 > 0){
                num1--
                findViewById<TextView>(R.id.tvFirstText).text = num1.toString()
            }
        }
    }

    private fun clickFirstBtnP(){
        findViewById<Button>(R.id.btnFirstP).setOnClickListener(){
            num1++
            findViewById<TextView>(R.id.tvFirstText).text = num1.toString()
        }
    }

    private fun clickSecondBtnM(){
        findViewById<Button>(R.id.btnSecondM).setOnClickListener(){
            if(num2 > 0) {
                num2--
                findViewById<TextView>(R.id.tvSecondText).text = num2.toString()
            }
        }
    }

    private fun clickSecondBtnP(){
        findViewById<Button>(R.id.btnSecondP).setOnClickListener(){
            num2++
            findViewById<TextView>(R.id.tvSecondText).text = num2.toString()
        }
    }

    private fun clickAssign(){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("number1",num1)
        intent.putExtra("number2",num2)
        findViewById<Button>(R.id.btnAssign).setOnClickListener() {
            startActivity(intent)
        }
    }
}