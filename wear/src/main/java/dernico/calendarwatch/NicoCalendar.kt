package dernico.calendarwatch

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by acnic on 10/3/2017.
 */
class NicoCalendar {
    val calendar : Calendar
    val locale: Locale

    constructor(){
        calendar = Calendar.getInstance()
        locale = Locale.getDefault()
    }

    constructor(day: Int, month: Int, year: Int) {
        calendar = Calendar.getInstance()
        locale = Locale.getDefault()
        calendar.set(Calendar.DAY_OF_MONTH, day)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.YEAR, year)
    }

    fun DayOfMonth() : Int { return calendar.get(Calendar.DAY_OF_MONTH) }
    fun DayOfWeek() : Int { return calendar.get(Calendar.DAY_OF_WEEK) }
    fun DayName() : String { return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, locale)}

    fun Month() : Int { return calendar.get(Calendar.MONTH) }
    fun DaysInMonth() : Int { return calendar.getActualMaximum(Calendar.DAY_OF_MONTH) }
    fun Year() : Int { return calendar.get(Calendar.YEAR)}

    fun GetCalendarDay() : CalendarDay {
        return CalendarDay(this, ArrayList<DayEvent>())
    }

    fun GetCalendarDays() : ArrayList<CalendarDay> {
        var days = ArrayList<CalendarDay>()
        for (i in 1..this.DaysInMonth()){
            var cal = NicoCalendar(i, Month(), Year())
            days.add(CalendarDay(cal, ArrayList<DayEvent>()))
        }
        return days
    }
}