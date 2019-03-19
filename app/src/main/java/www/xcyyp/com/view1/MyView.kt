package www.xcyyp.com.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.View
import www.xcyyp.com.R

class MyView @JvmOverloads constructor(context: Context, attribuset: AttributeSet? = null, defStr: Int = 0) :
    View(context, attribuset, defStr) {
    val mInnerPaint: Paint
    val mOutterPain: Paint
    val mTextPaint: Paint
    var heightSize: Int = 0
    var widthSize: Int = 0
    var rect:Rect

    init {
        rect = Rect()
        mInnerPaint = Paint()
        mInnerPaint.color = context.resources.getColor(R.color.color_09c)
        mInnerPaint.strokeWidth = 3.0f
        mInnerPaint.isAntiAlias = true
        mOutterPain = Paint()
        mOutterPain.strokeWidth = 20.0f
        mOutterPain.color = context.resources.getColor(R.color.color_f6)
        mOutterPain.style = Paint.Style.STROKE
        mTextPaint = Paint()
        mTextPaint.textSize = 50.0f
        mOutterPain.color = context.resources.getColor(R.color.color_f6)
        mOutterPain.isAntiAlias = true
        mOutterPain.strokeCap = Paint.Cap.ROUND
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        heightSize = MeasureSpec.getSize(measuredHeight)
        widthSize = MeasureSpec.getSize(measuredWidth)
        e(heightSize.toString())
        e(widthSize.toString())
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var str = currentProgerss;
        mTextPaint.getTextBounds(str.toString(),0,currentProgerss.toString().length,rect)
        canvas?.drawCircle((widthSize / 2).toFloat(), (heightSize / 2).toFloat(), 140.0f, mInnerPaint)
        canvas?.drawText(currentProgerss.toString(),(widthSize/2-rect.width()/2).toFloat(),(heightSize/2+rect.height()/2).toFloat(),mTextPaint)
        canvas?.drawArc(
            (widthSize / 2).toFloat() - 140,
            (heightSize / 2).toFloat() - 140,
            (widthSize / 2).toFloat() + 140,
            (heightSize / 2).toFloat() + 140,
            0.0f, (currentProgerss * 360 / 100.0).toFloat(), false, mOutterPain
        )
    }

    var currentProgerss: Int = 0

    fun refrsh(progress: Int) {
        e(progress.toString())
        currentProgerss = progress
        invalidate()
    }
}

fun e(logs: String) {
    Log.e("TAG", "----$logs")
}
