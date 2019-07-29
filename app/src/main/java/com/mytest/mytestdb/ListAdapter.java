package com.mytest.mytestdb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private List<String> mStringList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View ListView;
        TextView ListName;

        public ViewHolder(View view) {
            super(view);
            ListView = view;
            ListName = (TextView) view.findViewById(R.id.listinfo);
        }
    }

    public ListAdapter(List<String> StringList)
    {
        mStringList = StringList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listdata_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.ListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                String fruit = mStringList.get(position);
                //Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String fruit = mStringList.get(position);
        //holder.fruitImage.setImageResource(fruit.getImageId());
        holder.ListName.setText(fruit.toString());
    }

    @Override
    public int getItemCount()
    {
        return mStringList.size();
    }

}
