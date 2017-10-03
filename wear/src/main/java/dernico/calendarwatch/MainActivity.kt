package dernico.calendarwatch

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()
        var cal = NicoCalendar()
        var today = cal.GetCalendarDay()
        
        var listAdapter = CalendarListAdapter(this)
        listAdapter.setList(cal.GetCalendarDays())

        list.adapter = listAdapter

        list.smoothScrollToPosition(listAdapter.getPosition(today))
    }
}
