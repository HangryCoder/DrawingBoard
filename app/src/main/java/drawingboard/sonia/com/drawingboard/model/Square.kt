package drawingboard.sonia.com.drawingboard.model

import android.os.Parcel
import android.os.Parcelable

data class Square(val topLeft: Float, val topRight: Float, val bottomLeft: Float, val bottomRight: Float,
                  val squareLength: Float) : Parcelable {

    private val x1 = topLeft
    private val y1 = topRight
    private val x2 = topLeft + squareLength
    private val y2 = topRight
    private val x3 = topLeft + squareLength
    private val y3 = topRight - squareLength
    private val x4 = topLeft
    private val y4 = topRight - squareLength

    constructor(parcel: Parcel) : this(
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat())

    override fun toString(): String {
        return "Coordinates: [{$x1,$y1},{$x2,$y2}," +
                "{$x3,$y3},{$x4,$y4}]"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(topLeft)
        parcel.writeFloat(topRight)
        parcel.writeFloat(bottomLeft)
        parcel.writeFloat(bottomRight)
        parcel.writeFloat(squareLength)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Square> {
        override fun createFromParcel(parcel: Parcel): Square {
            return Square(parcel)
        }

        override fun newArray(size: Int): Array<Square?> {
            return arrayOfNulls(size)
        }
    }
}