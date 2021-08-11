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

import java.io.IOException;
import ohos.agp.utils.Color;
import ohos.app.Context;
import ohos.global.resource.NotExistException;
import ohos.global.resource.WrongTypeException;

/**
 * Helper class to get element with resource id.
 */
class ResourceUtil {

  private ResourceUtil() {
    // Private constructor
  }

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
