package com.example.phoenix.SignUpLayout.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenix.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    String Assistants[] , Teacher [];
    int image;
    Context context;
    public RecyclerViewAdapter(Context context , String Assistant[] , String Teacher[] , int image){
        this.Assistants = Assistant;
        this.Teacher = Teacher;
        this.image = image;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.assistant_recycler_view,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.assistant_name.setText(Assistants[position]);
        holder.teacher_name.setText(Teacher[position]);
        holder.image.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return Assistants.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView assistant_name , teacher_name;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            assistant_name = itemView.findViewById(R.id.assistant_name);
            teacher_name = itemView.findViewById(R.id.teacher_name);
            image = itemView.findViewById(R.id.assistant_img);
        }
    }
}
