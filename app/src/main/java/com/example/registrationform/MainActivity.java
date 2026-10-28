package com.example.registrationform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText poljeUporabnik, poljeIme, poljeDrzava;
    private EditText poljeEmail, poljeTelefon, poljeGeslo;
    private RadioGroup izbiraSpola;
    private CheckBox pogoji;

    @Override
    protected void onCreate(Bundle stanje) {
        super.onCreate(stanje);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View glavno = findViewById(R.id.glavno);
        ViewCompat.setOnApplyWindowInsetsListener(glavno, (pogled, okno) -> {
            Insets odmiki = okno.getInsets(WindowInsetsCompat.Type.systemBars()
                    | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
            pogled.setPadding(odmiki.left, odmiki.top, odmiki.right, odmiki.bottom);
            return okno;
        });

        poljeUporabnik = findViewById(R.id.uporabnik);
        poljeIme = findViewById(R.id.ime);
        poljeDrzava = findViewById(R.id.drzava);
        poljeEmail = findViewById(R.id.email);
        poljeTelefon = findViewById(R.id.telefon);
        poljeGeslo = findViewById(R.id.geslo);
        izbiraSpola = findViewById(R.id.spol);
        pogoji = findViewById(R.id.pogoji);

        Button gumb = findViewById(R.id.ustvari);
        gumb.setOnClickListener(pogled -> prikaziPodatke());
    }

    private void prikaziPodatke() {
        String uporabnik = poljeUporabnik.getText().toString();
        String ime = poljeIme.getText().toString();
        String drzava = poljeDrzava.getText().toString();
        String email = poljeEmail.getText().toString();
        String telefon = poljeTelefon.getText().toString();
        String geslo = poljeGeslo.getText().toString();
        String spol = getString(R.string.ni_izbran);

        int izbranId = izbiraSpola.getCheckedRadioButtonId();
        if (izbranId != -1) {
            RadioButton izbranSpol = findViewById(izbranId);
            spol = izbranSpol.getText().toString();
        }

        String sprejeto = getString(pogoji.isChecked() ? R.string.da : R.string.ne);
        String podatki = getString(R.string.povzetek, uporabnik, ime, drzava,
                email, telefon, geslo, spol, sprejeto);

        new AlertDialog.Builder(this)
                .setTitle(R.string.naslov_povzetka)
                .setMessage(podatki)
                .setPositiveButton(R.string.v_redu, null)
                .show();
    }
}
