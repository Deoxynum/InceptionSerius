package com.example.sebastianlimaco.inceptionserius.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastianlimaco.inceptionserius.ItemModel.TrendModel;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.Trend.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrendAdapter extends RecyclerView.Adapter<TrendAdapter.ViewHolderTA> {

    private ArrayList<TrendModel> alDataset;
    private Context ctvContext;
    private final OnItemClickListener otclListener;

    public TrendAdapter(Context context, ArrayList<TrendModel> dataSet, OnItemClickListener itemListener){
        alDataset = dataSet;
        ctvContext = context;
        otclListener = itemListener;
    }

    @Override
    public TrendAdapter.ViewHolderTA onCreateViewHolder(ViewGroup parent, int i) {
        View vwItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_rvw_trend, parent, false);
        ViewHolderTA vwhViewHolderTA = new ViewHolderTA(vwItem);
        return vwhViewHolderTA;
    }


    public static class ViewHolderTA extends RecyclerView.ViewHolder {
        TextView tvwTitle;
        TextView tvwViewDes;
        ImageView ivwImageThumb;

        public ViewHolderTA(View itemView) {
            super(itemView);

            tvwTitle = itemView.findViewById(R.id.tvwTitleTA);
            tvwViewDes = itemView.findViewById(R.id.tvwDescriptionTA);
            ivwImageThumb = itemView.findViewById(R.id.ivwImageThumbTA);
        }
        // have to check out bind

        //chosing special OnClickListener instead of standart (was causing problemsa because it wasn't
        public void bind(final TrendModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }



    @Override
    public void onBindViewHolder(TrendAdapter.ViewHolderTA viewHolderTA, int i) {
        //setting up the views
        TextView tvwTitle = viewHolderTA.tvwTitle;
        TextView tvwViewDes = viewHolderTA.tvwViewDes;
        ImageView ivwImageThumb = viewHolderTA.ivwImageThumb;

        TrendModel object = alDataset.get(i);

        tvwTitle.setText(object.getSvTitle());
        tvwViewDes.setText(object.getSvDescription());

        viewHolderTA.bind(alDataset.get(i), otclListener);

        //TODO: picasso missing
        Picasso.with(ctvContext).load(object.getSvThumbnailMediumURL()).into(ivwImageThumb);

    }

    @Override
    public int getItemCount() {
        return alDataset.size();
    }
}
