package nanpasun.wod_timer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var timeText: TextView? = null
    var startBt: Button? = null
    var timeType: Spinner? = null

    var mTask: TimerTask? = null
    var mTimer: Timer? = null

    var sAdaper: SpinnerAdapter? = null

    var time: Int = 1
    var min: String = "00"
    var sec: String = "00"
    var check: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        timeText = findViewById(R.id.timeText)
        startBt = findViewById(R.id.startBt)
        timeType = findViewById(R.id.timeType)



        startBt!!.setOnClickListener {
            if (check) {
                mTask = object: TimerTask() {
                    override fun run() {
                        Log.d("time count", "time = "+time)

                        min = if (time/60 < 10) {
                            "0"+(time/60).toString()
                        } else {
                            (time/60).toString()
                        }

                        sec = if ((time%60) < 10) {
                            "0"+(time%60).toString()
                        } else {
                            (time%60).toString()
                        }

                        runOnUiThread(Runnable {
                            timeText!!.text = "time = " + min+":"+sec
                        })
                        time++
                    }
                }
                mTimer = Timer()
                mTimer!!.scheduleAtFixedRate(mTask, 0, 1000)
                check = false
            } else {
                mTimer!!.cancel()
                check = true
            }
        }

        sAdaper = ArrayAdapter.createFromResource(this, R.array.timeType, android.R.layout.simple_spinner_dropdown_item)

        timeType!!.adapter = sAdaper
        timeType!!.onItemSelectedListener = selectListener()

    }

    inner class selectListener : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            Log.d("선택된 타입", parent!!.selectedItem.toString())
        }
    }
}