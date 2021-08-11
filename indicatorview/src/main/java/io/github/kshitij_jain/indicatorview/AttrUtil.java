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

package io.github.kshitij_jain.indicatorview;

import ohos.agp.components.AttrSet;
import ohos.agp.utils.Color;

/**
 * Helper Class to get Attr values.
 */
class AttrUtil {

  private AttrUtil() {
    // Private constructor
  }

  /**
   * Get color attribute defined in "attrSet" with "name". If not set returns "defaultColor".
   *
   * @param attrSet      AttrSet defined for the IndicatorView
   * @param name         Name of the color attribute
   * @param defaultColor Default Color to be returned if attribute not set
   * @return color attribute defined in "attrSet" with "name"
   */
  public static Color getColorFromAttrSet(AttrSet attrSet, String name, Color defaultColor) {
    Color result = defaultColor;
    if (attrSet != null && attrSet.getAttr(name).isPresent()) {
      result = attrSet.getAttr(name).get().getColorValue();
    }
    return result;
  }

  /**
   * Get dimension attribute defined in "attrSet" with "name". If not set returns "defaultDimes".
   *
   * @param attrSet      AttrSet defined for the IndicatorView
   * @param name         Name of the dimension attribute
   * @param defaultDimes Default dimension to be returned if attribute not set
   * @return dimension attribute defined in "attrSet" with "name"
   */
  public static int getDimensionFromAttrSet(AttrSet attrSet, String name, int defaultDimes) {
    int value = defaultDimes;
    if (attrSet != null && attrSet.getAttr(name).isPresent()) {
      value = attrSet.getAttr(name).get().getDimensionValue();
    }
    return value;
  }
}
