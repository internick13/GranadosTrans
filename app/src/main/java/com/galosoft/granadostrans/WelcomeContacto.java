package com.galosoft.granadostrans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

public class WelcomeContacto extends AppCompatActivity {

    MaterialEditText edtEmail, edtAsunto, edtMensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_contacto);

        edtEmail = findViewById(R.id.edtEmail);
        edtAsunto = findViewById(R.id.edtSubject);
        edtMensaje = findViewById(R.id.edtMessage);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmai();
            }
        });
    }

    private void sendEmai() {
        String recipientList = edtEmail.getText().toString();
        String[] recipients = recipientList.split(",");
        String subject = edtAsunto.getText().toString();
        String mensaje = edtMensaje.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, mensaje);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Elige tu app para emails"));
    }

}
