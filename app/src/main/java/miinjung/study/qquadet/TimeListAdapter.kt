package miinjung.study.qquadet

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class TimeListAdapter(private val itemClick: () -> Unit) : RecyclerView.Adapter<TimeListAdapter.TimeListViewHolder>(){
    var dataArriveTime = ArrayList<String>()
    var dataCountQQ = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeListViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_time_list,parent,false)
        return TimeListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TimeListViewHolder, position: Int) =
        holder.bind(dataArriveTime[position], dataCountQQ[position], itemClick)

    override fun getItemCount(): Int {
        return dataArriveTime.size
    }

    fun setItem(item1: ArrayList<String>, item2: ArrayList<String>){
        dataArriveTime.addAll(item1)
        dataCountQQ.addAll(item2)
    }

    class TimeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val arriveTime = itemView.findViewById<TextView>(R.id.tvArriveTime)
        private val countQq = itemView.findViewById<TextView>(R.id.tvCountQQ)
        private val sinChung = itemView.findViewById<Button>(R.id.btnSinChung)
        fun bind(arrive : String, count : String, itemClick: () -> Unit){
            arriveTime.text = arrive
            countQq.text = count
            sinChung.setOnClickListener { itemClick() }
        }
    }

}