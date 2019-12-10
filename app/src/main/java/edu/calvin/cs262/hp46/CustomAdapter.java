// ListAdapter from https://www.journaldev.com/10416/android-listview-with-custom-adapter-example-tutorial
// Adapter class that receives information from the DataModel and show contained information to the end user
package edu.calvin.cs262.hp46;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<DataModel> mCustomList;
    private CustomViewHolder.OnNoteLister mOnnoteLister;
    private CustomViewHolder.OnNoteLister2 mOnnoteLister2;

    public static class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mImageView1;
        public ImageView mImageView2;
        public TextView mTextView1;

        OnNoteLister onNoteLister;
        OnNoteLister2 onNoteLister2;

        public CustomViewHolder(View itemView, OnNoteLister onNoteLister, OnNoteLister2 onNoteLister2) {
            super(itemView);
            mImageView1 = itemView.findViewById(R.id.childImg);
            mImageView2 = itemView.findViewById(R.id.childButton);
            mTextView1 = itemView.findViewById(R.id.childTv);
            this.onNoteLister = onNoteLister;
            this.onNoteLister2 = onNoteLister2;

            mImageView2.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }
        // https://www.youtube.com/watch?v=69C1ljfDvl0
        @Override
        public void onClick(View view) {
            if (view.getId() == mImageView2.getId()){
                onNoteLister2.onNoteClick2(getAdapterPosition());
            }
            else{
                onNoteLister.onNoteClick(getAdapterPosition());
            }
        }

        public interface OnNoteLister{
            void onNoteClick(int position);
        }

        public interface OnNoteLister2{
            void onNoteClick2(int position);
        }
    }

    public CustomAdapter(ArrayList<DataModel> exampleList, CustomViewHolder.OnNoteLister onNoteLister, CustomViewHolder.OnNoteLister2 onNoteLister2) {
        mCustomList = exampleList;
        this.mOnnoteLister = onNoteLister;
        this.mOnnoteLister2 = onNoteLister2;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item,
                parent, false);
        CustomViewHolder evh = new CustomViewHolder(v, mOnnoteLister, mOnnoteLister2);
        return evh;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        DataModel currentItem = mCustomList.get(position);

        holder.mTextView1.setText(currentItem.getRecipe_name());
        Picasso.get().load(currentItem.getImage()).resize(120, 120).into(holder.mImageView1);
    }

    @Override
    public int getItemCount() {
        return mCustomList.size();
    }

    // Method used to filter the recipe list
    public void filterList(ArrayList<DataModel> filteredList) {
        mCustomList = filteredList;
        notifyDataSetChanged();
    }

    // Creates new list of recipe after retrieving data from RapidAPI
    public void newList(ArrayList<DataModel> newList) {
        mCustomList = newList;
        notifyDataSetChanged();
    }
}