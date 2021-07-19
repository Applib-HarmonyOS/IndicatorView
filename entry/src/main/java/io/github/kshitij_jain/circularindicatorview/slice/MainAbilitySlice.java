
package io.github.kshitij_jain.circularindicatorview.slice;

import io.github.kshitij_jain.circularindicatorview.ResourceTable;
import io.github.kshitij_jain.indicatorview.IndicatorView;
import java.util.Arrays;
import java.util.List;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.PageSlider;

public class MainAbilitySlice extends AbilitySlice {

  private PageSlider pageSlider;
  private IndicatorView indicatorView;
  private Button buttonNext;
  private Button buttonSkip;
  private final List<String> textList = Arrays.asList("Page A", "Page B", "Page C", "Page D");

  @Override
  public void onStart(Intent intent) {
    super.onStart(intent);
    super.setUIContent(ResourceTable.Layout_ability_main);

    initViews();
    setupPageSlider();

    indicatorView.setPageIndicators(textList.size());
    indicatorView.setActiveIndicatorColor(ResourceTable.Color_white);
    indicatorView.setInactiveIndicatorColor(ResourceTable.Color_black);

    buttonNext.setClickedListener(component -> {
      int currentPosition = pageSlider.getCurrentPage();
      if (currentPosition < textList.size() - 1) {
        pageSlider.setCurrentPage(++currentPosition);
      }
    });
  }

  private void initViews() {
    pageSlider = (PageSlider) findComponentById(ResourceTable.Id_page_slider);
    indicatorView = (IndicatorView) findComponentById(ResourceTable.Id_indicator_view);
    buttonNext = (Button) findComponentById(ResourceTable.Id_next_button);
    buttonSkip = (Button) findComponentById(ResourceTable.Id_skip_button);
  }

  private void setupPageSlider() {
    pageSlider.setProvider(new TextPageSliderProvider(textList));
    pageSlider.setSlidingPossible(true);
    pageSlider.addPageChangedListener(new PageSlider.PageChangedListener() {
      @Override
      public void onPageSliding(int i, float v, int i1) {

      }

      @Override
      public void onPageSlideStateChanged(int i) {

      }

      @Override
      public void onPageChosen(int position) {
        indicatorView.setCurrentPage(position);
        if (position == textList.size() - 1) {
          buttonNext.setText(ResourceTable.String_button_text_start);
          buttonSkip.setVisibility(Component.INVISIBLE);
        } else {
          buttonNext.setText(ResourceTable.String_button_text_next);
          buttonSkip.setVisibility(Component.VISIBLE);
        }
      }
    });
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
