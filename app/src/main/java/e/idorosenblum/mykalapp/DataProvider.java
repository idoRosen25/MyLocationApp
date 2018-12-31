package e.idorosenblum.mykalapp;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import e.idorosenblum.mykalapp.interfaces.IPlacesDataReceived;
import e.idorosenblum.mykalapp.models.LocationModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataProvider {

    private ArrayList<LocationModel> mLocationModels;

    public void getPlacesByLocation(double lat, double lng, IPlacesDataReceived resultListener_) {

        GetPlacesByLocationAsyncTask getPlacesByLocationAsyncTask=new GetPlacesByLocationAsyncTask(resultListener_);
        getPlacesByLocationAsyncTask.execute(lat,lng);

    }

    public class GetPlacesByLocationAsyncTask extends AsyncTask<Double, Integer, IPlacesDataReceived> {


        private IPlacesDataReceived mIPlacesDataReceived;

        public GetPlacesByLocationAsyncTask(IPlacesDataReceived iPlacesDataReceived){
            mIPlacesDataReceived=iPlacesDataReceived;
        }


        @Override
        protected IPlacesDataReceived doInBackground(Double... doubles) {

            OkHttpClient client = new OkHttpClient();
            String urlQuery = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=32.029252,%2034.7425159&radius=1500&key=AIzaSyDc7oNJ8FQZc6xmDVEvj-vewU5-ohnlwR0";
            Request request = new Request.Builder()
                    .url(urlQuery)
                    .build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!response.isSuccessful()) try {
                throw new IOException("Unexpected code " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                mLocationModels = getLocationListFromJson(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return mIPlacesDataReceived;

        }

        @Override
        protected void onPostExecute(IPlacesDataReceived iPlacesDataReceived) {
            iPlacesDataReceived.onPlacesDataReceived();
        }

        public ArrayList<LocationModel> getLocationListFromJson(String jsonResponse) {
            List<LocationModel> stubLocationData;
            Gson gson = new GsonBuilder().create();
            LocationResponse response = gson.fromJson(jsonResponse, LocationResponse.class);
            stubLocationData = response.results;
            ArrayList<LocationModel> arrList = new ArrayList<>();
            arrList.addAll(stubLocationData);
            return arrList;
        }
    }

    public class LocationResponse {

        private List<LocationModel> results;

        // public constructor is necessary for collections
        public LocationResponse() {
            results = new ArrayList<LocationModel>();
        }

    }

    public ArrayList<LocationModel> getLocationList(){
        return mLocationModels;
    }
}
