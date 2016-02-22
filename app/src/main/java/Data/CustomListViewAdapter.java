package Data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.kvin.bollywoodlisting.AppController;
import com.example.kvin.bollywoodlisting.R;
import com.example.kvin.bollywoodlisting.VideoActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Model.Movie;

/**
 * Created by kvin on 2/15/16.
 */
public class CustomListViewAdapter extends ArrayAdapter<Movie> {

    private LayoutInflater inflater;
    private ArrayList<Movie> data;
    private Activity mContext;
    private int layoutResourceId;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();





    public CustomListViewAdapter(Activity context, int resource, ArrayList<Movie> objs) {
        super(context, resource, objs);
        data = objs;
        mContext = context;
        layoutResourceId = resource;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Movie getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(Movie item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder viewHolder = null;

        if(row == null)
        {
           inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(layoutResourceId, parent, false);
            viewHolder = new ViewHolder();

            // Get References to our views.

            viewHolder.thumbnail = (NetworkImageView) row.findViewById(R.id.image);
            viewHolder.title = (TextView) row.findViewById(R.id.title);
            viewHolder.description = (TextView) row.findViewById(R.id.description);
            viewHolder.releaseDate = (TextView) row.findViewById(R.id.releaseDate);
            viewHolder.genre = (TextView) row.findViewById(R.id.genre);
            viewHolder.url = (TextView)row.findViewById(R.id.video);




            row.setTag(viewHolder);

        }
        else
        {
            viewHolder = (ViewHolder) row.getTag();
        }

        viewHolder.movie = data.get(position);
        viewHolder.title.setText(viewHolder.movie.getTitle());
        viewHolder.description.setText("Description " +viewHolder.movie.getDescription());
        viewHolder.releaseDate.setText("Release Date " +viewHolder.movie.getReleaseDate());
        viewHolder.genre.setText("Genre " + viewHolder.movie.getGenre());
        viewHolder.thumbnail.setImageUrl(viewHolder.movie.getThumbnail(), imageLoader);
        viewHolder.url.setText("Watch Trailer " + viewHolder.movie.getYurl());

        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                intent.putExtra("Url" ,finalViewHolder.movie.getYurl());
                mContext.startActivity(intent);

            }
        });



        return row;
    }


    public class ViewHolder{

        Movie movie;
        TextView title, description, releaseDate, genre;
        NetworkImageView thumbnail;
        TextView url;


    }
}
