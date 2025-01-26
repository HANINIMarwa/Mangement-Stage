package pk2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GestionImpl gestion = new GestionImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu : ");
            System.out.println("1. Ajouter un stagiaire ou un stage");
            System.out.println("2. Supprimer un stagiaire ou un stage");
            System.out.println("3. Afficher les stagiaires ou les stages");
            System.out.println("4. Associer un stagiaire à un stage");
            System.out.println("5. Afficher les stages avec stagiaires associés");
            System.out.println("6. Rechercher un stagiaire");
            System.out.println("7. Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (choix == 1) {
                gestion.ajouter();
            } else if (choix == 2) {
                gestion.supprimer();
            } else if (choix == 3) {
                gestion.afficher();
           // }else if (choix == 4) {
             //                  gestion.RechercherStagaire();
            } else if (choix==4) {
                gestion.associerStagiaireAStage();
            } else if (choix==5) {
                gestion.afficherStagesAvecStagiaires();
            } else if (choix == 6) {
              // gestion.RechercherStagaire();
             } else if (choix == 7) {
               break;
            } else {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}
//package pk2;


//public class Main {
//    public static void main(String[] args) {
//        Gestion gestion = new GestionImpl(); // Instanciation de l'implémentation de l'interface
//        Scanner scanner = new Scanner(System.in);
//        int choix;
//
//        do {
//            System.out.println("\n================ MENU =================");
//            System.out.println("1. Ajouter un stagiaire");
//            System.out.println("2. Supprimer un stagiaire");
//            System.out.println("3. Afficher tous les stagiaires");
//            System.out.println("4. Ajouter un stage");
//            System.out.println("5. Associer un stagiaire à un stage");
//            System.out.println("6. Afficher les stages avec stagiaires associés");
//            System.out.println("7. Rechercher un stagiaire");
//            System.out.println("8. Quitter l'application");
//            System.out.print("Entrez votre choix : ");
//            choix = scanner.nextInt();
//            scanner.nextLine(); // Consomme la ligne restante après nextInt()
//
//            switch (choix) {
//                case 1:
//                    System.out.print("Nom du stagiaire : ");
//                    String nom = scanner.nextLine();
//                    System.out.print("Prénom du stagiaire : ");
//                    String prenom = scanner.nextLine();
//                    System.out.print("Âge du stagiaire : ");
//                    String age = scanner.nextLine();
//                    System.out.print("Niveau d'étude : ");
//                    String niveauEtude = scanner.nextLine();
//
//                    Stagiaire stagiaire = new Stagiaire(nom, prenom, age, niveauEtude);
//                    gestion.AjouterStagaire(stagiaire);
//                    break;
//
//                case 2:
//                    System.out.print("Entrez le nom du stagiaire à supprimer : ");
//                    String nomASupprimer = scanner.nextLine();
//                    gestion.Supprimerparnom(nomASupprimer);
//                    break;
//
//                case 3:
//                    gestion.AfficherStagaire();
//                    break;
//
//                case 4:
//                    System.out.print("Titre du stage : ");
//                    String titre = scanner.nextLine();
//                    System.out.print("Durée du stage : ");
//                    String duree = scanner.nextLine();
//
//                    Stage stage = new Stage(titre, duree);
//                    gestion.ajouterstage(stage);
//                    break;
//
//                case 5:
//                    gestion.associerStagiaireAStage();
//                    break;
//
//                case 6:
//                    gestion.afficherStagesAvecStagiaires();
//                    break;
//
//                case 7:
//                    System.out.print("Entrez le nom du stagiaire à rechercher : ");
//                    String nomRecherche = scanner.nextLine();
//                    System.out.print("Entrez le niveau d'étude : ");
//                    String niveauRecherche = scanner.nextLine();
//
//                    gestion.RechercherStagaire(nomRecherche, niveauRecherche);
//                    break;
//
//                case 8:
//                    System.out.println("Merci d'avoir utilisé l'application. Au revoir !");
//                    break;
//
//                default:
//                    System.out.println("Choix invalide. Veuillez réessayer.");
//            }
//
//        } while (choix != 8);
//
//        scanner.close();
//    }
//}


