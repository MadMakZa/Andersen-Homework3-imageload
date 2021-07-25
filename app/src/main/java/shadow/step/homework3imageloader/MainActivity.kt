package shadow.step.homework3imageloader

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var imageView: ImageView
    private lateinit var buttonEnter: Button
    private var url: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        imageView = findViewById(R.id.imageView)
        buttonEnter = findViewById(R.id.btnEnter)

//        url = "https://picsum.photos/200"
        urlReader()

    }

    private fun urlReader(){
        buttonEnter.setOnClickListener {
            url = editText.text.toString()
            if (url != "") {
                Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .resize(200,200)
                    .into(imageView)

            }else{
                Toast.makeText(this, "Error load image!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}