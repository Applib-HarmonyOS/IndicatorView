/**
 * Copyright 2021 Application Library Engineering Group.
 */

package io.github.kshitij_jain.indicatorview;

import java.io.IOException;
import ohos.agp.utils.Color;
import ohos.app.Context;
import ohos.global.resource.NotExistException;
import ohos.global.resource.WrongTypeException;

/**
 * Helper class to get element with resource id.
 */
class ResourceUtil {

  /**
   * Get Color defined in resource ID.
   *
   * @param context    The context
   * @param resourceId Resource ID of Color
   * @return Color defined in resourceId else null if not found
   */
  public static Color getColor(Context context, int resourceId) {
    Color color = null;
    try {
      color = new Color(context.getResourceManager().getElement(resourceId).getColor());
    } catch (IOException | NotExistException | WrongTypeException e) {
      e.printStackTrace();
    }
    return color;
  }

  /**
   * Get dimension defined in resource ID.
   *
   * @param context    The context
   * @param resourceId Resource ID of dimension
   * @return Color defined in resourceId else -1 if not found
   */
  public static int getDimension(Context context, int resourceId) {
    int dimes = -1;
    try {
      dimes = (int) (context.getResourceManager().getElement(resourceId).getFloat());
    } catch (IOException | NotExistException | WrongTypeException e) {
      e.printStackTrace();
    }
    return dimes;
  }
}
