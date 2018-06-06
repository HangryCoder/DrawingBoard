package drawingboard.sonia.com.drawingboard

import android.content.Context
import android.view.MotionEvent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class DrawingView : View {

    private var xDown = 0f
    private var yDown = 0f
    var width = 200.0f
    var height = 200.0f
    var strokeWidth = 10.0f
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
                // canvas.drawRect(xDown, yDown, xDown + width, yDown + height, mPaint)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        touched = true
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                xDown = event.x
                yDown = event.y
                squareList.add(Square(xDown, yDown, xDown + width, yDown + width))
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        invalidate()
        return true
    }
}
