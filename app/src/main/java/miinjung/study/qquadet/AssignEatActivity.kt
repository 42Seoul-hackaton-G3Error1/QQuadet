package miinjung.study.qquadet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import miinjung.study.qquadet.util.backPress
import miinjung.study.qquadet.util.keyCollection

class AssignEatActivity : AppCompatActivity() {
    private var sugarNum = 0
    private var noSugarNum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assign_eat)
        backPress().clickBackPress(findViewById(R.id.btn_toolbar_eat_back),this)
        clickFirstBtnM()
        clickFirstBtnP()
        clickSecondBtnM()
        clickSecondBtnP()
        clickAssign()
    }

    private fun clickFirstBtnM(){
        findViewById<Button>(R.id.btnFirstM).setOnClickListener(){
            if(sugarNum > 0){
                sugarNum--
                findViewById<TextView>(R.id.tvFirstText).text = sugarNum.toString()
            }
        }
    }

    private fun clickFirstBtnP(){
        findViewById<Button>(R.id.btnFirstP).setOnClickListener(){
            sugarNum++
            findViewById<TextView>(R.id.tvFirstText).text = sugarNum.toString()
        }
    }

    private fun clickSecondBtnM(){
        findViewById<Button>(R.id.btnSecondM).setOnClickListener(){
            if(noSugarNum > 0) {
                noSugarNum--
                findViewById<TextView>(R.id.tvSecondText).text = noSugarNum.toString()
            }
        }
    }

    private fun clickSecondBtnP(){
        findViewById<Button>(R.id.btnSecondP).setOnClickListener(){
            noSugarNum++
            findViewById<TextView>(R.id.tvSecondText).text = noSugarNum.toString()
        }
    }

    private fun clickAssign(){
        val intent = Intent(this,MyPageActivity::class.java)
        findViewById<Button>(R.id.btnAssign).setOnClickListener() {
            intent.putExtra("sugarNum",sugarNum)
            intent.putExtra("noSugarNum",noSugarNum)
            intent.putExtra(keyCollection.TABNUM, 0)
            startActivity(intent)
        }
    }
}