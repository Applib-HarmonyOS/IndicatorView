package io.github.kshitij_jain.circularindicatorview.slice;

import io.github.kshitij_jain.circularindicatorview.ResourceTable;
import java.util.List;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.PageSliderProvider;
import ohos.agp.components.Text;

/**
 * Custom PageSlider provider to show a text in each Page.
 */
public class TextPageSliderProvider extends PageSliderProvider {

  private final List<String> dataList;

  public TextPageSliderProvider(List<String> list) {
    this.dataList = list;
  }

  @Override
  public int getCount() {
    return dataList.size();
  }

  @Override
  public Object createPageInContainer(ComponentContainer componentContainer, int i) {
    Component pageSlide =
        LayoutScatter.getInstance(componentContainer.getContext())
            .parse(ResourceTable.Layout_page_slider, componentContainer, false);
    Text pageText = (Text) pageSlide.findComponentById(ResourceTable.Id_page_slider_text);
    pageText.setText(dataList.get(i));
    componentContainer.addComponent(pageSlide);
    return pageSlide;
  }

  @Override
  public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
    componentContainer.removeComponent((Component) o);
  }

  @Override
  public boolean isPageMatchToObject(Component component, Object o) {
    return component == o;
  }
}
