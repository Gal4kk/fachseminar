import javax.swing.*;
import java.awt.*;

/**
 * GUI für das Adressbuch-Programm.
 * Ermöglicht die Navigation durch eine Liste von Kontakten.
 */
public class AdressbuchGUI extends JFrame {
    private List<Kontakt> kontaktListe;
    private JTextArea anzeigeBereich;
    private JButton btnAnfang;
    private JButton btnWeiter;
    private JButton btnEnde;
    private JButton btnHinzufuegen;
    private JButton btnSuchen;

    /**
     * Konstruktor der GUI.
     */
    public AdressbuchGUI() {
        super("Adressbuch");
        kontaktListe = new List<Kontakt>();
        
        // Beispieldaten einfügen
        erstelleBeispieldaten();
        
        // GUI initialisieren
        initGUI();
        
        // Ersten Kontakt anzeigen
        kontaktListe.toFirst();
        aktualisiereAnzeige();
    }

    /**
     * Erstellt 10 fiktive Beispielkontakte.
     */
    private void erstelleBeispieldaten() {
        kontaktListe.append(new Kontakt("Max", "Mustermann", "0221-123456"));
        kontaktListe.append(new Kontakt("Anna", "Schmidt", "0211-234567"));
        kontaktListe.append(new Kontakt("Peter", "Müller", "0221-345678"));
        kontaktListe.append(new Kontakt("Laura", "Weber", "0211-456789"));
        kontaktListe.append(new Kontakt("Tim", "Wagner", "0221-567890"));
        kontaktListe.append(new Kontakt("Sarah", "Becker", "0211-678901"));
        kontaktListe.append(new Kontakt("Marc", "Hoffmann", "0221-789012"));
        kontaktListe.append(new Kontakt("Julia", "Schneider", "0211-890123"));
        kontaktListe.append(new Kontakt("Felix", "Fischer", "0221-901234"));
        kontaktListe.append(new Kontakt("Lisa", "Richter", "0211-012345"));
    }

    /**
     * Initialisiert die GUI-Komponenten.
     */
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new BorderLayout(10, 10));

        // Anzeigebereich für Kontaktdaten
        anzeigeBereich = new JTextArea();
        anzeigeBereich.setEditable(false);
        anzeigeBereich.setFont(new Font("Monospaced", Font.PLAIN, 14));
        anzeigeBereich.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(anzeigeBereich);
        add(scrollPane, BorderLayout.CENTER);

        // Panel für Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Buttons erstellen
        btnAnfang = new JButton("Anfang");
        btnWeiter = new JButton("Weiter");
        btnEnde = new JButton("Ende");
        btnHinzufuegen = new JButton("Hinzufügen");
        btnSuchen = new JButton("Suchen");

        // Event-Listener hinzufügen
        btnAnfang.addActionListener(e -> zumAnfang());
        btnWeiter.addActionListener(e -> zumNaechsten());
        btnEnde.addActionListener(e -> zumEnde());
        btnHinzufuegen.addActionListener(e -> kontaktHinzufuegen());
        btnSuchen.addActionListener(e -> kontaktSuchen());

        // Buttons zum Panel hinzufügen
        buttonPanel.add(btnAnfang);
        buttonPanel.add(btnWeiter);
        buttonPanel.add(btnEnde);
        buttonPanel.add(btnHinzufuegen);
        buttonPanel.add(btnSuchen);

        add(buttonPanel, BorderLayout.SOUTH);

        // Fenster zentrieren
        setLocationRelativeTo(null);
    }

    /**
     * Aktualisiert die Anzeige mit dem aktuellen Kontakt.
     */
    private void aktualisiereAnzeige() {
        if (kontaktListe.hasAccess()) {
            Kontakt aktuellerKontakt = kontaktListe.getContent();
            anzeigeBereich.setText(
                "Vorname:    " + aktuellerKontakt.getVorname() + "\n" +
                "Nachname:   " + aktuellerKontakt.getNachname() + "\n" +
                "Telefon:    " + aktuellerKontakt.getTelNr()
            );
        } else {
            anzeigeBereich.setText("Kein Kontakt verfügbar");
        }
    }

        /**
     * Öffnet einen Dialog zum Hinzufügen eines neuen Kontakts.
     */
    private void kontaktHinzufuegen() {
        JTextField vornameField = new JTextField();
        JTextField nachnameField = new JTextField();
        JTextField telNrField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Vorname:"));
        panel.add(vornameField);
        panel.add(new JLabel("Nachname:"));
        panel.add(nachnameField);
        panel.add(new JLabel("Telefon:"));
        panel.add(telNrField);

        int result = JOptionPane.showConfirmDialog(this, panel, 
            "Neuen Kontakt hinzufügen", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String vorname = vornameField.getText().trim();
            String nachname = nachnameField.getText().trim();
            String telNr = telNrField.getText().trim();

            if (!vorname.isEmpty() && !nachname.isEmpty() && !telNr.isEmpty()) {
                kontaktHinzufuegen(vorname, nachname, telNr);
                JOptionPane.showMessageDialog(this, "Kontakt erfolgreich hinzugefügt!", 
                    "Erfolg", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen!", 
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Hauptmethode zum Starten der Anwendung.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdressbuchGUI gui = new AdressbuchGUI();
            gui.setVisible(true);
        });
    }

    /**
     * Springt zum ersten Kontakt in der Liste.
     */
    private void zumAnfang() {
        kontaktListe.toFirst();
        aktualisiereAnzeige();
    }

    /**
     * Geht zum nächsten Kontakt in der Liste.
     */
    private void zumNaechsten() {
        kontaktListe.next();
        aktualisiereAnzeige();
    }

    /**
     * Springt zum letzten Kontakt in der Liste.
     */
    private void zumEnde() {
        kontaktListe.toLast();
        aktualisiereAnzeige();
    }

    private void kontaktHinzufuegen(String vorname, String nachname, String telNr) {
        Kontakt neuerKontakt = new Kontakt(vorname, nachname, telNr);
        kontaktListe.append(neuerKontakt);
        kontaktListe.toLast();
        aktualisiereAnzeige();
    }

    /**
     * Öffnet einen Suchdialog zum Suchen eines Kontakts nach Vorname.
     */
    private void kontaktSuchen() {
        String suchbegriff = JOptionPane.showInputDialog(this, 
            "Bitte Vorname eingeben:", "Kontakt suchen", JOptionPane.PLAIN_MESSAGE);
        
        if (suchbegriff != null && !suchbegriff.trim().isEmpty()) {
            boolean gefunden = sucheNachVorname(suchbegriff.trim());
            
            if (gefunden) {
                aktualisiereAnzeige();
                JOptionPane.showMessageDialog(this, 
                    "Kontakt gefunden!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Kein Kontakt mit dem Vornamen '" + suchbegriff + "' gefunden.", 
                    "Nicht gefunden", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Sucht einen Kontakt nach Vorname und setzt ihn als aktuelles Element.
     * 
     * @param vorname Der zu suchende Vorname
     * @return true, wenn ein Kontakt gefunden wurde, sonst false
     */
    private boolean sucheNachVorname(String vorname) {
        kontaktListe.toFirst();
        
        while (kontaktListe.hasAccess()) {
            Kontakt k = kontaktListe.getContent();
            if (k.getVorname().equals(vorname)) {
                return true;
            }
            kontaktListe.next();
        }
        
        return false;
    }
}
