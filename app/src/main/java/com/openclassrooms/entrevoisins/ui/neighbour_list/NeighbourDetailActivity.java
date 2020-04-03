package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourDetailActivity extends AppCompatActivity {

    @BindView(R.id.activity_detail_img_picture_neighbour)
    ImageView neighbour;
    @BindView(R.id.activity_detail_img_back)
    ImageView back;
    @BindView(R.id.activity_detail_text_name)
    TextView name;
    @BindView(R.id.activity_detail_text_name_second)
    TextView name_second;
    @BindView(R.id.activity_detail_text_address)
    TextView adress;
    @BindView(R.id.activity_detail_text_phone)
    TextView phone;
    @BindView(R.id.activity_detail_text_facebook)
    TextView facebook;
    @BindView(R.id.activity_detail_text_a_propos)
    TextView a_propos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String nameStr = intent.getStringExtra("nom");
        String adressStr = intent.getStringExtra("adress");
        String aboutmeStr = intent.getStringExtra("aboutme");
        String avatarUrlStr = intent.getStringExtra("avatarUrl");
        String phoneStr = intent.getStringExtra("phone");
        long id = intent.getLongExtra("id", 0);

        name.setText(nameStr);
        name_second.setText(nameStr);
        adress.setText(adressStr);
        phone.setText(phoneStr);
        facebook.setText("www.facebook.fr/" + nameStr);
        a_propos.setText(aboutmeStr);

        Glide.with(this)
                .load(avatarUrlStr)
                .into(neighbour);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
