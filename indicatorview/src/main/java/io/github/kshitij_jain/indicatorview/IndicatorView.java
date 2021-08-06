package io.github.kshitij_jain.indicatorview;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.render.Canvas;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.app.Context;

/**
 * Custom component to add an indicator to show current Page in a PageSlider.
 */
public class IndicatorView extends Component implements Component.DrawTask,
    Component.EstimateSizeListener {

  private Context context;
  private Paint activeIndicatorPaint;
  private Paint inactiveIndicatorPaint;
  private int diameter;
  private int size;
  private int position;
  private int indicatorsCount;

  public IndicatorView(Context context) {
    super(context);
    init(context, null);
  }

  public IndicatorView(Context context, AttrSet attrSet) {
    super(context, attrSet);
    init(context, attrSet);
  }

  public IndicatorView(Context context, AttrSet attrSet, String styleName) {
    super(context, attrSet, styleName);
    init(context, attrSet);
  }

  public IndicatorView(Context context, AttrSet attrSet, int defStyle) {
    super(context, attrSet, defStyle);
    init(context, attrSet);
  }

  private void init(Context context, AttrSet attrSet) {
    this.context = context;

    Color activeColor = AttrUtil.getColorFromAttrSet(attrSet, "activeColor",
        ResourceUtil.getColor(this.context, ResourceTable.Color_default_active_color));
    activeIndicatorPaint = new Paint();
    activeIndicatorPaint.setColor(activeColor);
    activeIndicatorPaint.setAntiAlias(true);

    Color inactiveColor = AttrUtil.getColorFromAttrSet(attrSet, "inactiveColor",
        ResourceUtil.getColor(this.context, ResourceTable.Color_default_inactive_color));
    inactiveIndicatorPaint = new Paint();
    inactiveIndicatorPaint.setColor(inactiveColor);
    inactiveIndicatorPaint.setAntiAlias(true);

    diameter = AttrUtil.getDimensionFromAttrSet(attrSet, "indicatorSize",
        ResourceUtil.getDimension(this.context, ResourceTable.Float_indicator_size));
    size = diameter * 2;

    addDrawTask(this);
    setEstimateSizeListener(this);
  }

  @Override
  public void onDraw(Component component, Canvas canvas) {
    for (int i = 0; i < indicatorsCount; i++) {
      canvas.drawCircle(diameter + (size * i), diameter, diameter / 2f,
          inactiveIndicatorPaint);
    }
    canvas.drawCircle(diameter + (size * position), diameter, diameter / 2f,
        activeIndicatorPaint);
  }

  @Override
  public boolean onEstimateSize(int widthEstimateSpec, int heightEstimateSpec) {
    setEstimatedSize(estimateWidth(widthEstimateSpec), estimateHeight(heightEstimateSpec));
    return true;
  }

  private int estimateWidth(int estimateSpec) {
    int result;
    int specMode = EstimateSpec.getMode(estimateSpec);
    int specSize = EstimateSpec.getSize(estimateSpec);

    if (specMode == EstimateSpec.PRECISE) {
      result = specSize;
    } else {
      result = size * indicatorsCount + getPaddingLeft() + getPaddingRight();
      if (specMode == EstimateSpec.NOT_EXCEED) {
        result = Math.min(result, specSize);
      }
    }
    return EstimateSpec.getChildSizeWithMode(result, specMode, specMode);
  }

  private int estimateHeight(int estimateSpec) {
    int result;
    int specMode = EstimateSpec.getMode(estimateSpec);
    int specSize = EstimateSpec.getSize(estimateSpec);

    if (specMode == EstimateSpec.PRECISE) {
      result = specSize;
    } else {
      result = size + getPaddingTop() + getPaddingBottom();
      if (specMode == EstimateSpec.NOT_EXCEED) {
        result = Math.min(result, specSize);
      }
    }
    return EstimateSpec.getChildSizeWithMode(result, specMode, specMode);
  }

  /**
   * Set current page position.
   *
   * @param position Current page position
   */
  public void setCurrentPage(int position) {
    this.position = position;
    invalidate();
  }

  /**
   * Set number of page indicators.
   *
   * @param size Number of page indicators
   */
  public void setPageIndicators(int size) {
    indicatorsCount = size;
    invalidate();
  }

  /**
   * Set color of inactive page indicator dots.
   *
   * @param colorRes Resource ID of color to be set
   */
  public void setInactiveIndicatorColor(int colorRes) {
    inactiveIndicatorPaint.setColor(ResourceUtil.getColor(context, colorRes));
    invalidate();
  }

  /**
   * Set color of active page indicator dot.
   *
   * @param colorRes Resource ID of color to be set
   */
  public void setActiveIndicatorColor(int colorRes) {
    activeIndicatorPaint.setColor(ResourceUtil.getColor(context, colorRes));
    invalidate();
  }

  /**
   * Get inactive indicator color for testing.
   *
   * @return inactive indicator color
   */
  public Color getInactiveIndicatorColor() {
    return inactiveIndicatorPaint.getColor();
  }

  /**
   * Get active indicator color for testing.
   *
   * @return active indicator color
   */
  public Color getActiveIndicatorColor() {
    return activeIndicatorPaint.getColor();
  }

  /**
   * Get number of indicator count for testing.
   *
   * @return number of indicators
   */
  public int getIndicatorCount() {
    return indicatorsCount;
  }

  /**
   * Get current active indicator position for testing.
   *
   * @return current indicator position
   */
  public int getCurrentPosition() {
    return position;
  }
}
