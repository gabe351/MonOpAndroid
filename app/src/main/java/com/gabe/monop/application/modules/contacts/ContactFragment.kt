package com.gabe.monop.application.modules.contacts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gabe.monop.R
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment: Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var subjectEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var sendEmailButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_contact, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sendEmailButton = send_email_button
        subjectEditText = contact_subject_edit_text
        messageEditText = contact_message_text_view
        nameEditText = contact_name_edit_text

        sendMessage()
    }

    private fun sendMessage() {

        sendEmailButton.setOnClickListener {
            validateField(nameEditText)
            validateField(subjectEditText)
            validateField(messageEditText)

            if (areAllFieldsValid()) {
                sendEmail(nameEditText.text.toString(), subjectEditText.text.toString(), messageEditText.text.toString())
            }
        }
    }

    private fun sendEmail(name: String, subject: String, content: String) {
        val email = "contatomonop@gmail.com"

        val intent = Intent(Intent.ACTION_SENDTO)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        intent.data = Uri.parse("mailto:$email")
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, "$content\n\nEnviado por: $name")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_FROM_BACKGROUND)
        try {
            activity?.let {
                it.startActivity(intent)
            }
        } catch (e: android.content.ActivityNotFoundException) {
            e.printStackTrace()
            Log.d("Email error:", e.toString())
            Toast.makeText(context,
                "Nenhum aplicativo de email encontrado",
                Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun validateField(field: EditText){
        if (isFieldEmpty(field)) {
            field.error = getString(R.string.required_field_error_message)
        }
    }

    private fun isFieldEmpty(field: EditText): Boolean = field.text.toString().trim().isEmpty()

    private fun areAllFieldsValid(): Boolean =
        !isFieldEmpty(nameEditText)
                && !isFieldEmpty(subjectEditText)
                && !isFieldEmpty(messageEditText)
}