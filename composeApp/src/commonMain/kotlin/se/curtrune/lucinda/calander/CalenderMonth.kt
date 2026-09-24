package se.curtrune.lucinda.calander

import kotlinx.datetime.DatePeriod
import se.curtrune.lucinda.data.Item

import kotlinx.datetime.YearMonth
import kotlinx.datetime.LocalDate
import kotlinx.datetime.isoDayNumber
import kotlinx.datetime.minus
import kotlinx.datetime.onDay
import kotlinx.datetime.plus


/**
 * represents a month of appointments with leading and trailing dates'
 * ie always starting with a monday
 * 42 dates
 * don't know if it handles locale week starts sunday
 */
class CalenderMonth(private val yearMonth: YearMonth) {
    private var firstDate: LocalDate? = null
    private var firstDateOfMonth: LocalDate? = null
    var lastDateOfMonth: LocalDate? = null
        private set
    var lastDate: LocalDate? = null
        private set
    private var calenderDates: MutableList<CalendarDate>? = null

    init {
        init()
    }

    fun addCalendarDate(calenderDate: CalendarDate) {
        val calenderDate1 = getCalenderDate(calenderDate.date)
        calenderDate1?.addItems(calenderDate.items)
    }

    fun addEvent(item: Item): CalenderMonth {
        println("CalendarMonth.addEvent(Item)")
        val optionalCalenderDate = calenderDates!!
            .firstOrNull { calenderDate: CalendarDate? -> calenderDate!!.date == item.targetDate }
        optionalCalenderDate?.add(item)
        return this

    }


    fun getCalenderDate(date: LocalDate): CalendarDate? {
        return calenderDates!!
            .firstOrNull { calenderDate: CalendarDate -> calenderDate.date == date }

    }

    fun getCalenderDates(): MutableList<CalendarDate> {
        return calenderDates!!
    }

    fun getEvents(date: LocalDate?): MutableList<Item?>? {
        return null
    }

    fun getFirstDate(): LocalDate {
        return firstDate!!
    }

    fun getFirstDateOfMonth(): LocalDate {
        return firstDateOfMonth!!
    }

    private fun init() {
        println("...init()")
        firstDateOfMonth = yearMonth.onDay(1)
        lastDateOfMonth = yearMonth.lastDay
        val offset = firstDateOfMonth!!.dayOfWeek
        firstDate = firstDateOfMonth!!.minus(DatePeriod(days = offset.isoDayNumber))
        lastDate = firstDate!!.plus(DatePeriod(months = 1))
    }

    fun setCalenderDates(calenderDates: MutableList<CalendarDate>) {
        this.calenderDates = calenderDates
    }
}
