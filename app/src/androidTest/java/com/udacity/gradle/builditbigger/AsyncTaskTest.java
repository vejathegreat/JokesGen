package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;



@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTask() throws InterruptedException, ExecutionException {
        final CountDownLatch count = new CountDownLatch(1);
        EndpointsAsyncTask jokeTask = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertThat(result, not(isEmptyOrNullString()));
                count.countDown();
            }
        };
        jokeTask.execute();
        count.await();

        String jokeString = jokeTask.get();
        assertNotNull(jokeString);
    }

}
