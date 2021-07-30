# Android Humanizer
[ ![Download](https://api.bintray.com/packages/pratikvar/Humanizer/humanizer/images/download.svg?version=1.1.2) ](https://bintray.com/pratikvar/Humanizer/humanizer/1.1.2/link)
[![](https://jitpack.io/v/pratikvar/Humanizer.svg)](https://jitpack.io/#pratikvar/Humanizer)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Humanizer-blue.svg?style=flat)](https://android-arsenal.com/details/1/7834)

Humanizer allows you to display data in a human-readable format for simplicity.

## Features
### Humanize String
Humanizer give a human-readable touch to string (user input without proper formatting, system created, non-formatted)

### Humanize Date
Humanizer can convert date object, date string as well as millis to human readable date and time format with multiple variations. 
Using Pretty_Everything format you can show relevant date representation.

## Getting Started
### Setting up the dependency
The first step is to include Humanizer into your project, for example, as a Gradle compile dependency:
```
implementation("com.skybase.humanizer:humanizer:1.1.2")
```
### Usage
```
yourDateView.setText(DateHumanizer.humanize(yourSelectedDate,DateHumanizer.TYPE_PRETTY_EVERYTHING));
yourTimeView.setText(DateHumanizer.humanize(yourSelectedDate,DateHumanizer.TYPE_DATE_DISABLE,DateHumanizer.TYPE_TIME_HH_MM_A));

yourSummaryTextView.setText(TextHumanizer.humanize(userInputtedString,TextHumanizer.SENTENCE));
yourUserName.setText(TextHumanizer.humanize(userInputtedString,TextHumanizer.NAME));
```

### Feel free to contribute and report bugs, if any :innocent:


### LICENSE
```
Copyright 2019 Pratik Vartak

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
