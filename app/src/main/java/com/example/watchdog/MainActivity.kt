package com.example.watchdog

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Open Usage Access settings so user can enable it
        startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))

        setContent {

            var pkg by remember { mutableStateOf(Prefs.getPackage(this)) }
            var enabled by remember { mutableStateOf(false) }

            MaterialTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {

                    Text("Watchdog Settings")

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = pkg,
                        onValueChange = { pkg = it },
                        label = { Text("Package name") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Row {

                        Text("Watchdog ON")

                        Spacer(modifier = Modifier.width(16.dp))

                        Switch(
                            checked = enabled,
                            onCheckedChange = { isOn ->

                                enabled = isOn
                                Prefs.setPackage(this@MainActivity, pkg)

                                if (isOn) {

                                    val intent = Intent(
                                        this@MainActivity,
                                        WatchdogService::class.java
                                    )

                                    startService(intent)

                                } else {

                                    stopService(
                                        Intent(
                                            this@MainActivity,
                                            WatchdogService::class.java
                                        )
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}