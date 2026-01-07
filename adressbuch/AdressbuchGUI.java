import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Alternative GUI für das Adressbuch-Programm.
 * Zeigt alle Kontakte untereinander in einer Liste an.
 */
public class AdressbuchGUI extends JFrame {
    private Adressbuch controller;
    private JPanel kontaktListePanel;
    private JScrollPane scrollPane;
    private JButton btnHinzufuegen;
    private JButton btnAktualisieren;
    private JButton btnSuchen;
    private JTextField suchfeld;
    private boolean suchModus = false;

    /**
     * Konstruktor der GUI.
     */
    public AdressbuchGUI() {
        super("Adressbuch - Listenansicht");
        controller = new Adressbuch();
        
        // Beispieldaten einfügen
        controller.erstelleBeispieldaten();
        
        // GUI initialisieren
        initGUI();
        
        // Kontakte anzeigen
        aktualisiereKontaktListe();
    }

    /**
     * Initialisiert die GUI-Komponenten.
     */
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout(10, 10));

        // Überschrift
        JLabel ueberschrift = new JLabel("Alle Kontakte", SwingConstants.CENTER);
        ueberschrift.setFont(new Font("SansSerif", Font.BOLD, 18));
        ueberschrift.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(ueberschrift, BorderLayout.NORTH);

        // Panel für Kontaktliste
        kontaktListePanel = new JPanel();
        kontaktListePanel.setLayout(new BoxLayout(kontaktListePanel, BoxLayout.Y_AXIS));
        kontaktListePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ScrollPane für die Kontaktliste
        scrollPane = new JScrollPane(kontaktListePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // Panel für Buttons und Suche
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Suchfeld erstellen
        suchfeld = new JTextField(15);
        suchfeld.addActionListener(e -> kontaktSuchen());

        // Buttons erstellen
        btnSuchen = new JButton("Suchen");
        btnHinzufuegen = new JButton("Neuer Kontakt");
        btnAktualisieren = new JButton("Alle anzeigen");

        // Event-Listener hinzufügen
        btnSuchen.addActionListener(e -> kontaktSuchen());
        btnHinzufuegen.addActionListener(e -> kontaktHinzufuegen());
        btnAktualisieren.addActionListener(e -> alleAnzeigen());

        // Komponenten zum Panel hinzufügen
        buttonPanel.add(btnHinzufuegen);
        buttonPanel.add(btnAktualisieren);
        buttonPanel.add(suchfeld);
        buttonPanel.add(btnSuchen);
        buttonPanel.add(new JSeparator(SwingConstants.VERTICAL));

        add(buttonPanel, BorderLayout.SOUTH);

        // Fenster zentrieren
        setLocationRelativeTo(null);
    }

    /**
     * Aktualisiert die Anzeige aller Kontakte.
     */
    private void aktualisiereKontaktListe() {
        // Altes Panel leeren
        kontaktListePanel.removeAll();

        // Im Suchmodus: nur den gefundenen Kontakt anzeigen
        if (suchModus) {
            Kontakt gefundenerKontakt = controller.getAktuellerKontakt();
            if (gefundenerKontakt != null) {
                JPanel kontaktPanel = erstelleKontaktPanel(gefundenerKontakt, 1);
                kontaktListePanel.add(kontaktPanel);
            }
        } else {
            // Normale Ansicht: alle Kontakte anzeigen
            int anzahl = controller.anzahlKontakte();

            if (anzahl == 0) {
                JLabel keinKontakt = new JLabel("Keine Kontakte vorhanden");
                keinKontakt.setFont(new Font("SansSerif", Font.ITALIC, 14));
                keinKontakt.setAlignmentX(Component.CENTER_ALIGNMENT);
                kontaktListePanel.add(keinKontakt);
            } else {
                // Alle Kontakte durchlaufen und anzeigen
                controller.zumAnfang();
                int index = 1;
                
                while (controller.getAktuellerKontakt() != null) {
                    Kontakt kontakt = controller.getAktuellerKontakt();
                    
                    // Panel für einen einzelnen Kontakt erstellen
                    JPanel kontaktPanel = erstelleKontaktPanel(kontakt, index);
                    kontaktListePanel.add(kontaktPanel);
                    
                    // Abstand zwischen Kontakten
                    kontaktListePanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    
                    controller.zumNaechsten();
                    index++;
                }
            }
        }

        // Panel aktualisieren
        kontaktListePanel.revalidate();
        kontaktListePanel.repaint();
    }

    /**
     * Erstellt ein Panel für einen einzelnen Kontakt.
     * 
     * @param kontakt Der anzuzeigende Kontakt
     * @param nummer Die laufende Nummer des Kontakts
     * @return Ein JPanel mit den Kontaktdaten
     */
    private JPanel erstelleKontaktPanel(Kontakt kontakt, int nummer) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 5));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panel.setBackground(Color.WHITE);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        // Nummer
        JLabel nummerLabel = new JLabel(String.format("%d.", nummer));
        nummerLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nummerLabel.setPreferredSize(new Dimension(40, 60));
        panel.add(nummerLabel, BorderLayout.WEST);

        // Kontaktdaten
        JPanel datenPanel = new JPanel();
        datenPanel.setLayout(new BoxLayout(datenPanel, BoxLayout.Y_AXIS));
        datenPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(kontakt.getVorname() + " " + kontakt.getNachname());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        JLabel telLabel = new JLabel("Tel: " + kontakt.getTelNr());
        telLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        telLabel.setForeground(Color.DARK_GRAY);

        datenPanel.add(nameLabel);
        datenPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        datenPanel.add(telLabel);

        panel.add(datenPanel, BorderLayout.CENTER);

        // Hover-Effekt
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(new Color(240, 240, 240));
                datenPanel.setBackground(new Color(240, 240, 240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.WHITE);
                datenPanel.setBackground(Color.WHITE);
            }
        });

        return panel;
    }

    /**
     * Sucht einen Kontakt nach Vorname mit der Adressbuch-Methode.
     */
    private void kontaktSuchen() {
        String suchbegriff = suchfeld.getText().trim();
        
        if (suchbegriff.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Bitte einen Vornamen eingeben!", 
                "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verwende die sucheNachVorname-Methode aus Adressbuch
        boolean gefunden = controller.sucheNachVorname(suchbegriff);
        
        if (gefunden) {
            suchModus = true;
            aktualisiereKontaktListe();
            JOptionPane.showMessageDialog(this, 
                "Kontakt gefunden!", 
                "Erfolg", JOptionPane.INFORMATION_MESSAGE);
        } else {
            suchModus = false;
            JOptionPane.showMessageDialog(this, 
                "Kein Kontakt mit dem Vornamen '" + suchbegriff + "' gefunden.", 
                "Nicht gefunden", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Zeigt alle Kontakte an und setzt die Suche zurück.
     */
    private void alleAnzeigen() {
        suchModus = false;
        suchfeld.setText("");
        aktualisiereKontaktListe();
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
                controller.kontaktHinzufuegen(vorname, nachname, telNr);
                aktualisiereKontaktListe();
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
}
