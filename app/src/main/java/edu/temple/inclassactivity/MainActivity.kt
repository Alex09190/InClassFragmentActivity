package edu.temple.inclassactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    //lateinit var someVar : Array<Int>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagesViewModel = ViewModelProvider(this)[ImagesViewModel::class.java]

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method

        val fragmentTemp : Fragment = ImageDisplayFragment.newInstance(imageArray)


        imagesViewModel.setImages(imageArray)

        /*
        //this as ImageDisplayFragment
        findViewById<Button>(R.id.displayButton).setOnClickListener() {
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as ImageDisplayFragment).setImage(imageArray)
        }
         */
        /*
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, fragmentTemp)
            //.add(R.id.fragmentContainerView, ImageDisplayFragment())
            .commit()
         */
    }
}