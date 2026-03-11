# Watchdog Android App

A minimal Android watchdog app built with Jetpack Compose.

## Features

- User enters an app package name
- Toggle to enable watchdog monitoring
- Background service checks the foreground app
- If the monitored app opens, a full-screen overlay appears

⚠️ App Detected. Take a breath.

The user can dismiss the overlay and monitoring continues.

---

## Screenshots

<table>
<tr>
<td align="center">

**Main Screen**

<img src="https://raw.githubusercontent.com/mdAkhtar21/watchdog/main/Image/MainScreen.jpeg" width="300"/>

</td>

<td align="center">

**Detection Screen**

<img src="https://raw.githubusercontent.com/mdAkhtar21/watchdog/main/Image/DetechScreen.jpeg" width="300"/>

</td>
</tr>
</table>

---

## Demo Video

Click the image below to watch the demo.

[![Watch Demo](https://raw.githubusercontent.com/mdAkhtar21/watchdog/main/Image/MainScreen.jpeg)](https://raw.githubusercontent.com/mdAkhtar21/watchdog/main/video/watchdog_demo.mp4)

## How it Works

The app uses Android `UsageStatsManager` to detect which application is currently running in the foreground.  
A background service continuously monitors the active app and triggers an overlay when the monitored app is detected.

---

## Permission Used

**PACKAGE_USAGE_STATS**

This permission allows the app to access usage statistics and determine which application is currently active on the device.

---

## Tech Stack

- Kotlin
- Jetpack Compose
- Android Services
- UsageStatsManager API

---

## Author

**Md Akhtar**

GitHub:  
https://github.com/mdAkhtar21
