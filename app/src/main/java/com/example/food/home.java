package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Adaptor.CategoryAdaptor;
import com.example.food.Adaptor.PopularAdaptor;
import com.example.food.Domain.CategoryDomain;
import com.example.food.Domain.FoodDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homebtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,home.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Vada Pav", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_22"));
        category.add(new CategoryDomain("Samosa", "cat_3"));
        category.add(new CategoryDomain("Pav Bhaji", "cat_4"));
        category.add(new CategoryDomain("Samosa", "cat_5"));
        category.add(new CategoryDomain("Pav Bhaji", "cat_6"));

        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList=new ArrayList<>();
        foodList.add(new FoodDomain("Pizza","pizz","Pizza is a round, flat base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients",149.99));
        foodList.add(new FoodDomain("Vada pav","vada","vada pav  is a vegetarian fast food in this dish deep-fried fritter made of mashed potato and spices, bread bun",24.99));
        foodList.add(new FoodDomain("Idly","idali","Idly is a popular breakfast food",49.99));
        foodList.add(new FoodDomain("Burger","bur","Burger  is a sandwich of ground meat, typically beef—placed inside a sliced bun or bread roll",79.99));
        foodList.add(new FoodDomain("Biryani","bir","Biryani is a healthy dish",149.99));
        foodList.add(new FoodDomain("Pav Bhaji","pav","Pav bhaji is a spiced mixture of mashed vegetables in a thick gravy served with bread.",149.99));

        adapter2=new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2) ;
    }
}