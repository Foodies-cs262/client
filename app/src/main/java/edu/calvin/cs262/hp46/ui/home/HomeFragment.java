package edu.calvin.cs262.hp46.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.calvin.cs262.hp46.DataNote;
import edu.calvin.cs262.hp46.DataNoteInformation;
import edu.calvin.cs262.hp46.Food;
import edu.calvin.cs262.hp46.FoodViewModel;
import edu.calvin.cs262.hp46.R;
import edu.calvin.cs262.hp46.SearchedRecipe;

public class HomeFragment extends Fragment
{
    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;
    private ImageView mImageView;

    private FoodViewModel mWordViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        mWordViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mImageView = view.findViewById(R.id.imageView4);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mWordViewModel.getAllFood().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(@Nullable final List<Food> foods) {
                ArrayList data = new ArrayList<DataNote>();
                // Update the cached copy of the words in the adapter.
                for (int i = 0; i < foods.size(); i++){
                    data.add(new DataNote("del", foods.get(i).getName(), null));
                }

                mListadapter = new ListAdapter(data);
                mRecyclerView.setAdapter(mListadapter);
            }
        });


        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListadapter.deleteAll();
            }
        });

        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
    {
        private ArrayList<DataNote> dataList;

        public ListAdapter(ArrayList<DataNote> data)
        {
            this.dataList = data;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView textViewText;
            TextView textViewComment;
            TextView textViewDate;

            public ViewHolder(View itemView)
            {
                super(itemView);
                this.textViewText = itemView.findViewById(R.id.text);
                this.textViewComment = itemView.findViewById(R.id.comment);
                this.textViewDate = itemView.findViewById(R.id.date);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
        {
            holder.textViewText.setText(dataList.get(position).getText());
            holder.textViewComment.setText(dataList.get(position).getComment());
            holder.textViewDate.setText(dataList.get(position).getDate());

            holder.textViewText.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    deleteNote(dataList.get(position));
                }
            });
        }
        private void setFood(List<Food> foods){

        }

        private void deleteNote(DataNote note) {
            dataList.remove(note);
            mListadapter.notifyDataSetChanged();
        }

        private void deleteAll(){
            dataList.clear();
            mListadapter.notifyDataSetChanged();
        }

        @Override
        public int getItemCount()
        {
            return dataList.size();
        }
    }
}