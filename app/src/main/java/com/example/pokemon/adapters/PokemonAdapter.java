package com.example.pokemon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.pokemon.R;
import com.example.pokemon.pojo.Pokemon;
import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
     ArrayList<Pokemon> pokemonList = new ArrayList();
     Context mContext;

    public PokemonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.pokemonTextView.setText(pokemonList.get(position).getName());
        System.out.println(pokemonList.get(position).getName());

        Glide.with(mContext).load(pokemonList.get(position).getUrl())
                .into(holder.pokemonImageView);
    }
    public Pokemon getPokemonAt(int position){
        return pokemonList.get(position);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void setList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {

        ImageView pokemonImageView;
        TextView pokemonTextView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonImageView = itemView.findViewById(R.id.Image);
            pokemonTextView = itemView.findViewById(R.id.textView);
        }
    }
}