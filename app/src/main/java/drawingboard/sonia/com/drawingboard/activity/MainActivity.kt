package drawingboard.sonia.com.drawingboard.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SeekBar
import drawingboard.sonia.com.drawingboard.R
import drawingboard.sonia.com.drawingboard.customview.DEFAULT_SQUARE_LENGTH
import drawingboard.sonia.com.drawingboard.model.Square
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val INTENT_SQUARES = "Squares"

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
                coordinatesTextView.visibility = View.INVISIBLE
                var progress: Int = p1 / 10
                progress *= 30
                drawingView.squareLength = DEFAULT_SQUARE_LENGTH + progress
            }
        })
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val squareList = savedInstanceState?.getParcelableArrayList<Square>(INTENT_SQUARES)
        drawingView.squareList = squareList ?: arrayListOf()
        drawingView.touched = true
        drawingView.invalidate()

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val squareList = drawingView.squareList
        outState?.putParcelableArrayList(INTENT_SQUARES, squareList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when {
            item?.itemId == R.id.done -> {
                coordinatesTextView.visibility = View.VISIBLE
                coordinatesTextView.text = drawingView.squareList.toString()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
