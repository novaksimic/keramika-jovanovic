package com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri_adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.strucnapraksa.keramikajovanovic.R;
import com.example.strucnapraksa.keramikajovanovic.adapter.GalleryAdapter;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyHolder> {


    private Context mContext;
    String[] result;
    int[] imageId;

    public static int[] saloniImages = {
            R.mipmap.beograd,
            R.mipmap.kragujevac,
            R.mipmap.novi_sad,
            R.mipmap.subotica,
            R.mipmap.sabac,
            R.mipmap.kikinda,
            R.mipmap.temerin,
            R.mipmap.zajecar,
            R.mipmap.ogrev,
            R.mipmap.sombor };

    public GridAdapter(Context mContext, String[] result, int[] imageId) {
        this.mContext = mContext;
        this.result = result;
        this.imageId = imageId;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.prodajni_saloni_griditem, null);
        MyHolder myHolder = new MyHolder(layout);


        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.img.setImageResource(imageId[position]);
        holder.txt.setText(result[position]);



    }

    @Override
    public int getItemCount() {
        return result.length;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;

        public MyHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imageView2);
            txt = (TextView) itemView.findViewById(R.id.textView5);
        }
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private GridAdapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final GridAdapter.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}




