package com.example.githubuserapp.form;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.githubuserapp.R;
import com.example.githubuserapp.model.GithubUser;

public class DetailGithubUser extends AppCompatActivity {
    public static final String KEY_GITHUB_USER = "KEY_GITHUB_USER";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImageView imgAvatar;
        TextView username, name, company, repository, location, followers, following;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_user);
        getSupportActionBar();

        imgAvatar = findViewById(R.id.img_avatar_detail);
        username = findViewById(R.id.tv_username_detail);
        name = findViewById(R.id.tv_name_detail);
        company = findViewById(R.id.tv_company_detail);
        location = findViewById(R.id.tv_location_detail);
        repository = findViewById(R.id.tv_repository_detail);
        followers = findViewById(R.id.tv_followers_detail);
        following = findViewById(R.id.tv_following_detail);

        GithubUser githubUser = getIntent().getParcelableExtra(KEY_GITHUB_USER);
        imgAvatar.setImageResource(githubUser.getAvatar());
        username.setText(githubUser.getUsername());
        name.setText(githubUser.getName());
        company.setText(githubUser.getCompany());
        location.setText(githubUser.getLocation());
        repository.setText(githubUser.getRepository()+" "+getString(R.string.repository));
        followers.setText(githubUser.getFollower()+" "+getString(R.string.followers));
        following.setText(githubUser.getFollowing()+" "+getString(R.string.following));
    }
}
