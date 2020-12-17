package miinjung.study.qquadet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moveToBuyPage()
    }

    private fun moveToBuyPage(){
        val intent = Intent(this, AssignBuyActivity::class.java)
        findViewById<TextView>(R.id.mainBuy).setOnClickListener{
            startActivity(intent)
        }
    }
}