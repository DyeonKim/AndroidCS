package com.example.javaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaapp.data.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.PersonsViewHolder> {
    private List<Person> dataSet;
    private ItemClickListener itemClickListener;

    public static class PersonsViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvAge;
        private TextView tvGender;

        public PersonsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.list_tv_name);
            tvAge = itemView.findViewById(R.id.list_tv_age);
            tvGender = itemView.findViewById(R.id.list_tv_gender);
        }

        protected void bindInfo(Person data) {
            tvName.setText(data.getFullName());
            tvAge.setText(Integer.toString(data.getAge()));
            tvGender.setText(data.getGender());
        }
    }

    public PersonsAdapter(List<Person> dataSet) {
        this.dataSet = new ArrayList<>(dataSet);
    }

    @NonNull
    @Override
    public PersonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 리스트 아이템 UI를 정의한 뷰 생성
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_person_item, parent, false);
        return new PersonsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonsViewHolder holder, int position) {
        holder.bindInfo(dataSet.get(position));
        holder.itemView.setOnClickListener(view -> {
            itemClickListener.onClick(dataSet.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    interface ItemClickListener {
        void onClick(Person person);
    }
}
