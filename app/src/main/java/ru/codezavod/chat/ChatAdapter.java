package ru.codezavod.chat;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    Context context;
    private ArrayList<String> messageList;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(datas.get(position));
    }

    @Override
    public int getItemCount() {
        if (datas == null){
            return 0;
        }
        return datas.size();
    }

    public void changeDataSet(ArrayList<JSONObject> data){
        datas = data;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleText;

        public ViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.attractions_cell_title);
        }

        public void bind(final JSONObject item) {


                // titleText.setTypeface(MainActivity.sfNormal);
                titleText.setText(item.getString("title"));
                titleText.setTypeface(MainActivity.metaNormal);



        }
    }
}
