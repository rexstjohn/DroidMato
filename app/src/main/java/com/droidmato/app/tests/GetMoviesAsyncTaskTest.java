/*
 * CONFIDENTIAL
 *
 *  Copyright Phriz.be (c) 2014.
 *  NOTICE:  All information contained herein is, and remains
 *  the property of Phriz.be. The intellectual and technical concepts contained
 *  herein are proprietary to Phriz.be and may be covered by U.S. and Foreign Patents,
 *  patents in process, and are protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material
 *  is strictly forbidden unless prior written permission is obtained
 *  from Phriz.be.
 */

package com.droidmato.app.tests;

import android.content.Context;
import android.location.Location;
import android.test.InstrumentationTestCase;

import com.droidmato.app.models.MovieContainerModel;
import com.droidmato.app.queries.GetMoviesQueryModel;
import com.droidmato.app.tasks.GetMoviesAsyncTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rex St John on 1/24/14.
 */
public class GetMoviesAsyncTaskTest extends InstrumentationTestCase{

    public void test() throws Throwable{

        final Context context = getInstrumentation().getTargetContext();
        final CountDownLatch signal = new CountDownLatch(1);
        final NetworkTest networkTest = new NetworkTest(context, new GetMoviesCallbackListener(signal));

        runTestOnUiThread(new Runnable() {
            public void run() {
                networkTest.getMoviesInAmericaTest();
            }
        });

        signal.await(30, TimeUnit.SECONDS);
    }

    /**
     * Use this to intercept the intended response from the AsyncTask
     */
    private class GetMoviesCallbackListener implements GetMoviesAsyncTask.GetMoviesAsyncTaskResponse{
        private CountDownLatch signal;

        public GetMoviesCallbackListener(CountDownLatch signal){
            this.signal = signal;
        }

        @Override
        public void onRegisterDeviceAsyncTaskCompletion(MovieContainerModel result) {
            assertNotNull(result);
            assertNotNull(result.getLink_template());
            assertNotNull(result.getLinks());
            assertTrue(result.getTotal() > 0);
            assertTrue(result.getMovies().size() > 0);
            signal.countDown();
        }

        @Override
        public void onRegisterDeviceAsyncTaskFailure() {
            fail();
            signal.countDown();
        }
    }

    /**
     * Test nearby device async task operations.
     * @param context
     * @param listener
     */
    private class NetworkTest{

        private Context context;
        private GetMoviesCallbackListener listener;

        public NetworkTest(Context context,GetMoviesCallbackListener listener ){
            this.context = context;
            this.listener = listener;
        }

        public void getMoviesInAmericaTest(){
            GetMoviesQueryModel moviesQueryModel = new GetMoviesQueryModel();
            moviesQueryModel.setCountry("us");
            moviesQueryModel.setPage(1);
            moviesQueryModel.setPage_limit(10);
            GetMoviesAsyncTask nearbyDevicesTask = new GetMoviesAsyncTask();
            nearbyDevicesTask.delegate = listener;
            nearbyDevicesTask.execute(moviesQueryModel);
        }
    }
}