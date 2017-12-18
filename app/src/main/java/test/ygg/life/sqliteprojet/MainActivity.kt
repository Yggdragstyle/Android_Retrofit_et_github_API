package test.ygg.life.sqliteprojet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MyApp.instance

//        var allScore: List<Score> = List<Score>
//
//            allScore.add()

        val scoreDb = ScoreDb()

        var allScore: List<Score> = mutableListOf(

            Score("toto", 52),
            Score("titi", 102),
            Score("tutu", 23),
            Score("tata", 14)
        )

        println("M A I N >>>   here   @Yggdragstyle")


        thread {
            scoreDb.saveScores(allScore)
            println("R E Q U E T E >>>   here   @Yggdragstyle")
        }

//        thread {
//
//        }
//


        doAsync {

//            print("doAsync 1... @Yggdragstyle")

            scoreDb.saveScores(allScore)
            onComplete { println("R E Q U E T E >>>   here   @Yggdragstyle") }
        }


        doAsync {

//            print("doAsync 2... @Yggdragstyle")

            val reponse = scoreDb.requestScores()
            onComplete { println("R E P O N S E >>>   here   @Yggdragstyle") }

//            println( reponse )
        }



    }

    object ScoreTable {
        val NAME = "Score"
        val ID = "_id"
        val PSEUDO = "pseudo"
        val SCORE = "score"
    }

}
