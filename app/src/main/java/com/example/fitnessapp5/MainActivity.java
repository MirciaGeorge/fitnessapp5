package com.example.fitnessapp5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;



import com.firebase.ui.auth.AuthUI;

import com.firebase.ui.auth.IdpResponse;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.OnFailureListener;

import com.google.android.gms.tasks.Task;

import com.google.android.material.navigation.NavigationView;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;

import com.facebook.FacebookSdk;

import com.facebook.appevents.AppEventsLogger;


import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    List<AuthUI.IdpConfig> providers;
    private static final int My_Request_code= 7117;
    Button sigout;
    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        if(user == null)
        {
            ShowProvider();
            showSignInOption();
            Toast.makeText(MainActivity.this, "USER == NULL", Toast.LENGTH_SHORT).show();
        }
        else{
           // btnSignOut = findViewById(R.id.btn_sign_out);
           // btnSignOut.setEnabled(true);
            Toast.makeText(MainActivity.this, "HELLO "+user.getDisplayName(), Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProfilFragment()).commit();
        }


        //CHECKING IF USER IS ALREADY LOGGED IN   END

     /*   sigout=(Button)findViewById(R.id.signoutb);
        sigout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                sigout.setEnabled(false);
                                showSignInOption();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


      */





        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer= findViewById(R.id.fit_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



    }

    private void ShowProvider()
    {
        //Init providers
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(), //Email builder
                //   new AuthUI.IdpConfig.TwitterBuilder().build(),// Twitter builder
                new AuthUI.IdpConfig.FacebookBuilder().build(),// FB builder
                new AuthUI.IdpConfig.GoogleBuilder().build(),// Google builder
                new AuthUI.IdpConfig.PhoneBuilder().build()// Phone builder
        );
    }

    private void showSignInOption() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.MyTheme)
                        .build(),My_Request_code);
    };

  public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.meniulogout,menu);
      return true;
  }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == My_Request_code)
        {
            IdpResponse response= IdpResponse.fromResultIntent(data);
            if(resultCode == RESULT_OK)
            {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
              //  Toast.makeText(this, ""+user.getEmail(),Toast.LENGTH_SHORT).show();
//               sigout.setEnabled(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfilFragment()).commit();
            }
            else
            {
                Toast.makeText(this, ""+response.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.nav_profil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfilFragment()).commit();

                break;
            case R.id.nav_gantera:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GanteraFragment()).commit();
                break;
            case R.id.nav_alimente:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AlimentatieFragment()).commit();
                break;
            case R.id.nav_calorii:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CaloriiFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
            {
                drawer.closeDrawer(GravityCompat.START);
            }
        else {
                super.onBackPressed();
             }
    }
};
