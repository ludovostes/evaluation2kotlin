package be.ludovostes.connexion

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class BlogActivity : AppCompatActivity() {

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        loginEditText = findViewById(R.id.editTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        loginButton = findViewById(R.id.loginButton)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)

        loginButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (isValidCredentials(login, password, confirmPassword)) {
                showSuccessfulLogin()
            } else {
                showLoginErrorDialog()
            }
        }
    }

    private fun isValidCredentials(login: String, password: String, confirmPassword: String): Boolean {
        return login.isNotEmpty() && password.isNotEmpty() && login.contains("@") && password == confirmPassword
    }

    private fun showLoginErrorDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Erreur de connexion")

        val passwordMismatchMessage = "Les mots de passe ne correspondent pas"
        alertDialogBuilder.setMessage(if (passwordEditText.text.toString() != confirmPasswordEditText.text.toString()) passwordMismatchMessage else "Identifiants incorrects")

        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showSuccessfulLogin() {
        val intent = Intent(this, SuccessfulLoginBlogActivity::class.java)
        startActivity(intent)
    }
}