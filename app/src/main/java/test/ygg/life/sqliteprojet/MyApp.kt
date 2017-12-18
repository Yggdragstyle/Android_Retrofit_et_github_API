package test.ygg.life.sqliteprojet

import android.app.Application

/**
 * Created by Ygg on 04/12/2017.
 */
class MyApp : Application() {

    companion object {
//        lateinit var instance: MyApp
        val instance by lazy { MyApp() }
    }
}
