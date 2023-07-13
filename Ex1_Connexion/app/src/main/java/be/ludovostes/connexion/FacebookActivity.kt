package be.ludovostes.connexion

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FacebookActivity : AppCompatActivity() {

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook)

        loginEditText = findViewById(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidCredentials(login, password)) {
                showSuccessfulLogin()
            } else {
                showLoginErrorDialog()
            }
        }
    }

    private fun isValidCredentials(login: String, password: String): Boolean {
        return login.isNotEmpty() && password.isNotEmpty() && login.contains("@")
    }

    private fun showLoginErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Erreur de connexion")
            .setMessage("Identifiants incorrects")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showSuccessfulLogin() {
        val intent = Intent(this, SuccessfulLoginFacebookActivity::class.java)
        startActivity(intent)
    }
}