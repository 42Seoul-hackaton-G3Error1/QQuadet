package miinjung.study.qquadet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import miinjung.study.qquadet.util.backPress
import miinjung.study.qquadet.util.keyCollection

class MyPageActivity() : AppCompatActivity() {
    private var tabNum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        backPress().clickBackPress(findViewById(R.id.btn_toolbar_mypage_back),this)
        getExtra()
        initTab()
    }

    private fun getExtra(){
        tabNum = intent.getIntExtra(keyCollection.TABNUM,0)
    }

    private fun initTab(){
        val viewpager = findViewById<ViewPager2>(R.id.vp_mypage_container)
        val tabLayout = findViewById<TabLayout>(R.id.tab_mypage)
        viewpager.adapter = MyPageTabAdapter(this)
        viewpager.setCurrentItem(tabNum, true)
        TabLayoutMediator(tabLayout,viewpager){ tab: TabLayout.Tab, position: Int ->
            tab.customView = setItem(position)
        }.attach()
    }

    private fun setItem(position: Int) : View {
        val tabView = LayoutInflater.from(this).inflate(R.layout.item_tab, null)
        val tabName = tabView.findViewById<TextView>(R.id.tv_tab_item)
        return when (position) {
            0 -> {
                tabName.text = getString(R.string.eat)
                tabView
            }
            else -> {
                tabName.text = getString(R.string.buy)
                tabView
            }
        }
    }
}