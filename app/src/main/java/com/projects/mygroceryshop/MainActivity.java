package com.projects.mygroceryshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.projects.mygroceryshop.Context.DBContext;
import com.projects.mygroceryshop.Model.Cart;
import com.projects.mygroceryshop.Service.DB;

public class MainActivity extends AppCompatActivity implements fragmentUpdated{
    private Context context;
    private Handler handler = new Handler();
    public static Cart cart;
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = getApplicationContext();
        cart = new Cart();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Checking out...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView totalView = (TextView) findViewById(R.id.total_amt_input);
        double totalPaid = cart.getTotalPaid();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String v = String.valueOf(totalPaid)+"$";
                totalView.setText(v);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_items:
                Intent intent = new Intent(this,AddItemActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void updateActivityUI() {
        TextView totalView = (TextView) findViewById(R.id.total_amt_input);
        double totalPaid = cart.getTotalPaid();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String v = String.valueOf(totalPaid)+"$";
                totalView.setText(v);
            }
        });
    }
}