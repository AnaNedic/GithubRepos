package com.mraper.org.trendingreposlist;

import android.content.Intent;

import com.mraper.org.trendingreposlist.presenter.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static junit.framework.TestCase.assertNotNull;

public class PresenterTests {
    @Rule
    public ActivityTestRule<MainActivity> presenterTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testDataManagerInitializedSuccessfully(){
        Intent intent = new Intent();
        MainActivity activity = presenterTestRule.launchActivity(intent);
        assertNotNull(activity.getDataManager());
    }
}
