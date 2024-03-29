package edu.calvin.cs262.myapplication;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.androidwave.sampleapp.base.BaseCursorAdapter;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created on : Jan 27, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
public class FriendsCursorAdapter extends BaseCursorAdapter<FriendsCursorAdapter.FriendViewHolder> {

    public FriendsCursorAdapter() {
        super(null);
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View formNameView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_list, parent, false);
        return new FriendViewHolder(formNameView);
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, Cursor cursor) {
        int mColumnIndexName = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        String contactName = cursor.getString(mColumnIndexName);
        holder.nameTextView.setText(contactName);
    }

    @Override
    public void swapCursor(Cursor newCursor) {
        super.swapCursor(newCursor);
    }

    class FriendViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;

        FriendViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewName);
        }
    }
}
