package teamj.uploadtest.lottto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countDownTimer = object : CountDownTimer(3000, 100){
            override fun onFinish() {
            }

            override fun onTick(millisUntilFinished: Long) {
                val set: TreeSet<Int> = TreeSet()
                while(set.size < 6){
                    val num = (Math.random() * 45 + 1).toInt()
                    set.add(num)
                }
                number1.setText(set.elementAt(0).toString())
                number2.setText(set.elementAt(1).toString())
                number3.setText(set.elementAt(2).toString())
                number4.setText(set.elementAt(3).toString())
                number5.setText(set.elementAt(4).toString())
                number6.setText(set.elementAt(5).toString())

            }
        }

        lotteryButton.setOnClickListener {
            if (lotteryButton.isAnimating){
                lotteryButton.cancelAnimation()
                countDownTimer.cancel()
            }else{
                lotteryButton.playAnimation()
                countDownTimer.start()
            }

        }
    }
}