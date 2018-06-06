package drawingboard.sonia.com.drawingboard

data class Square(val topLeft: Float, val topRight: Float, val bottomLeft: Float, val bottomRight: Float,
                  val squareLength: Float) {

    private val x1 = topLeft
    private val y1 = topRight
    private val x2 = topLeft + squareLength
    private val y2 = topRight
    private val x3 = topLeft + squareLength
    private val y3 = topRight - squareLength
    private val x4 = topLeft
    private val y4 = topRight - squareLength

    override fun toString(): String {
        return "Coordinates: [{$x1,$y1},{$x2,$y2}," +
                "{$x3,$y3},{$x4,$y4}]"
    }
}