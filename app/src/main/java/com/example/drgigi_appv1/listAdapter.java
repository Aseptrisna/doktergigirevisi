package com.example.drgigi_appv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class listAdapter extends BaseAdapter {

    private String TITLE[];
    private String TIME[];
    private String SPEAKER[];
    private String COST[];
    private String PERSON[];
    private String KEC[];
    private String KAB[];


    private Context context;
    private LayoutInflater inflater;

    public listAdapter(Context context, String TITLE[], String TIME[], String SPEAKER[], String COST[], String PERSON[],String KEC[],String KAB[]){
        this.context = context;
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
        View list = convertView;

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            list = inflater.inflate(R.layout.list_adapter, null);
        }

        TextView s_title = (TextView)list.findViewById(R.id.title);
        TextView s_speaker = (TextView)list.findViewById(R.id.speaker);
        TextView s_time = (TextView)list.findViewById(R.id.time);
        TextView s_cost = (TextView)list.findViewById(R.id.cost);
        TextView s_participant = (TextView)list.findViewById(R.id.participant);
        TextView s_kec = (TextView)list.findViewById(R.id.kec);
        TextView s_kab = (TextView)list.findViewById(R.id.kab);


        s_title.setText(TITLE[position]);
        s_speaker.setText(SPEAKER[position]);
        s_time.setText(TIME[position]);
        s_cost.setText(COST[position]);
        s_participant.setText(PERSON[position]);
        s_kec.setText(KEC[position]);
        s_kab.setText(KAB[position]);

        return list;
    }
}
