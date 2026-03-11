# Watchdog Android App

A minimal Android watchdog app built with Jetpack Compose.

## Features

- User enters an app package name
- Toggle to enable watchdog monitoring
- Background service checks foreground app
- If monitored app opens, a full-screen overlay appears

⚠️ App Detected. Take a breath.

User can dismiss the overlay and monitoring continues.

## How it Works

The app uses Android UsageStatsManager to detect which app is currently in the foreground.

## Permission Used

PACKAGE_USAGE_STATS

This permission allows the app to read usage statistics to determine which application is currently active.
