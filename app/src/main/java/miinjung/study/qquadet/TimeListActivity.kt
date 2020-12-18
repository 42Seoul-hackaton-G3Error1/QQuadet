package miinjung.study.qquadet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import miinjung.study.qquadet.util.backPress

class TimeListActivity : AppCompatActivity() {
    val dataList1 = arrayListOf("11:00","12:00","13:00","14:00")
    var dataList2 = arrayListOf("1/11","2/11","3/11","4/11")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_list)
        backPress().clickBackPress(findViewById(R.id.btn_toolbar_eat_back),this)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rvTimeList)
        val adapter = TimeListAdapter{ moveView() }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setItem(dataList1, dataList2)
        adapter.notifyDataSetChanged()
    }

    private fun moveView() {
        val intent = Intent(this, AssignEatActivity::class.java)
        startActivity(intent)
    }
}