package drawingboard.sonia.com.drawingboard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sizeSlider.incrementProgressBy(10)

        sizeSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            //Dynamically change square size
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                var progress: Int = p1 / 10
                progress *= 30
                drawingView.squareLength = DEFAULT_SQUARE_LENGTH + progress
            }
        })
    }
}
