package com.example.seniordesignproject.Interface;

import com.example.seniordesignproject.Model.Banner;

import java.util.List;

public interface IBannerLoadListener {
    void OnBannerLoadSuccess(List<Banner> banners);

    void onBannerLoadFailed(String message);
}
