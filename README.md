# Android Humanizer

Humanizer allow you to display data in human readable format for simplicity.

## Features
### Humanize String
Humanizer give a human readable touch to string (user input without proper formatting, system created, non formated)

### Humanize Date
Humanizer can convert date object, date string as well as millis to human radable date and time format with multiple variations. 
Using Pretty_Everything format you can show relevent date representation.

## Getting Started
### Setting up the dependency
The first step is to include Humanizer into your project, for example, as a Gradle compile dependency:
```
implementation 'com.skybase.humanizer:humanizer:1.0.2'
```
### Usage
```
yourDateView.setText(DateHumanizer.humanize(yourSelectedDate,DateHumanizer.TYPE_PRETTY_EVERYTHING));
yourTimeView.setText(DateHumanizer.humanize(yourSelectedDate,DateHumanizer.TYPE_DATE_DISABLE,DateHumanizer.TYPE_TIME_HH_MM_A));

yourSummaryTextView.setText(TextHumanizer.humanize(userInputtedString,TextHumanizer.SENTENCE));
yourUserName.setText(TextHumanizer.humanize(userInputtedString,TextHumanizer.NAME));
```

### Feel free to contribute and report bugs, if any :innocent:
