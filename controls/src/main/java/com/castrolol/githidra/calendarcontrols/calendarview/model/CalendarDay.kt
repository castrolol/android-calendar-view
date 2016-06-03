package com.castrolol.githidra.calendarcontrols.calendarview.model

/**
 * Created by Ps-Luan on 02/06/2016.
 */

data class CalendarDay(val year: Int, val month: Int, val dayOfMonth: Int, val originMonth: Int) {
    val fromOriginalMonth: Boolean
        get() = month == originMonth

}