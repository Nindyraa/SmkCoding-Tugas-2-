package id.nindy.nindy2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView moviePoster;
    private TextView movieName, movieDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        moviePoster = findViewById(R.id.movieDetailImage);
        movieName = findViewById(R.id.movieDetailName);
        movieDesc = findViewById(R.id.movieDetailDesc);

        if (getIntent() != null){
            if (getIntent().hasExtra("movie")){
                Movie movie = getIntent().getParcelableExtra("movie");

                if (getSupportActionBar() != null){
                    getSupportActionBar().setTitle(movie.getName());
                }

                moviePoster.setImageResource(movie.getPoster());
                movieName.setText(movie.getName());
                movieDesc.setText(movie.getDescription());
            }
        }
    }
}
