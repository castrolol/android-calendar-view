package com.castrolol.githidra.calendarcontrol.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.castrolol.githidra.calendarcontrols.calendarview.CalendarView
import com.castrolol.githidra.calendarcontrols.calendarview.interfaces.OnDayClickListener
import com.castrolol.githidra.calendarcontrols.calendarview.interfaces.OnWeekLongClickListener
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarDay
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarWeek
import org.joda.time.DateTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meses = mutableListOf<Pair<Int, String>>()
        var data = DateTime(2016, 1, 1, 0, 0, 0)

        for (i in 1..12) {
            meses.add(i to data.monthOfYear().asText)
            data = data.plusMonths(1)
        }

        val calendar = findViewById(R.id.calendar) as CalendarView
        val spinner = findViewById(R.id.spinner) as Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, meses)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                calendar.month = p2 + 1
            }

        }
        calendar.isWeekLongClickable = true
        calendar.onDayClickListener = OnDayClickListener { view, day -> Toast.makeText(this@MainActivity, "Day ${day.dayOfMonth} clicked", Toast.LENGTH_SHORT).show() }
        calendar.onWeekLongClickListener = OnWeekLongClickListener { view, week ->
            Toast.makeText(this@MainActivity, "Week ${week.weekNumber} clicked", Toast.LENGTH_SHORT).show()
            true;
        }

    }
}
