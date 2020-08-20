package com.example.oc3.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oc3.CoursePageActivity;
import com.example.oc3.R;
import com.example.oc3.model.Datum;
import com.example.oc3.model.Moduels;
import com.example.oc3.ui.ModulesPageActivity;

public class ModulesAdapter extends  RecyclerView.Adapter<ModulesAdapter.ModuleViewHolder> {

    private Context context;
    Moduels modulesLists;

    public ModulesAdapter(Context context, Moduels modulesLists) {
        this.context = context;
        this.modulesLists = modulesLists;
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.module_row_items, parent, false);

        return new ModulesAdapter.ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModulesAdapter.ModuleViewHolder holder, int position) {

        holder.mdlPgMdlNo.setText(modulesLists.getData().get(position).getPk());
        holder.mdlPgMdlNm.setText(modulesLists.getData().get(position).getModule());
        holder.mdlPgMdlDsc.setText(modulesLists.getData().get(position).getModuleDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent i = new Intent(context, ModulesPageActivity.class);
//                //Put Value for next intent or Slug
//                i.putExtra("pos",position);
//                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return modulesLists.getData().size();
    }

    public static class ModuleViewHolder extends RecyclerView.ViewHolder {


        TextView mdlPgMdlNo, mdlPgMdlNm, mdlPgMdlDsc;

        public ModuleViewHolder(@NonNull View itemView) {
            super(itemView);

            mdlPgMdlNo = itemView.findViewById(R.id.mdlPgMdlNo);
            mdlPgMdlNm = itemView.findViewById(R.id.mdlPgMdlNm);
            mdlPgMdlDsc = itemView.findViewById(R.id.mdlPgMdlDsc);
//            crsPgCrsNm = itemView.findViewById(R.id.crsPgCrsNm);
//            crsPgCrsF = itemView.findViewById(R.id.crsPgCrsF);
//            cat3 = itemView.findViewById(R.id.cat3);


        }
    }
}