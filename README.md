[![Build](https://github.com/applibgroup/IndicatorView/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/IndicatorView/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_IndicatorView&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_IndicatorView)

# IndicatorView

A simple library to add indicators for your Carousel or PageSlider.

## Source

This library has been inspired by [KshitijDroid\\IndicatorView](https://github.com/KshitijDroid/IndicatorView) version 1.25, released on February 27, 2017.

## Features

IndicatorView library module enables adding indicator dots to the PageSlider.

<img src="https://github.com/Kshitij-Jain/IndicatorView/blob/master/Screenshots/screen_1.png" width="512">

Allows customizing the indicator dot size, active and inactive color.

## Dependency

1. For using IndicatorView module in your application, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har

```
 implementation project(path: ':indicatorview')
 testImplementation 'junit:junit:4.13'
```

2. For using IndicatorView module in your application using the har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file

```
 implementation fileTree(dir: 'libs', include: ['*.har'])
 testImplementation 'junit:junit:4.13'
```

3. For using IndicatorView module from a remote repository in your application, add the below dependencies in entry/build.gradle file.

```
 implementation 'dev.applibgroup:indicatorview:1.0.0'
 testImplementation 'junit:junit:4.13'
```

## Usage

### Include following code in your layout:

```
<io.github.kshitij_jain.indicatorview.IndicatorView
    ohos:id="$+id:indicator_view"
    ohos:height="match_content"
    ohos:width="match_content"
    ohos:horizontal_center="true"
    ohos:vertical_center="true"/>
```

### Include following code in your activity:

```
IndicatorView indicatorView = (IndicatorView) findComponentById(ResourceTable.Id_indicator_view);
indicatorView.setPageIndicators(4);
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
      }
});
```
### Supported xml attributes:

```
ohos:activeColor="$color:white" // Set Active Indicator Color
ohos:inactiveColor="$color:black" // Set Inactive Indicator Color
ohos:indicatorSize="15vp" // Set Indicator Dot Size
```

### Other supported methods:

```
indicatorView.setActiveIndicatorColor(ResourceTable.Color_white); // Set Active Indicator Color
indicatorView.setInactiveIndicatorColor(ResourceTable.Color_black); // Set Inactive Indicator Color
```

## License

```
Copyright 2017 Kshitij Jain

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

