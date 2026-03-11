package com.example.watchdog
import android.app.Service
import android.app.usage.UsageStatsManager
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log

class WatchdogService : Service() {

    private val handler = Handler(Looper.getMainLooper())

    private val runnable = object : Runnable {

        override fun run() {

            val monitored = Prefs.getPackage(this@WatchdogService)

            val usm = getSystemService(USAGE_STATS_SERVICE) as UsageStatsManager
            val now = System.currentTimeMillis()

            val stats = usm.queryUsageStats(
                UsageStatsManager.INTERVAL_DAILY,
                now - 10000,
                now
            )

            val recent = stats?.maxByOrNull { it.lastTimeUsed }

            if (recent?.packageName == monitored) {

                val intent = Intent(this@WatchdogService, OverlayActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

            handler.postDelayed(this, 3000)
            Log.d("WATCHDOG", "Current app: ${recent?.packageName}")
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        handler.post(runnable)
        return START_STICKY
    }

    override fun onDestroy() {
        handler.removeCallbacks(runnable)
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}