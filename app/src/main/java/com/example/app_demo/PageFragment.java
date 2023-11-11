package com.example.app_demo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.app_demo.Fragments.AddFragment.AddFragment;
import com.example.app_demo.Fragments.HomeFragment.HomeFragment;
import com.example.app_demo.Fragments.SearchFragment.SearchFragment;

public class PageFragment extends FragmentStateAdapter {

    public PageFragment(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AddFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new SearchFragment();
            default:
                return new AddFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
