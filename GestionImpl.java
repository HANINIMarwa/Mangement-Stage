package pk2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionImpl implements Gestion { // Implémentation de l'interface Gestion
    private ArrayList<Stagiaire> liststagaire;
    private ArrayList<Stage> liststage;
    private Map<String, ArrayList<Stagiaire>> associations;

    public GestionImpl() {
        this.liststagaire = new ArrayList<>();
        this.liststage = new ArrayList<>();
        this.associations = new HashMap<>();
    }

    // Implémentation de la méthode ajouter()
    @Override
    public void ajouter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Ajouter un stagiaire");
        System.out.println("2. Ajouter un stage");
        int c1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (c1 == 1) {
            // Ajouter un stagiaire
            System.out.print("Nom: ");
            String nom = scanner.nextLine();
            System.out.print("Prénom: ");
            String prenom = scanner.nextLine();
            System.out.print("Age: ");
            String age = scanner.nextLine();
            System.out.print("Niveau d'étude: ");
            String niveauEtude = scanner.nextLine();
            Stagiaire stagiaire = new Stagiaire(nom, prenom, age, niveauEtude);
            AjouterStagaire(stagiaire);
            System.out.println("Stagiaire ajouté.");
        } else if (c1 == 2) {
            // Ajouter un stage
            System.out.print("Titre du stage: ");
            String titre = scanner.nextLine();
            System.out.print("Durée du stage: ");
            String duree = scanner.nextLine();
            Stage stage = new Stage(titre, duree);
            ajouterstage(stage);
            System.out.println("Stage ajouté.");
        }
    }

    // Implémentation de la méthode supprimer()
    @Override
    public void supprimer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Supprimer un stagiaire");
        System.out.println("2. Supprimer un stage");
        int c2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (c2 == 1) {
            // Supprimer un stagiaire
            System.out.print("Nom du stagiaire à supprimer: ");
            String nom = scanner.nextLine();
            Supprimerparnom(nom);
        } else if (c2 == 2) {
            // Supprimer un stage
            System.out.print("Titre du stage à supprimer: ");
            String titre = scanner.nextLine();
            supprimerStage(titre);
        }
    }

    // Implémentation de la méthode afficher()
    @Override
    public void afficher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Afficher tous les stagiaires");
        System.out.println("2. Afficher tous les stages");
        int c3 = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (c3 == 1) {
            // Afficher tous les stagiaires
            afficherStagaire();
        } else if (c3 == 2) {
            // Afficher tous les stages avec les stagiaires associés
            afficherStagesAvecStagiaires();
        }
    }

    // Autres méthodes (ajouter, supprimer, etc.) restent inchangées
    public void AjouterStagaire(Stagiaire stag1) {
        liststagaire.add(stag1);
    }

    public void Supprimerparnom(String nom) {
        for (int i = 0; i < liststagaire.size(); i++) {
            Stagiaire stag = liststagaire.get(i);
            if (stag.getNom().equalsIgnoreCase(nom)) {
                liststagaire.remove(stag);
                System.out.println("Nom du stagiaire supprimé");
                return;
            }
        }
        System.out.println("Nom non trouvé.");
    }

    public void afficherStagaire() {
        for (Stagiaire stag1 : liststagaire) {
            stag1.afficher();
            System.out.println();
        }
    }

    public void ajouterstage(Stage stage) {
        liststage.add(stage);
    }

    public void supprimerStage(String titre) {
        for (int i = 0; i < liststage.size(); i++) {
            Stage stage = liststage.get(i);
            if (stage.getTitrestage().equalsIgnoreCase(titre)) {
                liststage.remove(stage);
                System.out.println("Stage supprimé");
                return;
            }
        }
        System.out.println("Stage non trouvé.");
    }

    public void afficherStagesAvecStagiaires() {
        System.out.println("Liste des stages avec les stagiaires associés:");
        for (Map.Entry<String, ArrayList<Stagiaire>> entry : associations.entrySet()) {
            String stageTitre = entry.getKey();
            ArrayList<Stagiaire> stagiaires = entry.getValue();

            System.out.println("Stage: " + stageTitre);
            if (stagiaires.isEmpty()) {
                System.out.println("  Aucun stagiaire associé.");
            } else {
                for (Stagiaire stag : stagiaires) {
                    System.out.println("  - " + stag.getNom() + " " + stag.getPrenom());
                }
            }
        }
    }

    // Rechercher un stagiaire par nom et niveau d'étude
    //@Override
    public void RechercherStagaire(String nom, String niveauEtude) {
        for (int i = 0; i < liststagaire.size(); i++) {
            Stagiaire stagair2 = liststagaire.get(i);
            if (stagair2.getNom().equalsIgnoreCase(nom) && stagair2.getNiveauEtude().equalsIgnoreCase(niveauEtude)) {
                stagair2.afficher();
                System.out.println();
            }
        }
    }

    // Associer un stagiaire à un stage
    //@Override
    public void associerStagiaireAStage() {
        // Demander le nom du stagiaire
        System.out.print("Entrez le nom du stagiaire à associer: ");
        Scanner scanner = new Scanner(System.in);
        String stagiaireNom = scanner.nextLine();

        // Rechercher le stagiaire
        Stagiaire stagiaireAssocie = null;
        for (Stagiaire stag : liststagaire) {
            if (stag.getNom().equalsIgnoreCase(stagiaireNom)) {
                stagiaireAssocie = stag;
                break;
            }
        }

        if (stagiaireAssocie == null) {
            System.out.println("Stagiaire non trouvé.");
            return;
        }

        // Afficher les stages disponibles
        System.out.println("Liste des stages disponibles:");
        for (Stage stage : liststage) {
            stage.afficher();
        }

        // Demander le titre du stage à associer
        System.out.print("Entrez le titre du stage à associer au stagiaire: ");
        String stageTitre = scanner.nextLine();

        // Rechercher le stage
        Stage stageAssocie = null;
        for (Stage stage : liststage) {
            if (stage.getTitrestage().equalsIgnoreCase(stageTitre)) {
                stageAssocie = stage;
                break;
            }
        }

        if (stageAssocie == null) {
            System.out.println("Stage non trouvé.");
            return;
        }

        // Ajouter le stagiaire à la liste des stagiaires associés au stage
        associations.putIfAbsent(stageTitre, new ArrayList<>());
        associations.get(stageTitre).add(stagiaireAssocie);

        System.out.println("Stagiaire " + stagiaireNom + " a été associé au stage " + stageTitre);
    }
}
