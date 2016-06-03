package com.castrolol.githidra.calendarcontrols.calendarview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.castrolol.githidra.calendarcontrols.calendarview.interfaces.OnDayClickListener
import com.castrolol.githidra.calendarcontrols.calendarview.interfaces.OnDayLongClickListener
import com.castrolol.githidra.calendarcontrols.calendarview.interfaces.OnWeekClickListener
import com.castrolol.githidra.calendarcontrols.calendarview.interfaces.OnWeekLongClickListener
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarDay
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarMonth
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarWeek
import org.joda.time.DateTime
import java.util.*

/**
 * Created by Ps-Luan on 02/06/2016.
 */

open class CalendarView : LinearLayout {


    private var _month = DateTime.now().monthOfYear
    private var _year = DateTime.now().year;
    private var _model = CalendarMonth(_month, _year)
    private var _weekLongClickEnabled = false;
    private var _dayLongClickEnabled = false;

    var onWeekClickListener: OnWeekClickListener = OnWeekClickListener { view, week -> }
    var onDayClickListener: OnDayClickListener = OnDayClickListener { view, day -> }
    var onWeekLongClickListener: OnWeekLongClickListener = OnWeekLongClickListener { view, week -> false }
    var onDayLongClickListener: OnDayLongClickListener = OnDayLongClickListener { view, day -> false }

    var isWeekLongClickable: Boolean
        get() = _weekLongClickEnabled
        set(value) {
            _weekLongClickEnabled = value
            updateView()
        }

    var isDayLongClickable: Boolean
        get() = _dayLongClickEnabled
        set(value) {
            _dayLongClickEnabled = value
            updateView()
        }


    constructor(context: Context) : super(context) {
        this.orientation = VERTICAL
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.orientation = VERTICAL
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.orientation = VERTICAL
    }

    init {
        updateView()
    }

    var month: Int
        get() = _month
        set(value) {
            _month = value
            updateView()
        }

    var year: Int
        get() = _year
        set(value) {
            _year = value
            updateView()
        }

    private fun updateView() {
        _model = CalendarMonth(_month, _year)

        removeAllViews()

        _model.weeks.forEach {
            val weekView = CalendarWeekView(context, it)
            weekView.setOnClickListener { v -> handleWeekClick(v, it) }
            weekView.setOnLongClickListener { v -> handleWeekLongClick(v, it) }
            weekView.onDayClickListener = OnDayClickListener { v, c -> onDayClickListener.onClick(v, c) }
            weekView.isDayLongClickable = _dayLongClickEnabled
            if (_weekLongClickEnabled) {
                weekView.onDayLongClickListener = OnDayLongClickListener { v, c -> onDayLongClickListener.onLongClick(v, c) }
                weekView.isLongClickable = true
            }
            addView(weekView)
        }

    }

    private fun handleWeekClick(view: View, week: CalendarWeek) {
        onWeekClickListener.onClick(view, week)
    }

    private fun handleWeekLongClick(view: View, week: CalendarWeek): Boolean {
        return onWeekLongClickListener.onLongClick(view, week)
    }


}