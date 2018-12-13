package com.example.sebastianlimaco.inceptionserius.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastianlimaco.inceptionserius.ItemModel.VideoModel;
import com.example.sebastianlimaco.inceptionserius.OnItemClickListenerInterface.OnItemClickListener;
import com.example.sebastianlimaco.inceptionserius.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolderSA> {

    private ArrayList<VideoModel> alDataset;
    private Context ctvContext;
    private final OnItemClickListener otclListener;

    public SearchAdapter(Context context, ArrayList<VideoModel> dataSet, OnItemClickListener itemListener){
        alDataset = dataSet;
        ctvContext = context;
        otclListener = itemListener;
    }

    @Override
    public SearchAdapter.ViewHolderSA onCreateViewHolder(ViewGroup parent, int i) {
        View vwItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_rvw_search, parent, false);
        ViewHolderSA vwhViewHolderSA = new ViewHolderSA(vwItem);
        return vwhViewHolderSA;
    }


    public static class ViewHolderSA extends RecyclerView.ViewHolder {
        TextView tvwTitle;
        TextView tvwViewDes;
        ImageView ivwImageThumb;

        public ViewHolderSA(View itemView) {
            super(itemView);

            tvwTitle = itemView.findViewById(R.id.tvwTitleSA);
            tvwViewDes = itemView.findViewById(R.id.tvwViewDesSA);
            ivwImageThumb = itemView.findViewById(R.id.ivwImageThumbSA);
        }

        public void bind(final VideoModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }



    @Override
    public void onBindViewHolder(SearchAdapter.ViewHolderSA viewHolderSA, int i) {
        //setting up the views
        TextView tvwTitle = viewHolderSA.tvwTitle;
        TextView tvwViewDes = viewHolderSA.tvwViewDes;
        ImageView ivwImageThumb = viewHolderSA.ivwImageThumb;

        VideoModel vmcItem = alDataset.get(i);

        tvwTitle.setText(vmcItem.getSvTitle());
        tvwViewDes.setText(vmcItem.getSvDescription());

        viewHolderSA.bind(alDataset.get(i), otclListener);


        Picasso.with(ctvContext).load(vmcItem.getSvThumbnailURL()).into(ivwImageThumb);

    }

    @Override
    public int getItemCount() {
        return alDataset.size();
    }
}
