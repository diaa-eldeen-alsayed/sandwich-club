package com.udacity.sandwichclub.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.udacity.sandwichclub.DetailActivity;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json)  {
        Sandwich sandwich=new Sandwich();
        List<String> list=new ArrayList<>();
        try {


            JSONObject sandobject = new JSONObject(json);
            JSONObject name = sandobject.getJSONObject("name");
                   sandwich.setMainName(name.getString("mainName"));
            JSONArray knows = name.getJSONArray("alsoKnownAs");
            for (int i =0 ;i<knows.length();i++)
            {
                list.add(knows.get(i).toString());


            }
            Log.i("list=",list.toString());
            sandwich.setAlsoKnownAs(list);
          sandwich.setPlaceOfOrigin(sandobject.getString("placeOfOrigin"));
          sandwich.setDescription(sandobject.getString("description"));
          sandwich.setImage(sandobject.getString("image"));
           JSONArray ingre=  sandobject.getJSONArray("ingredients");
           list.clear();
            for (int i =0 ;i<ingre.length();i++)
            {
                list.add(ingre.get(i).toString());
            }
            Log.i("list=",list.toString());
            sandwich.setIngredients(list);






        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  sandwich;
    }
}
