package com.example.app_demo.Fragments.HomeFragment;

import com.example.app_demo.Models.Hike;

public interface IOnClickHike {
    void iOnClickDelete(Hike hike, int position);
    void iOnClickMore(Hike hike, int position);
    void iOnClickDetail(Hike hike, int position);
}
