package setup.volley.android.youtubeapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class StandAlone extends ActionBarActivity
    implements View.OnClickListener
{


    private String GOOGLE_API_KEY ="AIzaSyBns4VsOw5qzvWGJyC4RnLLwvDJihtOJAI";
    private String YOUTUBE_VIDEO_ID ="xxx3Fn7EowU";
    private String YOUTUBE_PLAYLIST ="TBA";
    private Button btnPlayVideo, btnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_alone);

        btnPlayVideo = (Button)findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button)findViewById(R.id.btnPlayList);

       btnPlayVideo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });

        btnPlayPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stand_alone, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
