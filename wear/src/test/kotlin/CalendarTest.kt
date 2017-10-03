import dernico.calendarwatch.NicoCalendar
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * Created by acnic on 10/3/2017.
 */

class CalendarTest {

    @Test
    fun Test1() {
        var cal = NicoCalendar(3, Calendar.OCTOBER, 2017)

        assertEquals(Calendar.TUESDAY, cal.DayOfWeek())
        assertEquals(9, cal.Month())
        assertEquals(2017, cal.Year())
    }

    @Test
    fun Test2() {
        var cal = NicoCalendar(16, Calendar.OCTOBER, 2017)

        assertEquals(Calendar.MONDAY, cal.DayOfWeek())
        assertEquals(9, cal.Month())
        assertEquals(2017, cal.Year())
    }

    @Test
    fun TestDaysInMonth() {
        var cal = NicoCalendar(16, Calendar.OCTOBER, 2017)
        assertEquals(31, cal.DaysInMonth())

        cal = NicoCalendar(16, Calendar.SEPTEMBER, 2017)
        assertEquals(30, cal.DaysInMonth())
    }

    @Test
    fun TestGetDays() {
        var cal = NicoCalendar(16, Calendar.OCTOBER, 2017)
        var days = cal.GetCalendarDays()
        var firstDay = days.first()
        var lastDay = days.last()

        assertEquals(31, days.size)

        assertEquals(1, firstDay.Day)
        assertEquals(Calendar.SUNDAY, firstDay.DayOfWeek)

        assertEquals(31, lastDay.Day)
        assertEquals(Calendar.TUESDAY, lastDay.DayOfWeek)
    }

    //Test for testing today
//    @Test
//    fun Test3() {
//        var cal = NicoCalendar()
//
//        assertEquals(Calendar.TUESDAY, cal.DayOfWeek())
//        assertEquals(3, cal.DayOfMonth())
//        assertEquals(3, cal.DayOfMonth())
//        assertEquals(9, cal.Month())
//        assertEquals(2017, cal.Year())
//    }
}