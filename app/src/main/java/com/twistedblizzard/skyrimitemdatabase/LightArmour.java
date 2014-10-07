package com.twistedblizzard.skyrimitemdatabase;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class LightArmour extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_armour);
    }
    public void openLightArmour_Armour (View view) {
        Intent intent = new Intent(this, LightArmour_Armour.class);
        startActivity(intent);
    }

    public void openLightArmour_Boots (View view) {
        Intent intent = new Intent(this, LightArmour_Boots.class);
        startActivity(intent);
    }
}