package id.nindy.nindy2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private SetEvents setEvents;
    private List<Movie> movieList;
    private Context context;

    public interface SetEvents{
        void onItemClick(Movie movie);
    }

    public MovieAdapter(Context context, @NonNull List<Movie> movieList, SetEvents setEvents) {
        this.setEvents = setEvents;
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Movie movie = movieList.get(i);
        viewHolder.bind(movie, setEvents);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private ImageView moviePoster;
        private TextView movieName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.iMovie_card);
            moviePoster = itemView.findViewById(R.id.iMovie_poster);
            movieName = itemView.findViewById(R.id.iMovie_name);
        }

        public void bind(final Movie movie, final SetEvents setEvents) {
            moviePoster.setImageResource(movie.getPoster());
            movieName.setText(movie.getName());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setEvents.onItemClick(movie);
                }
            });
        }
    }
}
