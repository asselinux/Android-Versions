package ru.asselinux.androidversions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.asselinux.androidversions.data.DataStorage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val android = DataStorage.getVersionsList()
        val versions = DataStorage.getVersionsList()
        val adapter = AndroidAdapter(this, versions) {position ->
            val androids = android[position]
            val intent = DetailsActivity.createIntent(this, androids)
            startActivity(intent)
        }

        androidList.adapter = adapter
    }
}