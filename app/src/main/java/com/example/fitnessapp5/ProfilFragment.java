package com.example.fitnessapp5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import java.util.Arrays;
import java.util.List;
public class ProfilFragment extends Fragment {
  List<AuthUI.IdpConfig> providers;
  private static final int My_Request_code= 7117;
  Button sigout;
  ImageView profileImage;
  TextView  username;
  private FirebaseUser user;
  private FirebaseAuth firebaseAuth;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View w= inflater.inflate(R.layout.fragment_profil,container,false);
    sigout=w.findViewById(R.id.buton_signout22);
    profileImage=w.findViewById(R.id.profileImage);
    username=w.findViewById(R.id.userName);
    firebaseAuth = FirebaseAuth.getInstance();
    user = firebaseAuth.getCurrentUser();
    username.setText(user.getDisplayName());

    if(user.getPhotoUrl()!=null)
    Glide.with(getContext()).load(user.getPhotoUrl()).into(profileImage);


    sigout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AuthUI.getInstance()
                .signOut(getActivity())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                 //   sigout.setEnabled(false);
                 //   showSignInOption();
                    Intent i = new Intent(getContext(),MainActivity.class);
                    startActivity(i);

                  }
                }).addOnFailureListener(new OnFailureListener() {
          @Override
          public void onFailure(@NonNull Exception e) {
            Toast.makeText(getActivity(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
          }
        });

      }
    });

    /*
    providers = Arrays.asList(

            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.PhoneBuilder().build(),
            new AuthUI.IdpConfig.FacebookBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build()
    );

     */
 //   showSignInOption();


    return w;
  }
/*
  private void showSignInOption() {
    startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .setTheme(R.style.MyTheme)
                    .build(),My_Request_code);
  };

  @Override
  public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode == My_Request_code)
    {
      IdpResponse response= IdpResponse.fromResultIntent(data);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        sigout.setEnabled(true);

    }
  }

 */
}