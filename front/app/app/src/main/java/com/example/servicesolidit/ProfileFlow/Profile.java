package com.example.servicesolidit.ProfileFlow;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesolidit.Model.Responses.UserInfoProfileDto;
import com.example.servicesolidit.Model.Responses.UserInfoProfileResponseDto;
import com.example.servicesolidit.R;
import com.example.servicesolidit.Utils.Constants;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;
import java.util.Map;

public class Profile extends Fragment implements ProfileView{

    private Button btnCustomer;
    private Button btnProvider;
    private MaterialButtonToggleGroup buttonToggleGroup;
    private ProgressBar itemLoad;
    private TextView nameProfileHeader;


    private PersonalData personalData;
    private final BussinesData bussinesData = new BussinesData();
    private final Map<Integer, Runnable> navigationAction = new HashMap<>();

    private ProfilePresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnCustomer = view.findViewById(R.id.btn_customer);
        btnProvider = view.findViewById(R.id.btn_provider);
        buttonToggleGroup = view.findViewById(R.id.toggleButton);
        itemLoad = view.findViewById(R.id.load_item_profile);
        nameProfileHeader = view.findViewById(R.id.txt_name_profile);

        buttonToggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked){
               checkButtonData(isChecked,checkedId);
            }
        });

        presenter = new ProfilePresenter(this);

        /** Load Personal Data */
        presenter.information(getIdLogged());
        showProgress();
        return view;
    }

    public int getIdLogged(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(Constants.MY_PREFERENCES, MODE_PRIVATE);
        int userIdLogged = sharedPreferences.getInt(Constants.GET_LOGGED_USER_ID, 0);
        Log.i("ProfileClass", "IdLogged: " + userIdLogged);
        return userIdLogged;
    }

    public void initPeronsalData(UserInfoProfileDto user){
        this.personalData = new PersonalData(user);
        this.nameProfileHeader.setText("Bienvenido "+ user.getNameUser());
    }
  
    public void checkButtonData (boolean isChecked,int checkedId){

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        if (checkedId == R.id.btn_customer){
            transaction.replace(R.id.fragment_container,personalData);
            transaction.addToBackStack(null);
            transaction.remove(bussinesData);
            transaction.commit();
        } if (checkedId == R.id.btn_provider){
            BussinesData bussinesData = new BussinesData();
            transaction.replace(R.id.fragment_container,bussinesData);
            transaction.addToBackStack(null);
            transaction.remove(personalData);
            transaction.commit();
        }
    }

    @Override
    public void showProgress() {
        itemLoad.setVisibility(View.VISIBLE);
        Log.i("ProfileClass", "ShowProgress");
    }

    @Override
    public void hideProgress() {
        itemLoad.setVisibility(View.GONE);
        Log.i("ProfileClass", "HideProgress");
    }

    @Override
    public void onLoadProfileSuccess(UserInfoProfileDto message) {
        hideProgress();
        initPeronsalData(message);
        checkButtonData(true, R.id.btn_customer);
    }

    @Override
    public void onLoadProfileError(String message) {
        hideProgress();
        Log.i("ProfileClass", "Error: " + message);
    }
}