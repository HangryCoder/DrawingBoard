package drawingboard.sonia.com.drawingboard

data class Square(val topLeft: Float, val topRight: Float, val bottomLeft: Float, val bottomRight: Float) {

    override fun toString(): String {
        return "Coordinates: [{$topLeft,$topRight},{$bottomLeft,$topRight}," +
                "{$bottomLeft,$bottomRight},{$topLeft,$bottomRight}]"
    }
}