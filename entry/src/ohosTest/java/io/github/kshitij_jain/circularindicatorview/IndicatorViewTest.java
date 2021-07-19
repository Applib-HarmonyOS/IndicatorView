package io.github.kshitij_jain.circularindicatorview;

import io.github.kshitij_jain.indicatorview.IndicatorView;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.utils.Color;
import ohos.app.Context;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndicatorViewTest {

  final private transient Context context =
      AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();

  final private transient IndicatorView indicatorView = new IndicatorView(context);

  @Test
  public void testBundleName() {
    final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
    assertEquals("io.github.kshitij_jain.circularindicatorview", actualBundleName);
  }

  /**
   * Test default active indicator color.
   */
  @Test
  public void testDefaultIndicatorColors() {
    assertEquals("Default active indicator color test failed", new Color(0xFFFFFFFF),
        indicatorView.getActiveIndicatorColor());
    assertEquals("Default inactive indicator color test failed", new Color(0x4D000000),
        indicatorView.getInactiveIndicatorColor());
  }

  /**
   * Test set inactive indicator color.
   */
  @Test
  public void testSetIndicatorColors() {
    indicatorView.setActiveIndicatorColor(ResourceTable.Color_blue);
    indicatorView.setInactiveIndicatorColor(ResourceTable.Color_gray);
    assertEquals("Set active indicator color test failed", new Color(0xFF0000FF),
        indicatorView.getActiveIndicatorColor());
    assertEquals("Set inactive indicator color test failed", new Color(0xFF3C3C3C),
        indicatorView.getInactiveIndicatorColor());
  }

  /**
   * Test set indicators count.
   */
  @Test
  public void testSetIndicatorCount() {
    indicatorView.setPageIndicators(5);
    assertEquals("Set indicator count failed", 5, indicatorView.getIndicatorCount());
  }

  /**
   * Test set current indicator position.
   */
  @Test
  public void testSetPosition() {
    indicatorView.setPageIndicators(5);
    indicatorView.setCurrentPage(2);
    assertEquals("Set current page failed", 2, indicatorView.getCurrentPosition());
  }
}