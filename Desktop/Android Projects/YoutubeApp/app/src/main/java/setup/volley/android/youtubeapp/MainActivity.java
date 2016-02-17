package setup.volley.android.youtubeapp;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class MainActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private String GOOGLE_API_KEY ="AIzaSyBns4VsOw5qzvWGJyC4RnLLwvDJihtOJAI";
    private String YOUTUBE_VIDEO_ID ="xxx3Fn7EowU";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY,this);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        Toast.makeText(this, "Initialized Youtube Player Successfully", Toast.LENGTH_LONG).show();
        youTubePlayer.setPlayerStateChangeListener(playerStateChangedListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        if(!wasRestored){

            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);

        }

    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

            Toast.makeText(MainActivity.this," Video is playing " ,Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(MainActivity.this," Video is paused " ,Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    YouTubePlayer.PlayerStateChangeListener playerStateChangedListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

            Toast.makeText(MainActivity.this," Click Ad now " ,Toast.LENGTH_LONG).show();

        }

        @Override
        public void onVideoStarted() {

            Toast.makeText(MainActivity.this," Video has started " ,Toast.LENGTH_LONG).show();

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(this,"Initialized Youtube Player Failed" ,Toast.LENGTH_LONG).show();

    }
}
