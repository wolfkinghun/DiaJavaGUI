# 🎥 Utazás GUI Projekt

![Utazás GUI](https://res.cloudinary.com/myblogki2024/image/upload/v1745842853/Amf_13_A98_V_diafilmGUI_tghdjp.png)

---

## 📚 Feladatleírás

A `diafilm.csv` fájl különböző diafilmek adatait tartalmazza az alábbi formátumban:

- Adatok elválasztója: pontosvessző (`;`)
- Fájl kódolása: `utf-8`
- **Fontos**: az első sor fejlécet tartalmaz!

Készítsünk egy **UtazasGUI** nevű projektet, és oldjuk meg az alábbi feladatokat!

---

## 🛠️ Feladatok

### 1. Grafikus felület kialakítása (2 pont)
- Hozzuk létre a mintán látható GUI-t.
- A **Fájl** menü tartalmazza:
  - `Megnyitás` (`Ctrl + O`)
  - `Kilépés`
- A **Súgó** menü tartalmazza:
  - `Névjegy` menüpontot
- A lista mérete: **400×400 pixel**, de kövesse az ablak méretét!
- A **ComboBox** szélessége legyen **100 pixel**.
- A diafilmek darabszáma mindig legyen **alul megjelenítve**.
- Induláskor a **Fekete-fehér** és **Színes** opciók is legyenek kiválasztva!
- A GUI elemek NE érjenek össze!

---

### 2. Fájlkezelés és adatbetöltés
- A `Megnyitás` menüpont segítségével válasszunk ki egy `*.csv` fájlt a projekt mappájából. (1 pont)
- Töltsük be az adatokat egy megfelelő adatszerkezetbe. (1 pont)
- Az **évek** (ismétlődés nélkül, növekvő sorrendben) kerüljenek a ComboBoxba. (1 pont)
- A legelső év legyen automatikusan kiválasztva.
- A feltételnek megfelelő diafilmek jelenjenek meg a listában. (1 pont)

---

### 3. Dinamikus frissítés
- A lista frissüljön:
  - ha másik évet választunk, (1 pont)
  - vagy ha változik a **Fekete-fehér / Színes** opció! (1 pont)

---

### 4. Extra funkciók
- A **Súgó** menü `Névjegy` pontja jelenítsen meg információs felugró ablakot. (1 pont)
- A **Fájl** menü `Kilépés` pontja zárja be a programot. (1 pont)

---

## 🆘 Segítségkód

```java
private FileChooser fc = new FileChooser();
fc.setInitialDirectory(new File("./"));
fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Szövegfájlok", "*.txt"));
File fbe = fc.showOpenDialog(lsLista.getScene().getWindow());

---

# 💡 Plusz megjegyzés
- Ügyelj a `utf-8` kódolásra fájlmegnyitáskor!
- Az évek egyedi, növekvő sorrendű kezeléséhez érdemes `TreeSet`-et használni.

---
