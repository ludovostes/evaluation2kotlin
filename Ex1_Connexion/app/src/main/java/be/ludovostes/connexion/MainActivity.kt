package be.ludovostes.connexion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openTwitterActivity(view: View) {
        val intent = Intent(this, TwitterActivity::class.java)
        startActivity(intent)
    }

    fun openFacebookActivity(view: View) {
        val intent = Intent(this, FacebookActivity::class.java)
        startActivity(intent)
    }

    fun openBlogActivity(view: View) {
        val intent = Intent(this, BlogActivity::class.java)
        startActivity(intent)
    }
}