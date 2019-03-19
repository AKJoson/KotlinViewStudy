package www.xcyyp.com

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    val mH : Handler = Handler((msg)->{})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animation  =  ValueAnimator.ofInt(100)
        animation.setDuration(3000).addUpdateListener { valueAnimator ->
            my_view.refrsh(valueAnimator.animatedValue as Int)
        }
        animation.startDelay = 3000
        animation.start()

    }
}
