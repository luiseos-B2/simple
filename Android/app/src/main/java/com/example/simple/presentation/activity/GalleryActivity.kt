package com.example.simple.presentation.activity


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simple.R
import com.example.simple.utils.SingletonSave
import java.io.FileNotFoundException

const val IMAGE_TYPE = "image/*"
const val GALLERY_REQUEST = 123

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = IMAGE_TYPE
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            try {
                val imageUri: Uri? = data?.data
                SingletonSave.image = imageUri
                finish()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Toast.makeText(this@GalleryActivity, getString(R.string.message_error_gallery), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this@GalleryActivity, getString(R.string.message_have_not_picked_image_gallery), Toast.LENGTH_LONG).show()
        }
    }
}