package com.example.simple.presentation.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)



    }
    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alertImage()

        image_view.setOnClickListener {
            alertImage()
        }

        btn_opportunity.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                btn_service.setBackgroundResource(R.color.colorGray)
                btn_opportunity.setBackgroundResource(R.color.colorBlue)
            }

        })
        btn_service.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                btn_opportunity.setBackgroundResource(R.color.colorGray)
                btn_service.setBackgroundResource(R.color.colorBlue)
            }

        })
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

    fun alertImage(){
        val builder1: AlertDialog.Builder = AlertDialog.Builder(context)
        builder1.setTitle("Escolha a opção!")
        builder1.setPositiveButton(
            "Câmera",
            DialogInterface.OnClickListener { dialog, id ->
                goToCameraActivity()
            })

        builder1.setNegativeButton(
            "Galeria",
            DialogInterface.OnClickListener { dialog, id ->
                goToGalleryActivity()
            })

        val alert11: AlertDialog = builder1.create()
        alert11.show()
    }

    companion object {
        fun newInstance() = PostFragment()
    }
}