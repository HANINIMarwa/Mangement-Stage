package pk2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interf extends JFrame {

    private GestionImpl gestion; // Instance de GestionImpl
      // constructeur de la classe Interf
    public Interf() {
        gestion = new GestionImpl(); // Initialisation de la gestion

        // Configuration de la fenêtre principale
        setTitle("Stagiaires & Stages");// titre de la fenetre
        setSize(600, 500); // Taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fermer l'interface lorsque on ferme la fenetre
        setLocationRelativeTo(null); // utiliser pour centraliser la fenetre dans l ecran

        // Créer un panneau principal avec un layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Bouton Ajouter Stagiaire et Stage
        JButton btnAjouter = new JButton("Ajouter Stagiaire ou Stage");
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherFormulaireAjouter();// afficher le formulaire
            }
        });
        panel.add(btnAjouter);// ajouter le bouton au panneau

        // Bouton Supprimer Stagiaire et Stage
        JButton btnSupprimer = new JButton("Supprimer Stagiaire ou Stage");
        btnSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherFormulaireSupprimer();//afficher le formulaire pour supprimer
            }
        });
        panel.add(btnSupprimer);

        // Bouton pour Afficher tous les Stagiaires
        JButton btnAfficherStagiaires = new JButton("Afficher tous les Stagiaires");
        btnAfficherStagiaires.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestion.afficherStagaire();// la methode pour affihcer les stagiaires
            }
        });
        panel.add(btnAfficherStagiaires);

        // Bouton pour Afficher tous les Stages
        JButton btnAfficherStages = new JButton("Afficher tous les Stages");
        btnAfficherStages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestion.afficherStagesAvecStagiaires(); //  afficher les stages avec les stagiaires associes+
            }
        });
        panel.add(btnAfficherStages);

        // Bouton Associer Stagiaire à un Stage
        JButton btnAssocier = new JButton("Associer Stagiaire à un Stage");
        btnAssocier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestion.associerStagiaireAStage();//associer un stagaiare a un stage
            }
        });
        panel.add(btnAssocier);

        // Ajouter le panneau au contenu de la fenêtre
        add(panel);

        // Rendre la fenêtre visible
        setVisible(true);
    }

    // Formulaire pour ajouter un stagiaire ou un stage
    private void afficherFormulaireAjouter() {
        String[] options = {"Ajouter un Stagiaire", "Ajouter un Stage"};//tableau contient les deux choix a afficher
        int choix = JOptionPane.showOptionDialog(this, "Que souhaitez-vous ajouter ?",
                "Ajouter", JOptionPane.DEFAULT_OPTION, // pas de bouttons standard
                JOptionPane.INFORMATION_MESSAGE,// infos
                null, options, options[0]);

        if (choix == 0) {
            // Ajouter un stagiaire
            JTextField nomField = new JTextField(10);
            JTextField prenomField = new JTextField(10);
            JTextField ageField = new JTextField(10);
            JTextField niveauEtudeField = new JTextField(10);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 2));
            panel.add(new JLabel("Nom:"));
            panel.add(nomField);
            panel.add(new JLabel("Prénom:"));
            panel.add(prenomField);
            panel.add(new JLabel("Âge:"));
            panel.add(ageField);
            panel.add(new JLabel("Niveau d'étude:"));
            panel.add(niveauEtudeField);
             // afficher la boite pour ajouter stagiaire
            int option = JOptionPane.showConfirmDialog(this, panel, "Ajouter un Stagiaire", JOptionPane.OK_CANCEL_OPTION);
            // verifier si utilisateur a clique ok
            if (option == JOptionPane.OK_OPTION) {
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String age = ageField.getText();
                String niveauEtude = niveauEtudeField.getText();
                // verfier que tout les champs sont remplis aucun champ ne doit etre vide
                if (!nom.isEmpty() && !prenom.isEmpty() && !age.isEmpty() && !niveauEtude.isEmpty()) {
                    Stagiaire stagiaire = new Stagiaire(nom, prenom, age, niveauEtude);
                    gestion.AjouterStagaire(stagiaire);
                    JOptionPane.showMessageDialog(this, "Stagiaire ajouté !");
                } else {
                    JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis.");
                }
            }
        } else if (choix == 1) {
            // Ajouter un stage
            JTextField titreField = new JTextField(10);
            JTextField dureeField = new JTextField(10);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));
            panel.add(new JLabel("Titre du stage:"));
            panel.add(titreField);
            panel.add(new JLabel("Durée du stage:"));
            panel.add(dureeField);

            int option = JOptionPane.showConfirmDialog(this, panel, "Ajouter un Stage", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String titre = titreField.getText();
                String duree = dureeField.getText();

                if (!titre.isEmpty() && !duree.isEmpty()) {
                    Stage stage = new Stage(titre, duree);
                    gestion.ajouterstage(stage);
                    JOptionPane.showMessageDialog(this, "Stage ajouté !");
                } else {
                    JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis.");
                }
            }
        }
    }

    // Formulaire pour supprimer un stagiaire ou un stage
    private void afficherFormulaireSupprimer() {
        String[] options = {"Supprimer un Stagiaire", "Supprimer un Stage"};
        int choix = JOptionPane.showOptionDialog(this, "Que souhaitez-vous supprimer ?",
                "Supprimer", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        if (choix == 0) {
            // Supprimer un stagiaire
            String nom = JOptionPane.showInputDialog(this, "Entrez le nom du stagiaire à supprimer:");
            if (nom != null && !nom.isEmpty()) {
                gestion.Supprimerparnom(nom);
            } else {
                JOptionPane.showMessageDialog(this, "Nom non valide.");
            }
        } else if (choix == 1) {
            // Supprimer un stage
            String titre = JOptionPane.showInputDialog(this, "Entrez le titre du stage à supprimer:");
            if (titre != null && !titre.isEmpty()) {
                gestion.supprimerStage(titre);
            } else {
                JOptionPane.showMessageDialog(this, "Titre non valide.");
            }
        }
    }

    // Méthode main pour lancer l'application
    public static void main(String[] args) {
        new Interf(); // Instancier et afficher la fenêtre principale
    }
}
