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

import com.bumptech.glide.Glide;
import com.example.oc3.CoursePageActivity;
import com.example.oc3.R;
import com.example.oc3.model.Courses;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;
    Courses courseLists;

    public CourseAdapter(Context context, Courses courseLists) {
        this.context = context;
        this.courseLists = courseLists;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_row_items,parent,false);

        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        holder.course_name.setText((courseLists.getResults().get(position).getCourseName()));
        holder.course_duration.setText((courseLists.getResults().get(position).getCourseDuration()));

        Glide.with(context).load("http://aptechlearning.herokuapp.com/media/ux_big.png").into(holder.course_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, CoursePageActivity.class);
                //Put Value for next intent or Slug
                i.putExtra("pos",position);
                context.startActivity(i);

            }
        });



    }

    @Override
    public int getItemCount() {
        return courseLists.getResults().size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder{

        ImageView course_image;
        TextView course_name,course_duration,crsPgCrsNm,crsPgCrsF,cat3;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            course_image = itemView.findViewById(R.id.course_image);
            course_name = itemView.findViewById(R.id.course_name);
            course_duration = itemView.findViewById(R.id.course_duration);
//            crsPgCrsNm = itemView.findViewById(R.id.crsPgCrsNm);
//            crsPgCrsF = itemView.findViewById(R.id.crsPgCrsF);
//            cat3 = itemView.findViewById(R.id.cat3);


        }
    }

}
