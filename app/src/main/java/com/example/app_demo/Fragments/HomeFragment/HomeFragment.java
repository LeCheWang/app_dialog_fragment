package com.example.app_demo.Fragments.HomeFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app_demo.Models.Hike;
import com.example.app_demo.R;
import com.example.app_demo.databinding.FragmentHomeBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentHomeBinding binding;

    List<Hike> hikes = new ArrayList<>();

    HikeAdapter hikeAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        //fix cứng dữ liệu (sau này sẽ lấy dữ liệu này từ việc đọc trong database)
        hikes.add(new Hike(1, "Son Dong", "Ha Noi", "11-11-2023", true, 100, "HIGH", "đẹp lắm"));
        hikes.add(new Hike(2, "Ha Noi", "Ha Noi", "11-11-2023", true, 100, "HIGH", "đẹp lắm"));
        hikes.add(new Hike(3, "Ba Vì", "Ha Noi", "11-11-2023", true, 100, "HIGH", "đẹp lắm"));
        hikes.add(new Hike(4, "Tam Đảo", "Ha Noi", "11-11-2023", true, 100, "HIGH", "đẹp lắm"));
        hikes.add(new Hike(5, "Đà Lạt", "Ha Noi", "11-11-2023", true, 100, "HIGH", "đẹp lắm"));

        //hiển thị lên danh sách bằng recycleView
        hikeAdapter = new HikeAdapter(hikes, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        binding.revHikes.setAdapter(hikeAdapter);
        binding.revHikes.setLayoutManager(layoutManager);

        hikeAdapter.setiOnClickHike(new IOnClickHike() {
            @Override
            public void iOnClickDelete(Hike hike, int position) {
                hikes.remove(position);
                hikeAdapter.setHikes(hikes);
            }

            @Override
            public void iOnClickMore(Hike hike, int position) {
                Intent intent = new Intent(getActivity(), ObservationActivity.class);
                intent.putExtra("hike", hike);
                startActivity(intent);
            }

            @Override
            public void iOnClickDetail(Hike hike, int position) {
                Intent intent = new Intent(getActivity(), EditHikeActivity.class);
                intent.putExtra("hike", hike);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}