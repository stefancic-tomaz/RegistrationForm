package com.example.registrationform;

import android.graphics.Rect;
import android.view.View;
import android.widget.ScrollView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void prikazeVnesenePodatke() {
        try (ActivityScenario<MainActivity> zaslon = ActivityScenario.launch(MainActivity.class)) {
            vnesi(zaslon, R.id.uporabnik, "tomaz");
            vnesi(zaslon, R.id.ime, "Tomaz Novak");
            vnesi(zaslon, R.id.drzava, "Slovenija");
            vnesi(zaslon, R.id.email, "tomaz@example.com");
            vnesi(zaslon, R.id.telefon, "+38640123456");
            vnesi(zaslon, R.id.geslo, "Geslo123!");
            klikni(zaslon, R.id.moski);
            klikni(zaslon, R.id.pogoji);
            klikni(zaslon, R.id.ustvari);

            onView(withText("Registration Details")).check(matches(isDisplayed()));
            onView(withText("Username: tomaz\nName: Tomaz Novak\nCountry: Slovenija"
                    + "\nEmail: tomaz@example.com\nPhone: +38640123456\nPassword: Geslo123!"
                    + "\nGender: Male\nTerms Accepted: Yes")).check(matches(isDisplayed()));
            onView(withText("OK")).perform(click());
            pomakni(zaslon, R.id.uporabnik);
            onView(withId(R.id.uporabnik)).check(matches(withText("tomaz")));
        }
    }

    @Test
    public void prikazePrazenObrazec() {
        try (ActivityScenario<MainActivity> zaslon = ActivityScenario.launch(MainActivity.class)) {
            klikni(zaslon, R.id.ustvari);

            onView(withText("Username: \nName: \nCountry: \nEmail: \nPhone: \nPassword: "
                    + "\nGender: Not selected\nTerms Accepted: No")).check(matches(isDisplayed()));
        }
    }

    @Test
    public void ohraniPodatkeInIzbiro() {
        try (ActivityScenario<MainActivity> zaslon = ActivityScenario.launch(MainActivity.class)) {
            vnesi(zaslon, R.id.uporabnik, "ana");
            vnesi(zaslon, R.id.geslo, "Ana123!");
            klikni(zaslon, R.id.moski);
            klikni(zaslon, R.id.zenska);
            onView(withId(R.id.moski)).check(matches(not(isChecked())));
            zaslon.recreate();

            pomakni(zaslon, R.id.uporabnik);
            onView(withId(R.id.uporabnik)).check(matches(withText("ana")));
            pomakni(zaslon, R.id.geslo);
            onView(withId(R.id.geslo)).check(matches(withText("Ana123!")));
            pomakni(zaslon, R.id.zenska);
            onView(withId(R.id.zenska)).check(matches(isChecked()));
            pomakni(zaslon, R.id.pogoji);
            onView(withId(R.id.pogoji)).check(matches(not(isChecked())));
            klikni(zaslon, R.id.ustvari);

            onView(withText("Username: ana\nName: \nCountry: \nEmail: \nPhone: \nPassword: Ana123!"
                    + "\nGender: Female\nTerms Accepted: No")).check(matches(isDisplayed()));
        }
    }

    private void vnesi(ActivityScenario<MainActivity> zaslon, int polje, String besedilo) {
        pomakni(zaslon, polje);
        onView(withId(polje)).perform(replaceText(besedilo), closeSoftKeyboard());
    }

    private void klikni(ActivityScenario<MainActivity> zaslon, int polje) {
        pomakni(zaslon, polje);
        onView(withId(polje)).perform(click());
    }

    private void pomakni(ActivityScenario<MainActivity> zaslon, int polje) {
        zaslon.onActivity(aktivnost -> {
            ScrollView obrazec = aktivnost.findViewById(R.id.obrazec);
            View pogled = aktivnost.findViewById(polje);
            Rect okvir = new Rect();
            pogled.getDrawingRect(okvir);
            obrazec.offsetDescendantRectToMyCoords(pogled, okvir);
            obrazec.scrollTo(0, okvir.top - obrazec.getPaddingTop());
        });
    }
}
