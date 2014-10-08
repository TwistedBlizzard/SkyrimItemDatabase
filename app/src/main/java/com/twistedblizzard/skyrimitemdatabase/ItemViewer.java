package com.twistedblizzard.skyrimitemdatabase;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ItemViewer extends ActionBarActivity {

    String[] itemName;
    String output;
    int[] itemWeight;
    int[] itemValue;
    int[] itemDamage;
    int[] itemRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        int posNo = extras.getInt("posNo");
        int itemCategory = extras.getInt("parent");

        if(itemCategory == 0) {
            itemName = getResources().getStringArray(R.array.AmmunitionNames);
            itemWeight = getResources().getIntArray(R.array.AmmunitionWeight);
            itemValue = getResources().getIntArray(R.array.AmmunitionValue);
            itemDamage = getResources().getIntArray(R.array.AmmunitionDamage);

            String damageValue;

            if((itemDamage[posNo] > 0) && (itemValue[posNo] > 0)) {
                damageValue = String.valueOf(Math.round((itemDamage[posNo] / itemValue[posNo]) * 1000.0) / 100.0);
            }
            else {
                damageValue = "N/A";
            }

            setTitle(itemName[posNo]);

            output = "Name: "
                    + itemName[posNo]
                    + System.getProperty("line.separator")
                    + "Weight: "
                    + itemWeight[posNo]
                    + System.getProperty("line.separator")
                    + "Base Value: "
                    + itemValue[posNo]
                    + System.getProperty("line.separator")
                    + "Base Damage: "
                    + itemDamage[posNo]
                    + System.getProperty("line.separator")
                    + "(Damage*10)/Value: "
                    + damageValue
                    + System.getProperty("line.separator");
        }
        if(itemCategory == 1) {
            itemName = getResources().getStringArray(R.array.LightArmourNames);
            itemWeight = getResources().getIntArray(R.array.LightArmourWeight);
            itemValue = getResources().getIntArray(R.array.LightArmourValue);
            itemRating = getResources().getIntArray(R.array.LightArmourRating);

            String valueWeight;
            String ratingWeight;
            String ratingValue;

            if((itemValue[posNo] > 0) && (itemWeight[posNo] > 0)) {
                valueWeight = String.valueOf(Math.round((itemValue[posNo] / itemWeight[posNo]) * 100.0) / 100.0);
            }
            else {
                valueWeight = "N/A";
            }

            if((itemRating[posNo] > 0) && (itemWeight[posNo] > 0)) {
                ratingWeight = String.valueOf(Math.round((itemRating[posNo] / itemWeight[posNo]) * 100.0) / 100.0);
            }
            else {
                ratingWeight = "N/A";
            }

            if((itemRating[posNo] > 0) && (itemValue[posNo] > 0)) {
                ratingValue = String.valueOf(Math.round((itemRating[posNo] / itemValue[posNo]) * 1000.0) / 100.0);
            }
            else {
                ratingValue = "N/A";
            }

            setTitle(itemName[posNo]);

            output = "Name: "
                    + itemName[posNo]
                    + System.getProperty("line.separator")
                    + "Weight: "
                    + itemWeight[posNo]
                    + System.getProperty("line.separator")
                    + "Base Value: "
                    + itemValue[posNo]
                    + System.getProperty("line.separator")
                    + "Base Rating: "
                    + itemRating[posNo]
                    + System.getProperty("line.separator")
                    + "Value/Weight: "
                    + valueWeight
                    + System.getProperty("line.separator")
                    + "Rating/Weight: "
                    + ratingWeight
                    + System.getProperty("line.separator")
                    + "(Rating*10)/Value: "
                    + ratingValue
                    + System.getProperty("line.separator");
        }

        LinearLayout invButtons = new LinearLayout(this);

        RelativeLayout.LayoutParams invButtonsParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        invButtonsParams.addRule(RelativeLayout.ALIGN_LEFT);
        invButtonsParams.addRule(RelativeLayout.BELOW, R.id.itemStats);

        invButtons.setLayoutParams(invButtonsParams);
        invButtons.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams subtractParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                0.2f);

        Button subtract = new Button(this);
        subtract.setId(R.id.subtractButton);
        subtract.setText("-");
        subtract.setLayoutParams(subtractParams);

        LinearLayout.LayoutParams numBoxParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                0.6f);

        TextView numBox = new TextView(this);
        numBox.setId(R.id.numBox);
        numBox.setText("0");
        numBox.setTextSize(20);
        numBox.setGravity(Gravity.CENTER_HORIZONTAL);
        numBox.setLayoutParams(numBoxParams);

        //TODO: Allow user input of number

        LinearLayout.LayoutParams addParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                0.2f);

        Button add = new Button(this);
        add.setId(R.id.addButton);
        add.setText("+");
        add.setLayoutParams(addParams);

        invButtons.addView(subtract);
        invButtons.addView(numBox);
        invButtons.addView(add);

        RelativeLayout relativeLayout = new RelativeLayout(this);

        ViewGroup.LayoutParams relLayoutParam = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        RelativeLayout.LayoutParams lpItemStats = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        TextView itemStats = new TextView(this);
        itemStats.setId(R.id.itemStats);
        itemStats.setText(output);
        itemStats.setTextSize(20);
        itemStats.setLayoutParams(lpItemStats);

        relativeLayout.addView(itemStats);
        relativeLayout.addView(invButtons, invButtonsParams);

        setContentView(relativeLayout, relLayoutParam);

        //TODO: Save number of items in inventory to file

    }
}
