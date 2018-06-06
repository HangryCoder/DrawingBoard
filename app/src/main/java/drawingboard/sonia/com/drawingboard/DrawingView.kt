package drawingboard.sonia.com.drawingboard

import android.content.Context
import android.view.MotionEvent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

const val DEFAULT_SQUARE_LENGTH = 200f
class DrawingView : View {

    private var xDown = 0f
    private var yDown = 0f
    /**
     * Setting minimum length as 200f
     * */
    var squareLength = DEFAULT_SQUARE_LENGTH
        set(value) {
            if (value >= DEFAULT_SQUARE_LENGTH) {
                field = value
            }
        }
    private val strokeWidth = 10.0f
    private var squareList = ArrayList<Square>()
    private lateinit var mPaint: Paint
    private var touched = false

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context)
    }

    private fun init(context: Context) {
        mPaint = Paint()
        mPaint.color = Color.BLUE
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = strokeWidth
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.TRANSPARENT)
        if (touched) {
            for (square in squareList) {
                canvas.drawRect(square.topLeft, square.topRight, square.bottomLeft, square.bottomRight, mPaint)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        touched = true
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                xDown = event.x
                yDown = event.y
                squareList.add(Square(xDown, yDown, xDown + squareLength, yDown + squareLength))
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        invalidate()
        return true
    }
}
