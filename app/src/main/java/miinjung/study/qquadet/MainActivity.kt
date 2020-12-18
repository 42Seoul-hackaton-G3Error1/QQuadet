package miinjung.study.qquadet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import miinjung.study.qquadet.util.keyCollection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moveToBuyPage()
        moveToEatPage()
        clickMyPage()
    }

    private fun moveToBuyPage(){
        val intent = Intent(this, AssignBuyActivity::class.java)
        findViewById<TextView>(R.id.mainBuy).setOnClickListener{
            startActivity(intent)
        }
    }

    private fun moveToEatPage(){
        val intent = Intent(this, TimeListActivity::class.java)
        findViewById<TextView>(R.id.mainEat).setOnClickListener{
            startActivity(intent)
        }
    }

    private fun clickMyPage(){
        val intent = Intent(this, MyPageActivity::class.java)
        findViewById<ImageView>(R.id.ivMainMyPage).setOnClickListener{
            intent.putExtra(keyCollection.TABNUM, 0)
            startActivity(intent)
        }
    }
}