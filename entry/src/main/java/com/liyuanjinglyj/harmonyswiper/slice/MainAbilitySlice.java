package com.liyuanjinglyj.harmonyswiper.slice;

import com.liyuanjinglyj.harmonyswiper.ResourceTable;
import com.liyuanjinglyj.harmonyswiper.adapter.SwiperPageSliderProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.PageSlider;
import ohos.agp.components.PageSliderIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {
    private PageSlider pageSlider;
    private PageSliderIndicator pageSliderIndicator;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        this.pageSlider=(PageSlider)findComponentById(ResourceTable.Id_ability_main_pageslider);
        this.pageSliderIndicator=(PageSliderIndicator)findComponentById(ResourceTable.Id_ability_main_pagesliderindicator);
        this.pageSlider.setProvider(new SwiperPageSliderProvider(getData(),this));
        this.pageSliderIndicator.setItemOffset(60);
        this.pageSliderIndicator.setPageSlider(pageSlider);
    }

    private List<SwiperPageSliderProvider.ImageSwiper> getData() {
        List<SwiperPageSliderProvider.ImageSwiper> imageSwiperList = new ArrayList<>();
        imageSwiperList.add(new SwiperPageSliderProvider.ImageSwiper(ResourceTable.Graphic_11));
        imageSwiperList.add(new SwiperPageSliderProvider.ImageSwiper(ResourceTable.Graphic_12));
        imageSwiperList.add(new SwiperPageSliderProvider.ImageSwiper(ResourceTable.Graphic_13));
        imageSwiperList.add(new SwiperPageSliderProvider.ImageSwiper(ResourceTable.Graphic_14));
        imageSwiperList.add(new SwiperPageSliderProvider.ImageSwiper(ResourceTable.Graphic_15));
        return imageSwiperList;
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
