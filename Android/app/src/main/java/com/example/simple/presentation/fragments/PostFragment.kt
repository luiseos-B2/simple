package com.example.simple.presentation.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simple.R
import com.example.simple.presentation.activity.CameraActivity
import com.example.simple.presentation.activity.GalleryActivity
import com.example.simple.utils.SingletonSave
import kotlinx.android.synthetic.main.fragment_post.*

class PostFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)


    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alertImage()

        image_view.setOnClickListener {
            alertImage()
        }

        btn_opportunity.setOnClickListener {
            btn_service.setBackgroundResource(R.color.colorGray)
            btn_opportunity.setBackgroundResource(R.color.colorBlue)
        }
        btn_service.setOnClickListener {
            btn_opportunity.setBackgroundResource(R.color.colorGray)
            btn_service.setBackgroundResource(R.color.colorBlue)
        }
    }


    override fun onStart() {
        super.onStart()
        SingletonSave.image?.let {
            image_view.setImageURI(it)
            image_view.setOnClickListener {
                alertImage()
            }
        }
    }

    private fun goToCameraActivity() {
        val intent = Intent(context, CameraActivity::class.java)
        startActivity(intent)
    }

    private fun goToGalleryActivity() {
        val intent = Intent(context, GalleryActivity::class.java)
        startActivity(intent)
    }

    private fun alertImage() {
        val builder1: AlertDialog.Builder = AlertDialog.Builder(context)
        builder1.setTitle(getString(R.string.choose_a_option))
        builder1.setPositiveButton(
                getString(R.string.camera)) { _, _ ->
            goToCameraActivity()
        }

        builder1.setNegativeButton(
                getString(R.string.gallery)) { _, _ ->
            goToGalleryActivity()
        }

        val alert11: AlertDialog = builder1.create()
        alert11.show()
    }

    companion object {
        fun newInstance() = PostFragment()
    }
}