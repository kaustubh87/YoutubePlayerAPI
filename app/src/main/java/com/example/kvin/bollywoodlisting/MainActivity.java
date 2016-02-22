package com.example.kvin.bollywoodlisting;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Data.CustomListViewAdapter;
import Model.Movie;

public class MainActivity extends AppCompatActivity {



    private String url = "https://api.cinemalytics.com/v1/movie/upcoming?auth_token=8FD6E7B756BA7FB39EB82C99A4B570F0";

    private CustomListViewAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list);
        adapter = new CustomListViewAdapter(MainActivity.this,R.layout.list_row,movies);
        listView.setAdapter(adapter);




        JsonArrayRequest arrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
         @Override
         public void onResponse(JSONArray response) {
             for(int i=0;i<response.length();i++) {
                 try {
                     JSONObject jsonObject = response.getJSONObject(i);
                     String title = jsonObject.getString("Title");
                     //Log.v("Title is ", title);
                     String description = jsonObject.getString("Description");
                     Log.v("Description is ", description);
                     String imageUrl = jsonObject.getString("PosterPath");
                     Log.v("ImageUrl is " ,imageUrl);
                     String releaseDate = jsonObject.getString("ReleaseDate");
                     Log.v("Relase Date is" ,releaseDate);
                     String genre = jsonObject.getString("Genre");
                     Log.v("Genre ",genre);

                     String yurl = jsonObject.getString("TrailerLink");
                     Log.v("Yurl is " ,yurl);


                     Movie movie = new Movie();
                     movie.setTitle(title);
                     movie.setDescription(description);
                     movie.setReleaseDate(releaseDate);
                     movie.setGenre(genre);
                     movie.setThumbnail(imageUrl);
                     movie.setYurl(yurl);



                     movies.add(movie);


                     adapter.notifyDataSetChanged();

                 }





                 catch (JSONException e) {
                     e.printStackTrace();
                 }

             }


         }
     }, new Response.ErrorListener() {
         @Override
         public void onErrorResponse(VolleyError error) {

         }
     });


        AppController.getInstance().addToRequestQueue(arrayRequest);


    }
}
