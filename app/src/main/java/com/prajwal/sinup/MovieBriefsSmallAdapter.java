package com.prajwal.sinup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.prajwal.sinup.network.movies.MovieBrief;

import java.util.List;

/**
 * Created by prajwal on 21/12/17.
 */

public class MovieBriefsSmallAdapter extends RecyclerView.Adapter<MovieBriefsSmallAdapter.MovieViewHolder> {
    private Context mContext;
    private List<MovieBrief> mMovies;

    public MovieBriefsSmallAdapter(Context context, List<MovieBrief> movies) {
        mContext = context;
        mMovies = movies;
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_show_small, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Glide.with(mContext.getApplicationContext()).load(Constant.IMAGE_LOADING_BASE_URL_342 + mMovies.get(position).getPosterPath())
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.moviePosterImageView);

        if (mMovies.get(position).getTitle() != null)
            holder.movieTitleTextView.setText(mMovies.get(position).getTitle());
        else
            holder.movieTitleTextView.setText("");



    }

    @Override
    public int getItemCount() {
        return mMovies.size();    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public CardView movieCard;
        public ImageView moviePosterImageView;
        public TextView movieTitleTextView;
        public ImageButton movieFavImageButton;


        public MovieViewHolder(View itemView) {
            super(itemView);
            movieCard = (CardView) itemView.findViewById(R.id.card_view_show_card);
            moviePosterImageView = (ImageView) itemView.findViewById(R.id.image_view_show_card);
            movieTitleTextView = (TextView) itemView.findViewById(R.id.text_view_title_show_card);
            movieFavImageButton = (ImageButton) itemView.findViewById(R.id.image_button_fav_show_card);

            moviePosterImageView.getLayoutParams().width = (int) (mContext.getResources().getDisplayMetrics().widthPixels * 0.31);
            moviePosterImageView.getLayoutParams().height = (int) ((mContext.getResources().getDisplayMetrics().widthPixels * 0.31) / 0.66);

            movieCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

            movieFavImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    movieFavImageButton.setImageResource(R.mipmap.ic_favorite_black_18dp);
                    movieFavImageButton.setEnabled(false);
                }
            });
        }
    }
}