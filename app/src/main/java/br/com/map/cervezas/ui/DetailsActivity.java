package br.com.map.cervezas.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.squareup.picasso.Picasso;

import br.com.map.cervezas.R;
import br.com.map.cervezas.ui.news.DetailsViewModel;

public class DetailsActivity extends AppCompatActivity {
    private DetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        //muestra en pactalla el detalle del registro seleccionado
        Intent intent = getIntent();
        String valornombre = intent.getStringExtra("nombre");
        String valortagline = intent.getStringExtra("tagline");
        String valordescription = intent.getStringExtra("description");
        String valorfirst_brewed = intent.getStringExtra("first_brewed");
        String valorbrewers_tips = intent.getStringExtra("brewers_tips");
        String valorcontributed_by = intent.getStringExtra("contributed_by");
        String valorimage_url = intent.getStringExtra("image_url");

        TextView CervezaNombre = findViewById(R.id.name);
        TextView Cervezatagline = findViewById(R.id.tagline);
        TextView Cervezadescription = findViewById(R.id.description);
        TextView Cervezafirst_brewed = findViewById(R.id.first_brewed);
        TextView Cervezabrewers_tips = findViewById(R.id.brewers_tips);
        TextView Cervezacontributed_by = findViewById(R.id.contributed_by);
        ImageView imageView = findViewById(R.id.cerveza);

        Picasso.get().load(valorimage_url).into(imageView);

        CervezaNombre.setText(valornombre);
        Cervezatagline.setText(valortagline);
        Cervezadescription.setText(valordescription);
        Cervezafirst_brewed.setText(valorfirst_brewed);
        Cervezabrewers_tips.setText(valorbrewers_tips);
        Cervezacontributed_by.setText(valorcontributed_by);

    }
}
