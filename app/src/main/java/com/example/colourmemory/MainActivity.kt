package com.example.colourmemory

import android.content.ContentUris
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.example.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Srikant on 02/05/2021.
 */

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun getContentViewId(): Int = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val result = mutableListOf<Uri>()
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//        val projection = arrayOf(MediaStore.Images.Media._ID, MediaStore.Images.Media.DISPLAY_NAME)
        val projection = arrayOf(
            MediaStore.Downloads._ID
        )

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            applicationContext.contentResolver.query(
                MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL),
                projection,
                null,
                null,
                null
            ).use { cursor ->
                while (cursor!!.moveToNext()) {
                    Log.e("Cursor", "Hello")
                }
            }
        }
//        contentResolver.query(uri, projection, null, null, null)?.use {
//            while (it.moveToNext()) {
//                result.add(
//                    ContentUris.withAppendedId(
//                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                        it.getLong(0)
//                    )
//                )
//                Log.e("Cursor", "Hello")
//            }
//        }
    }
}