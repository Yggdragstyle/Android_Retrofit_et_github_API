package test.ygg.life.sqliteprojet

import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.*

/**
 * Created by Ygg on 04/12/2017.
 */
class ScoreDb(private val scoreDbHelper: ScoreDbHelper = ScoreDbHelper.instance) {

    fun requestScores() = scoreDbHelper.use {
        select(MainActivity.ScoreTable.NAME,
                MainActivity.ScoreTable.PSEUDO, MainActivity.ScoreTable.SCORE)
                .parseList(classParser<Score>())
    }
    private fun saveScore(pseudo: String, score: Int) = scoreDbHelper.use {
        insert(
            MainActivity.ScoreTable.NAME,
            MainActivity.ScoreTable.PSEUDO to pseudo,
            MainActivity.ScoreTable.SCORE to score
        )
    }
    fun saveScores(scoreList: List<Score>) {

        print("saveScores run... @Yggdragstyle")

        for (s in scoreList) {

            print("$s @Yggdragstyle")
            saveScore(s.pseudo, s.score)
        }
    }
}
