package com.example.githubuserapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.githubuserapp.R;
import com.example.githubuserapp.form.DetailGithubUser;
import com.example.githubuserapp.model.GithubUser;

import java.util.ArrayList;

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.ListViewHolder> {
    private final ArrayList<GithubUser> listUser;

    public GithubUserAdapter(ArrayList<GithubUser> list) {
        this.listUser = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_user, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        GithubUser githubUser = listUser.get(position);
//        holder.imgAvatar.setImageResource(githubUser.getAvatar());
        Glide.with(holder.itemView.getContext())
                .load(githubUser.getAvatar())
                .circleCrop()
                .into(holder.imgAvatar);
        holder.username.setText(githubUser.getUsername());
        holder.name.setText(githubUser.getName());
        holder.company.setText(githubUser.getCompany());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgAvatar;
        TextView username, name, company;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_item_avatar);
            username = itemView.findViewById(R.id.tv_item_username);
            name = itemView.findViewById(R.id.tv_item_name);
            company = itemView.findViewById(R.id.tv_item_company);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent detailGithubUser = new Intent(itemView.getContext(), DetailGithubUser.class);
            detailGithubUser.putExtra(DetailGithubUser.KEY_GITHUB_USER, listUser.get(position));
            itemView.getContext().startActivity(detailGithubUser);
        }
    }
}
