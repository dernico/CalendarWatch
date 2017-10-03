package dernico.calendarwatch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by acnic on 10/3/2017.
 */
class CalendarListAdapter(context: Context) : BaseAdapter() {

    internal var mList = ArrayList<CalendarDay>()

    private val mInflator: LayoutInflater = LayoutInflater.from(context)

    fun setList(days: ArrayList<CalendarDay>){
        mList = days
        this.notifyDataSetChanged()
    }

    fun getPosition(day: CalendarDay) : Int{
        var el = mList.find { d -> d.Day == day.Day }
        return mList.indexOf(el)
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(position: Int): Any {
        return mList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.list_row, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.day.text = mList[position].Day.toString()
        vh.dayText.text = mList[position].DayName
        return view
    }

    private class ListRowHolder(row: View?) {
        val day: TextView
        val dayText: TextView

        init {
            this.day = row?.findViewById<TextView>(R.id.list_row_day) as TextView
            this.dayText = row?.findViewById<TextView>(R.id.list_row_dayText)
        }
    }
}