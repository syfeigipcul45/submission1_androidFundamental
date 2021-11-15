package com.example.githubuserapp;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.example.githubuserapp.adapter.GithubUserAdapter;
import com.example.githubuserapp.model.GithubUser;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUser;
    private final ArrayList<GithubUser> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUser = findViewById(R.id.rv_githubUser);
        rvUser.setHasFixedSize(true);
        getSupportActionBar();

        list.addAll(getListUser());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public ArrayList<GithubUser> getListUser() {
        TypedArray dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        String[] dataUsername = getResources().getStringArray(R.array.username);
        String[] dataName = getResources().getStringArray(R.array.name);
        String[] dataCompany = getResources().getStringArray(R.array.company);
        String[] dataLocation = getResources().getStringArray(R.array.location);
        String[] dataRepository = getResources().getStringArray(R.array.repository);
        String[] dataFollowers = getResources().getStringArray(R.array.followers);
        String[] dataFollowing = getResources().getStringArray(R.array.following);

        ArrayList<GithubUser> listUser = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            GithubUser githubUser = new GithubUser();
            githubUser.setAvatar(dataAvatar.getResourceId(i, -1));
            githubUser.setUsername(dataUsername[i]);
            githubUser.setName(dataName[i]);
            githubUser.setCompany(dataCompany[i]);
            githubUser.setLocation(dataLocation[i]);
            githubUser.setRepository(dataRepository[i]);
            githubUser.setFollower(dataFollowers[i]);
            githubUser.setFollowing(dataFollowing[i]);

            listUser.add(githubUser);
        }
        dataAvatar.recycle();
        return listUser;
    }

    private void showRecyclerList() {
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        GithubUserAdapter githubUserAdapter = new GithubUserAdapter(list);
        rvUser.setAdapter(githubUserAdapter);
    }
}