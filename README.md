# RegistrationForm

Preprosta Android aplikacija za registracijo uporabnika, izdelana v programskem jeziku **Java** z uporabo **XML** za oblikovanje uporabniškega vmesnika.

Projekt je bil razvit v okolju Android Studio kot del šolske naloge pri predmetu Razvoj mobilnih aplikacij.

## Funkcionalnosti

- Vnos osnovnih uporabniških podatkov (uporabniško ime, ime in priimek, država, e-pošta, telefonska številka in geslo).
- Izbira spola z uporabo `RadioGroup` in `RadioButton`.
- Potrditev pogojev uporabe z `CheckBox`.
- Prikaz vnesenih podatkov v pogovornem oknu `AlertDialog`.
- Prilagodljiv obrazec z možnostjo pomikanja po zaslonu (`ScrollView`).

## Uporabljene tehnologije

| Tehnologija | Namen |
|---|---|
| Java | Programska logika aplikacije |
| XML | Oblikovanje uporabniškega vmesnika |
| Android Studio | Razvojno okolje |
| Gradle | Gradnja in upravljanje projekta |

## Delovanje aplikacije

Uporabnik izpolni registracijski obrazec, izbere spol in po želji potrdi pogoje uporabe.

Ob pritisku na gumb **Create account** aplikacija prebere vnesene podatke in jih prikaže v pogovornem oknu z naslovom **Registration Details**.

Aplikacija je demonstracijske narave in ne izvaja dejanske registracije ali shranjevanja uporabniških podatkov.

## Zagon projekta

1. Prenesite ali klonirajte repozitorij.
2. Odprite projekt v Android Studiu.
3. Počakajte, da se zaključi sinhronizacija Gradle.
4. Izberite Android emulator ali fizično napravo.
5. Zaženite aplikacijo z gumbom **Run**.

## Namen projekta

Cilj projekta je spoznati osnovne gradnike Android uporabniškega vmesnika, pridobivanje podatkov iz vnosnih polj ter obdelavo uporabniških dogodkov v programskem jeziku Java.

Projekt je namenjen izključno izobraževalnim namenom.
