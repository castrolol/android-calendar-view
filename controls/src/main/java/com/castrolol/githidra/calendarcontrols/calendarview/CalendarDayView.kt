package com.castrolol.githidra.calendarcontrols.calendarview

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarDay
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarWeek

/**
 * Created by Ps-Luan on 02/06/2016.
 */
internal open class CalendarDayView(context: Context, val day: CalendarDay) : LinearLayout(context) {

    init {
        orientation = VERTICAL

        addTextView()

    }

    private fun addTextView() {

        val textView = TextView(context)
        textView.text = day.dayOfMonth.toString()
        val lp = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        lp.weight = 0.142f;
        textView.layoutParams = lp

        addView(textView)

    }

}