package com.yadhukrishnane.finalexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class POIAdapter extends RecyclerView.Adapter<POIAdapter.POIViewHolder> {

    private List<POI> pois;
    private OnItemClickListener mListener;

    public POIAdapter(List<POI> pois) {
        this.pois = pois;
    }

    @NonNull
    @Override
    public POIViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_single_pois, parent, false);
        return new POIViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull POIViewHolder holder, int position) {
        holder.bind(pois.get(position));
    }

    @Override
    public int getItemCount() {
        return pois.size();
    }

    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    class POIViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView tvPOI;

        public POIViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPOI = itemView.findViewById(R.id.tv_single_poi);

            tvPOI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        mListener.onItemClicked(pois.get(getLayoutPosition()));
                    }
                }
            });
        }

        void bind(POI poi) {
            tvPOI.setText(poi.getName());
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(POI poi);
    }
}
