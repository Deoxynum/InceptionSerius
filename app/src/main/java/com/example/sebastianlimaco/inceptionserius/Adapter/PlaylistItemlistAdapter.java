package com.example.sebastianlimaco.inceptionserius.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastianlimaco.inceptionserius.ItemModel.PlaylistItemlistModel;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.Music_Preview_ItemlistFragment.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistItemlistAdapter extends RecyclerView.Adapter<PlaylistItemlistAdapter.ViewHolderIF> {
    private static final String TAG = "PlaylistItemlistAdapter";

    private ArrayList<PlaylistItemlistModel> alDataset;
    private Context ctvContext;
    private OnItemClickListener oiclListener;

    public PlaylistItemlistAdapter(Context context, ArrayList<PlaylistItemlistModel> dataSet, OnItemClickListener listener){
        alDataset = dataSet;
        ctvContext = context;
        oiclListener = listener;
    }

    @Override
    public PlaylistItemlistAdapter.ViewHolderIF onCreateViewHolder(ViewGroup parent, int i) {
        View vwItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_rvw_itemlist, parent, false);
        ViewHolderIF vwhViewHolderPF = new ViewHolderIF(vwItem);
        return vwhViewHolderPF;
    }

    public static class ViewHolderIF extends RecyclerView.ViewHolder {
        TextView tvwTitle;
        ImageView ivwImageThumb;

        public ViewHolderIF(View itemView) {
            super(itemView);

            tvwTitle = itemView.findViewById(R.id.tvwTitleIF);
            ivwImageThumb = itemView.findViewById(R.id.ivwImageThumbIF);
        }
        public void bind(final PlaylistItemlistModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(PlaylistItemlistAdapter.ViewHolderIF viewHolderIF, int i) {
        TextView tvwTitle = viewHolderIF.tvwTitle;
        ImageView ivwImageThumb = viewHolderIF.ivwImageThumb;

        PlaylistItemlistModel object = alDataset.get(i);

        viewHolderIF.bind(alDataset.get(i), oiclListener);

        tvwTitle.setText(object.getSvTitle());
        Picasso.with(ctvContext).load(object.getSvThumbnailURL()).into(ivwImageThumb);
    }

    @Override
    public int getItemCount() {
        return alDataset.size();
    }
}
