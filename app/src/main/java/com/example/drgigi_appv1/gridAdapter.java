package com.example.drgigi_appv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class gridAdapter extends BaseAdapter {

    private int IMAGES[];
    private String TITLE[];
    private String TIME[];
    private String SPEAKER[];
    private String COST[];
    private String PERSON[];
    private String KEC[];
    private String KAB[];



    private Context context;
    private LayoutInflater inflater;

    public gridAdapter(Context context, int IMAGES[], String TITLE[], String TIME[], String SPEAKER[], String COST[], String PERSON[],String KEC[],String KAB[]){
        this.context = context;
        this.IMAGES = IMAGES;
        this.TITLE = TITLE;
        this.TIME = TIME;
        this.SPEAKER = SPEAKER;
        this.COST = COST;
        this.PERSON = PERSON;
        this.KEC = KEC;
        this.KAB = KAB;
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }

    @Override
    public Object getItem(int position) {
        return TITLE[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid = convertView;

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.grid_adapter, null);
        }

        ImageView thumbnail = (ImageView)grid.findViewById(R.id.thumb);
        TextView s_title = (TextView)grid.findViewById(R.id.title);
        TextView s_speaker = (TextView)grid.findViewById(R.id.speaker);
        TextView s_time = (TextView)grid.findViewById(R.id.time);
        TextView s_cost = (TextView)grid.findViewById(R.id.cost);
        TextView s_participant = (TextView)grid.findViewById(R.id.participant);
        TextView s_kec = (TextView)grid.findViewById(R.id.kec);
        TextView s_kab = (TextView)grid.findViewById(R.id.kab);

        thumbnail.setImageResource(IMAGES[position]);
        s_title.setText(TITLE[position]);
        s_speaker.setText(SPEAKER[position]);
        s_time.setText(TIME[position]);
        s_cost.setText(COST[position]);
        s_participant.setText(PERSON[position]);
        s_kec.setText(KEC[position]);
        s_kab.setText(KAB[position]);

        return grid;
    }
}
