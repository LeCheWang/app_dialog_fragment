package com.example.app_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.app_demo.Api.ApiController;
import com.example.app_demo.Models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView revProducts;

    List<Product> productList = new ArrayList<>();

    ProductAdapter productAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        revProducts = findViewById(R.id.revProducts);

        //fix cứng dữ liệu
//        productList.add(new Product("1", "ÁO Polo", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/36.jpg", "Áo đẹp", "200.00"));
//        productList.add(new Product("2", "ÁO Polo2", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/36.jpg", "Áo đẹp", "200.00"));
//        productList.add(new Product("3", "ÁO Polo3", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/36.jpg", "Áo đẹp", "200.00"));
//        productList.add(new Product("4", "ÁO Polo4", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/36.jpg", "Áo đẹp", "200.00"));
//        productList.add(new Product("5", "ÁO Polo5", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/36.jpg", "Áo đẹp", "200.00"));
//        productList.add(new Product("6", "ÁO Polo6", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/36.jpg", "Áo đẹp", "200.00"));
//        productList.add(new Product("7", "ÁO Polo7", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/36.jpg", "Áo đẹp", "200.00"));


        //thay vì fix cứng dữ liệu, mình sẽ call api

        ApiController.apiService.getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()){
                    productList = response.body();

                    productAdapter = new ProductAdapter(productList, MainActivity2.this);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity2.this, RecyclerView.VERTICAL, false);

                    revProducts.setAdapter(productAdapter);
                    revProducts.setLayoutManager(layoutManager);

                }else {
                    Toast.makeText(MainActivity2.this, "Lỗi server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "Lỗi đường truyền", Toast.LENGTH_SHORT).show();
            }
        });
    }
}