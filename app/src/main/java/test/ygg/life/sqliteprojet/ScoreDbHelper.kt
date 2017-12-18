package test.ygg.life.sqliteprojet

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Ygg on 04/12/2017.
 */
class ScoreDbHelper(ctx: Context = MyApp.instance) : ManagedSQLiteOpenHelper(ctx,
        ScoreDbHelper.DB_NAME, null, ScoreDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance by lazy { ScoreDbHelper() }
    }


    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
                MainActivity.ScoreTable.NAME, true,
                MainActivity.ScoreTable.ID to INTEGER + PRIMARY_KEY,
                MainActivity.ScoreTable.PSEUDO to TEXT,
                MainActivity.ScoreTable.SCORE to INTEGER
        )
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(MainActivity.ScoreTable.NAME, true)
        onCreate(db)
    }
}