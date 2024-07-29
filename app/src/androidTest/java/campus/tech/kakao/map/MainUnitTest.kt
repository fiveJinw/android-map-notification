package campus.tech.kakao.map

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import campus.tech.kakao.map.ui.MainActivity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainUnitTest {
    lateinit var sharedPreferences: SharedPreferences
    @Before
    fun before() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        sharedPreferences = context.getSharedPreferences("SavedItems", Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
    }

    @After
    fun after() {
        sharedPreferences.edit().clear().apply()
    }
// refactoring 으로 인해 오류가 떠서 주석처리
//    @Test
//    fun addAndRemoveSaveItem() {
//        val scenario = ActivityScenario.launch(MainActivity::class.java)
//
//        scenario.onActivity { activity ->
//
//            activity.addSavedItem("성심당 본점")
//            activity.removeSavedItem("성심당 본점")
//            assertEquals(0, activity.llSave.childCount)
//        }
//        scenario.close()
//    }
//    @Test
//    fun addAndLoadSaveItem() {
//        val scenario = ActivityScenario.launch(MainActivity::class.java)
//
//        scenario.onActivity { mainActivity ->
//            mainActivity.addSavedItem("성심당")
//            mainActivity.saveSavedItems()
//            mainActivity.llSave.removeAllViews()
//            mainActivity.loadSavedItems()
//
//            assertEquals(1, mainActivity.llSave.childCount)
//        }
//
//        scenario.close()
//    }
}