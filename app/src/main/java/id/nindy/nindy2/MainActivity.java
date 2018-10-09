package id.nindy.nindy2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import id.nindy.nindy2.Movie;
import id.nindy.nindy2.MovieAdapter;
import id.nindy.nindy2.MovieDetailActivity;
import id.nindy.nindy2.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Movie List");
        }

        recyclerView = findViewById(R.id.mainRecycler);

        movieList = new ArrayList<>();
        movieList.add(new Movie(R.drawable.dimass, "Dimas Anggara", "Wajah ganteng Dimas Anggara cukup sering wira wiri dilayar kaca.\n" + "\n" + "Beberapa judul film dan sinetron pun sempat dibintanginya ditahun 2016 kemarin.\n" + "\n" + "Karirnya pun kini semakin cemerlang, tapi bagaimana dengan kisah asmaranya ya?\n" + "\n" + "Baru-baru ini, Dimas Anggara sempat dikabarkan menjalin kedekatan dengan Nadine Chandrawinata.\n"));
        movieList.add(new Movie(R.drawable.aliando, "Aliando", "Nama Aliando semakin dikenal setelah dirinya membintangi sinetron Ganteng-ganteng Serigala.\n" + "\n" + "Kini Aliando mulai melebarkan sayapnya dengan mencoba dunia tarik suara.\n" + "\n" + "Meski pernah dikabarkan dekat dengan Prilly Latuconsina, tampaknya artis berusia 20 tahun ini masih belum memiliki kekasih.\n"));
        movieList.add(new Movie(R.drawable.devaa, "Deva Mahendra", "Artis ganteng satu ini juga termasuk sosok yang multitalenta.\n" + "\n" + "Mulai dari akting, presenter, hingga menyanyi pun dikuasainya.\n" + "\n" + "Nggak heran kalau Deva diidolakan banyak kaum hawa.\n" + "\n" + "Artis berusia 26 tahun tampaknya juga belom terlihat menggandeng seorang kekasih loh!\n"));
        movieList.add(new Movie(R.drawable.amarr, "Amar Zoni", "Nama Ammar Zoni mulai dikenal setelah dirinya ikut menyumbangkan kemampuan aktingnya dalam sinetron 7 Manusia Harimau.\n" + "\n" + "Kini namanya menjadi semakin dikenal setelah membintangi beberapa judul sinetron.\n" + "\n" + "2016 bisa dibilang menjadi tahun yang cukup cemerlang bagi aktor berusia 23 tahun ini.\n" + "\n" + "Namun sayang, cowok ganteng satu ini sudah punya kekasih yang juga berprofesi sebagai artis, girls!\n"));
        movieList.add(new Movie(R.drawable.boyy, "Boy William", "Artis tampan satu ini bisa dibilang multitalenta.\n" + "\n" + "Tidak heran kalau tahun 2016 kemarin, namanya semakin dikenal.\n" + "\n" + "Berbagai profesi didunia hiburan pun dilibasnya.\n" + "\n" + "Mulai dari akting, menyanyi, presenter, dan lain-lain."));
        movieList.add(new Movie(R.drawable.dimass, "Dimas Anggara", "Wajah ganteng Dimas Anggara cukup sering wira wiri dilayar kaca.\n" + "\n" + "Beberapa judul film dan sinetron pun sempat dibintanginya ditahun 2016 kemarin.\n" + "\n" + "Karirnya pun kini semakin cemerlang, tapi bagaimana dengan kisah asmaranya ya?\n" + "\n" + "Baru-baru ini, Dimas Anggara sempat dikabarkan menjalin kedekatan dengan Nadine Chandrawinata.\n"));
        movieList.add(new Movie(R.drawable.aliando, "Aliando", "Nama Aliando semakin dikenal setelah dirinya membintangi sinetron Ganteng-ganteng Serigala.\n" + "\n" + "Kini Aliando mulai melebarkan sayapnya dengan mencoba dunia tarik suara.\n" + "\n" + "Meski pernah dikabarkan dekat dengan Prilly Latuconsina, tampaknya artis berusia 20 tahun ini masih belum memiliki kekasih.\n"));
        movieList.add(new Movie(R.drawable.devaa, "Deva Mahendra", "Artis ganteng satu ini juga termasuk sosok yang multitalenta.\n" + "\n" + "Mulai dari akting, presenter, hingga menyanyi pun dikuasainya.\n" + "\n" + "Nggak heran kalau Deva diidolakan banyak kaum hawa.\n" + "\n" + "Artis berusia 26 tahun tampaknya juga belom terlihat menggandeng seorang kekasih loh!\n"));
        movieList.add(new Movie(R.drawable.amarr, "Amar Zoni", "Nama Ammar Zoni mulai dikenal setelah dirinya ikut menyumbangkan kemampuan aktingnya dalam sinetron 7 Manusia Harimau.\n" + "\n" + "Kini namanya menjadi semakin dikenal setelah membintangi beberapa judul sinetron.\n" + "\n" + "2016 bisa dibilang menjadi tahun yang cukup cemerlang bagi aktor berusia 23 tahun ini.\n" + "\n" + "Namun sayang, cowok ganteng satu ini sudah punya kekasih yang juga berprofesi sebagai artis, girls!\n"));
        movieList.add(new Movie(R.drawable.boyy, "Boy William", "Artis tampan satu ini bisa dibilang multitalenta.\n" + "\n" + "Tidak heran kalau tahun 2016 kemarin, namanya semakin dikenal.\n" + "\n" + "Berbagai profesi didunia hiburan pun dilibasnya.\n" + "\n" + "Mulai dari akting, menyanyi, presenter, dan lain-lain."));


        MovieAdapter movieAdapter = new MovieAdapter(MainActivity.this, movieList, new MovieAdapter.SetEvents() {
            @Override
            public void onItemClick(Movie movie) {
                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra("movie", movie);
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(movieAdapter);
    }
}
