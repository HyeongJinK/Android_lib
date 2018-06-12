package nanpasun.wod_timer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var timeText: TextView? = null
    var startBt: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeText = findViewById(R.id.timeText)
        startBt = findViewById(R.id.startBt)

        startBt!!.setOnClickListener(View.OnClickListener(function = {
            timeText!!.text = "fadf"
        }))
    }
}
