# greenteam2

An Android app built for "Green Team" — a school or campus environmental initiative. The app helps students find where to report environmental issues (trash, recycling problems, etc.) based on their location within a school district.

## What It Does

The main screen walks you through a series of dropdowns: state, city, grade level, subject, and what kind of help is needed. Based on those selections, it identifies the right campus and routes you through a multi-step process to report or address the issue.

The flow goes: `MainActivity` (filter selection) → `CampusActivity` (pick your campus from a list) → `ChapterActivity` → `StepsActivity` → `ProblemActivity` → `ConfirmActivity`. Each step narrows down the context and eventually confirms the submission.

## Architecture

| File | Purpose |
|------|---------|
| `MainActivity.java` | Entry — five dropdowns for filtering by location/grade/subject/need |
| `CampusActivity.java` | Campus selection list based on filter choices |
| `ChapterActivity.java` | Chapter or group within the campus |
| `StepsActivity.java` | Steps to take for the issue |
| `ProblemActivity.java` | Problem detail entry |
| `ConfirmActivity.java` | Confirmation screen |
| `SuperSpinner.java` | Custom spinner component |
| `GreenExpandableListAdapter.java` | Expandable list adapter for grouped data |

## How to Run

Open in Android Studio. Targets Android 5.x+ (Material Design era, 2016). Build and run on a device or emulator.

## Notes

This is `greenteam2`, implying there was a version 1 somewhere. Built in early 2016. The UI is purely native Android — no third-party frameworks beyond the support library.
