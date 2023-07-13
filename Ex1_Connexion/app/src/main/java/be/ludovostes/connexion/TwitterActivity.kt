package be.ludovostes.connexion

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class TwitterActivity : AppCompatActivity() {

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter)

        loginEditText = findViewById(R.id.loginEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
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
        val intent = Intent(this, SuccessfulLoginTwitterActivity::class.java)
        startActivity(intent)
    }
}

