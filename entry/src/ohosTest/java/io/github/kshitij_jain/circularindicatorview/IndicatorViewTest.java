/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.kshitij_jain.circularindicatorview;

import io.github.kshitij_jain.indicatorview.IndicatorView;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.utils.Color;
import ohos.app.Context;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndicatorViewTest {

  private final Context context =
      AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
  private final IndicatorView indicatorView = new IndicatorView(context);

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