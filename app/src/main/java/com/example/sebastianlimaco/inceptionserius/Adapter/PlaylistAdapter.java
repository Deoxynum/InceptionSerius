package com.example.sebastianlimaco.inceptionserius.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastianlimaco.inceptionserius.ItemModel.PlaylistModel;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.Music_PlaylistFragment.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolderPF> {

    private ArrayList<PlaylistModel> alDataset;
    private Context ctvContext;
    private final OnItemClickListener oiclListener;

    public PlaylistAdapter(Context context, ArrayList<PlaylistModel> dataSet, OnItemClickListener itemListener){
        alDataset = dataSet;
        ctvContext = context;
        oiclListener = itemListener;
    }

    @Override
    public PlaylistAdapter.ViewHolderPF onCreateViewHolder(ViewGroup parent, int i) {
        View vwItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_rvw_playlist, parent, false);
        ViewHolderPF vwhViewHolderPF = new ViewHolderPF(vwItem);
        return vwhViewHolderPF;
    }

    public static class ViewHolderPF extends RecyclerView.ViewHolder {
        TextView tvwTitle;
        TextView tvwViewDes;
        ImageView ivwImageThumb;

        public ViewHolderPF(View itemView) {
            super(itemView);

            tvwTitle = itemView.findViewById(R.id.tvwTitlePF);
            tvwViewDes = itemView.findViewById(R.id.tvwViewDesPF);
            ivwImageThumb = itemView.findViewById(R.id.ivwImageThumbPF);
        }
        // have to check out bind

        //chosing special OnClickListener instead of standart (was causing problemsa because it wasn't
        public void bind(final PlaylistModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(PlaylistAdapter.ViewHolderPF viewHolderPF, int i) {
        TextView tvwTitle = viewHolderPF.tvwTitle;
        TextView tvwViewDes = viewHolderPF.tvwViewDes;
        ImageView ivwImageThumb = viewHolderPF.ivwImageThumb;

        PlaylistModel object = alDataset.get(i);

        tvwTitle.setText(object.getSvTitle());
        tvwViewDes.setText(object.getSvDescription());

        viewHolderPF.bind(alDataset.get(i), oiclListener);

        Picasso.with(ctvContext).load(object.getSvThumbnailURL()).into(ivwImageThumb);
    }

    @Override
    public int getItemCount() {
        return alDataset.size();
    }
}
