package br.com.map.cervezas.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.map.cervezas.R;
import br.com.map.cervezas.databinding.NewsItemBinding;
import br.com.map.cervezas.domain.News;
import br.com.map.cervezas.ui.DetailsActivity;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private List<News> news;
    private NewsListener favoritelistener;


    public NewsAdapter(List<News> news,NewsListener favoritelistener){
        this.news = news;
        this.favoritelistener = favoritelistener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();
        News news  =  this.news.get(position);
        holder.binding.tvtitle.setText(news.name);
        holder.binding.tvdescription.setText(news.tagline);

        // manejar la imagen para mostrar en lista
        Picasso.get()
                .load(news.image_url)
                .fit()
                .into(holder.binding.tvThumbinail);

        //consulta detalle de cervezas
        holder.binding.tvThumbinail.setOnClickListener(view -> {

            Intent i = new Intent(context, DetailsActivity.class);
            i.putExtra("nombre", news.name);
            i.putExtra("tagline", news.tagline);
            i.putExtra("description", news.description);
            i.putExtra("first_brewed", news.first_brewed);
            i.putExtra("brewers_tips", news.brewers_tips);
            i.putExtra("contributed_by", news.contributed_by);
            i.putExtra("image_url", news.image_url);
            context.startActivity(i);


        });

        //guarda un registro seleccionado y lo guarda en room
        holder.binding.ivFavorite.setOnClickListener(view ->{
            news.favorite = !news.favorite;
            this.favoritelistener.onfavorite(news);
            notifyItemChanged(position);
        });

        //cambia de color el icono de favorito
        int favoriteColor = news.favorite ? R.color.star : R.color.fondo;
        holder.binding.ivFavorite.setColorFilter(context.getResources().getColor(favoriteColor));
    }

    @Override
    public int getItemCount() {return this.news.size(); }

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        private final NewsItemBinding binding;

        public ViewHolder(NewsItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

    }


    public interface NewsListener{
        void onfavorite(News news);
    }

}
