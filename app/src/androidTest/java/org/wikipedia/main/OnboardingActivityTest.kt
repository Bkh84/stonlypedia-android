package org.wikipedia.main


import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.karumi.shot.ScreenshotTest
import com.stonly.stonly.R
import com.stonly.stonly.core.utils.decorView
import org.junit.Rule
import org.junit.Test
import org.wikipedia.onboarding.InitialOnboardingActivity

class OnboardingActivityTest : ScreenshotTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(InitialOnboardingActivity::class.java)


    @Test
    fun triggers() {
        var activity: InitialOnboardingActivity? = null
        activityScenarioRule.scenario.onActivity {
            activity = it
        }
        val triggers = activity?.decorView()?.findViewById<View>(com.stonly.stonly.R.id.stonly_trigger_container)
        compareScreenshot(triggers!!)
    }

    @Test
    fun bottomSheet() {
        var activity: InitialOnboardingActivity? = null
        var widgetContainer: View? = null

        activityScenarioRule.scenario.onActivity {
            activity = it
            val triggers = activity?.decorView()?.findViewById<View>(com.stonly.stonly.R.id.stonly_trigger_container)
            val pill = triggers?.findViewById<View>(com.stonly.stonly.R.id.stonly_pill_id)
            pill!!.performClick()

            widgetContainer = activity?.decorView()?.findViewById<View>(com.stonly.stonly.R.id.stonly_widget_container)
        }
        activity?.findViewById<View>(org.wikipedia.R.id.fragment_onboarding_pager_container)?.isVisible = false
        Thread.sleep(10000)
        compareScreenshot(widgetContainer!!)

    }

    @Test
    fun modal() {
        var activity: InitialOnboardingActivity? = null
        var widgetContainer: View? = null
        activityScenarioRule.scenario.onActivity {
            activity = it
            val triggers = activity?.decorView()?.findViewById<View>(R.id.stonly_trigger_container)
            val banner = triggers?.findViewById<View>(R.id.stonly_banner_id)
            banner!!.performClick()

            widgetContainer = activity?.decorView()?.findViewById<View>(R.id.stonly_widget_container)
        }
        activity?.findViewById<View>(org.wikipedia.R.id.fragment_onboarding_pager_container)?.isVisible = false
        Thread.sleep(10000)
        compareScreenshot(widgetContainer!!)
    }

}
