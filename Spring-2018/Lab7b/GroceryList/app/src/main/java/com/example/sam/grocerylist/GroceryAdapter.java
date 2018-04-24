package com.example.sam.grocerylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by Sam on 4/23/18.
 */

public class GroceryAdapter extends RealmBaseAdapter<Grocery> implements ListAdapter {
    private GroceryListActivity activity;

    private static class ViewHolder{
        TextView groceryItem;
        CheckBox isBought;
    }

    GroceryAdapter(GroceryListActivity activity, OrderedRealmCollection<Grocery>data){
        super(data);
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_list_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.groceryItem = (TextView) convertView.findViewById(R.id.itemTextView);
            viewHolder.isBought = (CheckBox) convertView.findViewById(R.id.checkBox);
            viewHolder.isBought.setOnClickListener(listener);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(adapterData != null){
            Grocery grocery = adapterData.get(position);
            viewHolder.groceryItem.setText(grocery.getItem());
            viewHolder.isBought.setChecked(grocery.isBought());
            viewHolder.isBought.setTag(position);
        }
        return convertView;
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            int position = (Integer) view.getTag();
            if(adapterData != null){
                Grocery grocery = adapterData.get(position);
                activity.changeItemBought(grocery.getID());
            }
        }
    };
}
