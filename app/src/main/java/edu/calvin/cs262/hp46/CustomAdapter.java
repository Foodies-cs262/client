// ListAdapter from https://www.journaldev.com/10416/android-listview-with-custom-adapter-example-tutorial
package edu.calvin.cs262.hp46;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{

    private ArrayList<DataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView childTv;
        ImageView childButton;
        ImageView childImg;
    }

    // CustomAdapter constructor
    // Contains array of DataModel object and context
    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.child_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        DataModel object= getItem(position);
        DataModel dataModel= object;

        // Create Snackbar when + Button is pressed on the recipe list
        switch (v.getId()) {
            case R.id.childButton:
                Snackbar.make(v, "Ingredient for " + dataModel.getRecipe_name()
                        + " added to ingredient list", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.child_item, parent, false);
            viewHolder.childTv = convertView.findViewById(R.id.childTv);
            viewHolder.childButton = convertView.findViewById(R.id.childButton);
            viewHolder.childImg = convertView.findViewById(R.id.childImg);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        // Creates animation when scrolling up and down
        // Calls animation from anim.down_from_up.xml and up_from_bottom.xml
        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_up);
        result.startAnimation(animation);
        lastPosition = position;

        // Shows recipe name and recipe image on the ListView
        // Prepares button for the onClick method
        viewHolder.childTv.setText(dataModel.getRecipe_name());
        viewHolder.childImg.setImageResource(dataModel.getImage());
        viewHolder.childButton.setOnClickListener(this);
        viewHolder.childButton.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
