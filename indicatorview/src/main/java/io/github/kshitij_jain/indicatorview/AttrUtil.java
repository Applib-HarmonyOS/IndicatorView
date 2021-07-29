/**
 * Copyright 2021 Application Library Engineering Group.
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
