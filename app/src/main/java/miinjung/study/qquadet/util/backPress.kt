package miinjung.study.qquadet.util

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import miinjung.study.qquadet.R

class backPress {
    fun clickBackPress(button : Button, activity : AppCompatActivity){
        button.setOnClickListener {
            activity.onBackPressed()
        }
    }
}