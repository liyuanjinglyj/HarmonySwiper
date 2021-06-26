package com.liyuanjinglyj.harmonyswiper.adapter;

import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;
import ohos.media.image.PixelMap;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class SwiperPageSliderProvider extends PageSliderProvider {
    private List<ImageSwiper> pixelMapList=new ArrayList<>();
    private AbilitySlice abilitySlice;

    public SwiperPageSliderProvider(List<ImageSwiper> pixelMapList,AbilitySlice abilitySlice) {
        this.pixelMapList=pixelMapList;
        this.abilitySlice=abilitySlice;
    }

    @Override
    public int getCount() {
        return this.pixelMapList == null ? 0 : this.pixelMapList.size();
    }

    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        final ImageSwiper data = this.pixelMapList.get(i);
        Image image = new Image(this.abilitySlice);
        image.setPixelMap(data.resImage);
        image.setLayoutConfig(
                new StackLayout.LayoutConfig(
                        ComponentContainer.LayoutConfig.MATCH_PARENT,
                        ComponentContainer.LayoutConfig.MATCH_PARENT
                ));
        image.setScaleMode(Image.ScaleMode.STRETCH);
        componentContainer.addComponent(image);
        return image;
    }

    @Override
    public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
        componentContainer.removeComponent((Component) o);
    }

    @Override
    public boolean isPageMatchToObject(Component component, Object o) {
        return true;
    }

    public static class ImageSwiper{
        int resImage;
        public ImageSwiper(int imageRes) {
            resImage = imageRes;
        }
    }
}
