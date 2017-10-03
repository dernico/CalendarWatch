package dernico.calendarwatch

/**
 * Created by acnic on 10/3/2017.
 */
class CalendarDay(cal: NicoCalendar, dayEvents: ArrayList<DayEvent>) {
    var Day : Int = -1
    var DayName : String = ""
    var DayOfWeek : Int = -1
    var Month : Int = -1
    var Year : Int = -1
    var DayEvents : ArrayList<DayEvent> = ArrayList<DayEvent>()

    init {
        Day = cal.DayOfMonth()
        DayOfWeek = cal.DayOfWeek()
        DayName = cal.DayName()

        Month = cal.Month()
        Year = cal.Year()
        DayEvents = dayEvents
    }
}