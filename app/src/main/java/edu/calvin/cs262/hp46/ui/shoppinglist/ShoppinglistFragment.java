package edu.calvin.cs262.hp46.ui.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.calvin.cs262.hp46.FoodViewModel;
import edu.calvin.cs262.hp46.IngredientTable;
import edu.calvin.cs262.hp46.SearchedRecipe;
import edu.calvin.cs262.hp46.ShoppingNote;
import edu.calvin.cs262.hp46.ShoppingNoteInformation;
import edu.calvin.cs262.hp46.R;
import edu.calvin.cs262.hp46.ui.home.HomeFragment;
import edu.calvin.cs262.hp46.ui.shoppinglist.ShoppinglistFragment;

public class ShoppinglistFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ShoppinglistFragment.ListAdapter mListadapter;
    private FoodViewModel mWordViewModel;
    private ImageView mImageView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_shoppinglist, container, false);

        mWordViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mImageView = view.findViewById(R.id.imageView4);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mWordViewModel.getAllIngredient().observe(this, new Observer<List<IngredientTable>>() {
            @Override
            public void onChanged(@Nullable final List<IngredientTable> ingredients) {
                ArrayList data = new ArrayList<ShoppingNote>();
                // Update the cached copy of the words in the adapter.
                for (int i = 0; i < ingredients.size(); i++){
                    data.add(new ShoppingNote(Double.toString(ingredients.get(i).getQuantity()), ingredients.get(i).getName(), ingredients.get(i).getUnit()));
                    Log.i("DataTable", ingredients.get(i).getName());
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

    public class ListAdapter extends RecyclerView.Adapter<ShoppinglistFragment.ListAdapter.ViewHolder>
    {
        private ArrayList<ShoppingNote> dataList;

        public ListAdapter(ArrayList<ShoppingNote> data)
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
        public ShoppinglistFragment.ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_shoppinglist, parent, false);

            ShoppinglistFragment.ListAdapter.ViewHolder viewHolder = new ShoppinglistFragment.ListAdapter.ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ShoppinglistFragment.ListAdapter.ViewHolder holder, final int position)
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

        private void deleteNote(ShoppingNote note) {
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