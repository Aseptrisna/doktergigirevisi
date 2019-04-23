package com.example.drgigi_appv1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drgigi_appv1.response.BeritaItem;
import com.example.drgigi_appv1.response.BeritaItem;
import com.squareup.picasso.Picasso;

import java.util.List;
/**
 * Created by Rizal Hilman on 12/02/18.
 * www.khilman.com
 */

class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.MyViewHolder> {
    // Buat Global variable untuk manampung context
    Context context;
    List<BeritaItem> berita;
    public AdapterBerita(Context context, List<BeritaItem> data_berita) {
        // Inisialisasi
        this.context = context;
        this.berita = data_berita;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.berita_item, parent, false);

        // Hubungkan dengan MyViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Set widget
        holder.tvJudul.setText(berita.get(position).getTitle());
        holder.tvTglTerbit.setText(berita.get(position).getTgl_acara());
        holder.tvPenulis.setText(berita.get(position).getValue());
      holder.kec.setText(berita.get(position).getKecamatan());
      holder.kab.setText(berita.get(position).getKota());
        holder.cost.setText(berita.get(position).getBiaya());
        holder.partisipant.setText(berita.get(position).getKouta());
//    holder.spesialis.setText(berita.get(position).getMateri());
        // Dapatkan url gambar
        final String urlGambarBerita = "http://192.168.2.17:5000/" + berita.get(position).getPamlet();
        // Set image ke widget dengna menggunakan Library Piccasso
        // krena imagenya dari internet
        Picasso.with(context).load(urlGambarBerita).into(holder.ivGambarBerita);


        // Event klik ketika item list nya di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mulai activity Detail
                Intent varIntent = new Intent(context, detailacara.class);
                // sisipkan data ke intent
                varIntent.putExtra("JDL_SMR", berita.get(position).getTitle());
                varIntent.putExtra("TGL_SMR", berita.get(position).getTgl_acara());
                varIntent.putExtra("KOTA_SMR", berita.get(position).getKota());
                varIntent.putExtra("FOTO", urlGambarBerita);
                varIntent.putExtra("KEC_SMR", berita.get(position).getKecamatan());
                varIntent.putExtra("KOUTA", berita.get(position).getKouta());
                varIntent.putExtra("BIAYA", berita.get(position).getBiaya());
                varIntent.putExtra("MATERI", berita.get(position).getValue());
                varIntent.putExtra("LOKASI", berita.get(position).getLokasi());
                varIntent.putExtra("CP", berita.get(position).getCp());
                varIntent.putExtra("EMAIL", berita.get(position).getEmail());




                // sisipkan data ke intent
//                varIntent.putExtra("JDL_BERITA", berita.get(position).getTitle());
//                varIntent.putExtra("TGL_BERITA", berita.get(position).getTgl_acara());
//                varIntent.putExtra("PNS_BERITA", berita.get(position).getKota());
//                varIntent.putExtra("FTO_BERITA", urlGambarBerita);
//                varIntent.putExtra("ISI_BERITA", berita.get(position).getKecamatan());

                // method startActivity cma bisa di pake di activity/fragment
                // jadi harus masuk ke context dulu
                context.startActivity(varIntent);
            }
        });
    }
    // Menentukan Jumlah item yang tampil
    @Override
    public int getItemCount() {
        return berita.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Deklarasi widget
        ImageView ivGambarBerita;
        TextView tvJudul, tvTglTerbit, tvPenulis,kec,kab,cost,partisipant,spesialis;
        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi widget
            ivGambarBerita = (ImageView) itemView.findViewById(R.id.thumb);
            tvJudul = (TextView) itemView.findViewById(R.id.title);
            tvTglTerbit = (TextView) itemView.findViewById(R.id.time);
            tvPenulis = (TextView) itemView.findViewById(R.id.speaker);
            kec=(TextView)itemView.findViewById(R.id.kec);
            kab=(TextView)itemView.findViewById(R.id.kab);
            cost=(TextView)itemView.findViewById(R.id.cost);
            partisipant=(TextView)itemView.findViewById(R.id.participant);
           // spesialis=(TextView)itemView.findViewById(R.id.spesialis);

        }
    }
}