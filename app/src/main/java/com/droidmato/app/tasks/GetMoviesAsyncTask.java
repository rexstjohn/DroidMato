package com.droidmato.app.tasks;

import android.os.AsyncTask;
import android.util.ArrayMap;

import com.droidmato.app.models.MovieContainerModel;
import com.droidmato.app.queries.GetMoviesQueryModel;
import com.droidmato.app.utilities.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Rex St. John on 3/30/14.
 */
public class GetMoviesAsyncTask extends AsyncTask<GetMoviesQueryModel, Long, MovieContainerModel> {

        private static final String ENDPOINT = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?apikey=";
        private static final String API_KEY = "XXXXXXX";
        public GetMoviesAsyncTaskResponse delegate=null;

        protected MovieContainerModel doInBackground(GetMoviesQueryModel... params) {
            try {
                String apiPath = ENDPOINT + API_KEY;
                GetMoviesQueryModel query = (GetMoviesQueryModel)params[0];

                // prepare the json call
                Gson gson = new GsonBuilder().create();
                Map<String,String> queryMap = new HashMap<String, String>(3);
                queryMap.put("country",query.getCountry());
                queryMap.put("page",String.valueOf(query.getPage()));
                queryMap.put("page_limit",String.valueOf(query.getPage_limit()));
                apiPath = HttpRequest.append(apiPath,queryMap);
                HttpRequest request = HttpRequest.get(apiPath);
                MovieContainerModel movieContainerModel = null;

                if (request.ok()) {
                    String jsonResultString = request.body();
                    movieContainerModel = gson.fromJson(jsonResultString, MovieContainerModel.class);
                }

                return movieContainerModel;
            } catch (HttpRequest.HttpRequestException exception) {
                return null;
            }
        }

        protected void onProgressUpdate(Long... progress) {
            // Update!
        }

        protected void onPostExecute(MovieContainerModel movieContainerModel) {
            if(movieContainerModel != null){
                delegate.onRegisterDeviceAsyncTaskCompletion(movieContainerModel);
            } else {
                delegate.onRegisterDeviceAsyncTaskFailure();
            }
        }

        /**
         * AsyncTask response Interface
         */
        public interface GetMoviesAsyncTaskResponse {
            void onRegisterDeviceAsyncTaskCompletion(MovieContainerModel result);
            void onRegisterDeviceAsyncTaskFailure();
        }
    }
