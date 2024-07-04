package com.opethic.registerationmobileapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.opethic.registerationmobileapp.Adapters.MemberListAdapter;
import com.opethic.registerationmobileapp.R;

public class RegistrationDetailsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    MemberListAdapter adapter;

    AppCompatButton bt_add_member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_details);

        recyclerView = findViewById(R.id.rv_reg_details);
        bt_add_member = findViewById(R.id.bt_add_member);
        adapter = new MemberListAdapter(this);



        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        bt_add_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new  Intent(RegistrationDetailsActivity.this,Member_RegActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
}