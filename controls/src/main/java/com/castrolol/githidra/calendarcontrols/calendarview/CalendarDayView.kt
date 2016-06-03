package com.castrolol.githidra.calendarcontrols.calendarview

import android.content.Context
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.castrolol.githidra.calendarcontrols.R
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarDay
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarWeek

/**
 * Created by Ps-Luan on 02/06/2016.
 */
internal open class CalendarDayView(context: Context, val day: CalendarDay) : LinearLayout(context) {



    init {
        orientation = VERTICAL
        val lp = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        lp.weight = 0.142f;
        setPadding(32, 8, 16, 8)
        layoutParams = lp
        setBackgroundResource(R.drawable.calendar_day_border)
        addTextView()

    }

    private fun addTextView() {

        val textView = TextView(context)
        textView.text = day.dayOfMonth.toString()
        textView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        if (day.fromOriginalMonth) {
            textView.setTypeface(null, Typeface.BOLD);
        } else {
            textView.setTextColor(resources.getColor(R.color.text_another_month))
        }

        addView(textView)

    }

}