// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?",

                        new Choice(false, "Ausnahmen vom Typ IOException sind unüberprüft (unchecked).                        (1A)"),
                        new Choice(false, "finally-Blöcke werden nur ausgeführt, wenn kein catch-Block passt.                 (1B)"),
                        new Choice(false, "Gibt es mehrere catch-Blöcke, wird der letzte passende ausgeführt.                 (1C)"),
                        new Choice(false, "Das Java-Laufzeitsystem wirft nur unüberprüfte (unchecked) Ausnahmen.              (1D)"),
                        new Choice(true, "Das Ergebnis von getMessage() ist bei der Objekterzeugung festlegbar.              (1E)")
                ),

                new Question(
                        "int f=55, o=1, i=1; while (i < f) o *= ++i; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(false, "o >= f                                                                             (2A)"),
                        new Choice(true, "i >= 1 && i <= 55                                                                  (2B)"),
                        new Choice(true, "o ist das Produkt aller Zahlen von 1 bis i, also 1*...*i                           (2C)"),
                        new Choice(false, "o ist das Produkt aller Zahlen von 1 bis f, also 1*...*f                           (2D)"),
                        new Choice(true, "f == 55                                                                            (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?",

                        new Choice(true, "Kommentare sollen aus Sicht der Anwendung geschrieben sein.                        (3A)"),
                        new Choice(false, "Besonders wenige Kommentare deuten auf schlecht designte Stellen hin.              (3B)"),
                        new Choice(false, "Schleifeninvarianten stehen hauptsächlich bei Variablendeklarationen.              (3C)"),
                        new Choice(true, "Die meisten Kommentare stehen an Schnittstellen (Methoden, Klassen).               (3D)"),
                        new Choice(true, "Vorbedingungen stehen hauptsächlich vor Methodenköpfen.                            (3E)")
                ),

                new Question(
                        "public int sumFrom1To(int g) { return (g * (g + 1)) / 2; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Nachbedingung: Ergebnis hängt nur von g ab.                                        (4A)"),
                        new Choice(false, "Nachbedingung: Gibt (g * (g + 1)) / 2 zurück.                                      (4B)"),
                        new Choice(true, "Nachbedingung: Lässt den Objektzustand unverändert.                                (4C)"),
                        new Choice(true, "Vorbedingung: g >= 1.                                                              (4D)"),
                        new Choice(false, "Vorbedingung: Ergebnis ist für g < 1 nicht die Zahlensumme.                        (4E)")
                ),

                new Question(
                        "a, b und c seien Objektreferenzen ungleich null.\n" +
                        "Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
                        "boolean equals(Object obj)  und  int hashCode()  in Java gelten?",

                        new Choice(false, "a.hashCode() >= 0  gibt  true  zurück.                                             (5A)"),
                        new Choice(true, "Aus  a.hashCode() != b.hashCode()  folgt  !a.equals(b).                            (5B)"),
                        new Choice(true, "Aus  a.equals(b)  und  b.equals(c)  folgt  c.equals(a).                            (5C)"),
                        new Choice(true, "Aus  a.equals(b)  folgt  b.equals(a).                                              (5D)"),
                        new Choice(false, "Aus  a.equals(b)  folgt  !b.equals(a).                                             (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle
            " 1. Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Ausnahmen vom Typ IOException sind unüberprüft (unchecked).                        (1A)\n" +
            "    XXXXXXXXX finally-Blöcke werden nur ausgeführt, wenn kein catch-Block passt.                 (1B)\n" +
            "    XXXXXXXXX Gibt es mehrere catch-Blöcke, wird der letzte passende ausgeführt.                 (1C)\n" +
            "    XXXXXXXXX Das Java-Laufzeitsystem wirft nur unüberprüfte (unchecked) Ausnahmen.              (1D)\n" +
            "    XXXXXXXXX Das Ergebnis von getMessage() ist bei der Objekterzeugung festlegbar.              (1E)\n" +
            "\n" +
            " 2. int f=55, o=1, i=1; while (i < f) o *= ++i; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX o >= f                                                                             (2A)\n" +
            "    XXXXXXXXX i >= 1 && i <= 55                                                                  (2B)\n" +
            "    XXXXXXXXX o ist das Produkt aller Zahlen von 1 bis i, also 1*...*i                           (2C)\n" +
            "    XXXXXXXXX o ist das Produkt aller Zahlen von 1 bis f, also 1*...*f                           (2D)\n" +
            "    XXXXXXXXX f == 55                                                                            (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Kommentare sollen aus Sicht der Anwendung geschrieben sein.                        (3A)\n" +
            "    XXXXXXXXX Besonders wenige Kommentare deuten auf schlecht designte Stellen hin.              (3B)\n" +
            "    XXXXXXXXX Schleifeninvarianten stehen hauptsächlich bei Variablendeklarationen.              (3C)\n" +
            "    XXXXXXXXX Die meisten Kommentare stehen an Schnittstellen (Methoden, Klassen).               (3D)\n" +
            "    XXXXXXXXX Vorbedingungen stehen hauptsächlich vor Methodenköpfen.                            (3E)\n" +
            "\n" +
            " 4. public int sumFrom1To(int g) { return (g * (g + 1)) / 2; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis hängt nur von g ab.                                        (4A)\n" +
            "    XXXXXXXXX Nachbedingung: Gibt (g * (g + 1)) / 2 zurück.                                      (4B)\n" +
            "    XXXXXXXXX Nachbedingung: Lässt den Objektzustand unverändert.                                (4C)\n" +
            "    XXXXXXXXX Vorbedingung: g >= 1.                                                              (4D)\n" +
            "    XXXXXXXXX Vorbedingung: Ergebnis ist für g < 1 nicht die Zahlensumme.                        (4E)\n" +
            "\n" +
            " 5. a, b und c seien Objektreferenzen ungleich null.\n" +
            "    Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
            "    boolean equals(Object obj)  und  int hashCode()  in Java gelten?\n" +
            "    \n" +
            "    XXXXXXXXX a.hashCode() >= 0  gibt  true  zurück.                                             (5A)\n" +
            "    XXXXXXXXX Aus  a.hashCode() != b.hashCode()  folgt  !a.equals(b).                            (5B)\n" +
            "    XXXXXXXXX Aus  a.equals(b)  und  b.equals(c)  folgt  c.equals(a).                            (5C)\n" +
            "    XXXXXXXXX Aus  a.equals(b)  folgt  b.equals(a).                                              (5D)\n" +
            "    XXXXXXXXX Aus  a.equals(b)  folgt  !b.equals(a).                                             (5E)\n" +
            "\n";

    public static final long UID = 10265240699364L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}
