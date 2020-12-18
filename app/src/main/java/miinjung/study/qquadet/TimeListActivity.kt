package miinjung.study.qquadet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import miinjung.study.qquadet.util.backPress

class TimeListActivity : AppCompatActivity() {
    val dataList1 = arrayListOf("11:30 am","01:30 pm","01:40 pm","02:00 pm","02:20 pm","02:25 pm","02:40 pm","03:00 pm","03:10 pm","03:20 pm","03:30 pm","03:40 pm","03:50 pm","03:55 pm","04:00 pm","04:05 pm","04:10 pm","04:20 pm","04:40 pm")
    var dataList2 = arrayListOf("0/5","0/7","1/4","2/8","0/3","1/3","2/6","1/4","5/6","0/3","0/7","3/8","1/8","0/9","4/5","1/9","2/3","1/11","4/10")
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