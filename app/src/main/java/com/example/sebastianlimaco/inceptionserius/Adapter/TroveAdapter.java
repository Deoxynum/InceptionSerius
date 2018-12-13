package com.example.sebastianlimaco.inceptionserius.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastianlimaco.inceptionserius.ItemModel.TroveVideoModel;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.Music_TroveFragment.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TroveAdapter extends RecyclerView.Adapter<TroveAdapter.ViewHolderTF> {

    private ArrayList<TroveVideoModel> alDataset;
    private Context ctvContext;
    private final OnItemClickListener otclListener;


    public TroveAdapter(Context context, ArrayList<TroveVideoModel> dataSet, OnItemClickListener itemListener){
        alDataset = dataSet;
        ctvContext = context;
        otclListener = itemListener;
    }

    @Override
    public TroveAdapter.ViewHolderTF onCreateViewHolder(ViewGroup parent, int i) {
        View vwItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_rvw_trove, parent, false);
        ViewHolderTF vwhViewHolderTF = new ViewHolderTF(vwItem);
        return vwhViewHolderTF;
    }

    public static class ViewHolderTF extends RecyclerView.ViewHolder {
        TextView tvwTitle;
        TextView tvwViewDes;
        ImageView ivwImageThumb;

        public ViewHolderTF(View itemView) {
            super(itemView);

            tvwTitle = itemView.findViewById(R.id.tvwTitleTF);
            tvwViewDes = itemView.findViewById(R.id.tvwViewDesTF);
            ivwImageThumb = itemView.findViewById(R.id.ivwImageThumbTF);
        }
        // have to check out bind

        //chosing special OnClickListener instead of standart (was causing problemsa because it wasn't
        public void bind(final TroveVideoModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }


    @Override
    public void onBindViewHolder(@NonNull TroveAdapter.ViewHolderTF viewHolderTF, int i) {
        //setting up the views
        TextView tvwTitle = viewHolderTF.tvwTitle;
        TextView tvwViewDes = viewHolderTF.tvwViewDes;
        ImageView ivwImageThumb = viewHolderTF.ivwImageThumb;

        TroveVideoModel object = alDataset.get(i);

        tvwTitle.setText(object.getSvTitle());
        tvwViewDes.setText(object.getSvTitle());

        viewHolderTF.bind(alDataset.get(i), otclListener);

        Picasso.with(ctvContext).load(object.getSvThumbnailURL()).into(ivwImageThumb);
    }

    @Override
    public int getItemCount() { return alDataset.size(); }
}
