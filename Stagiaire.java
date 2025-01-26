package pk2;
public class Stagiaire extends Personne
{
      // ajouter l'attribut de la classe stagiaire
    private String niveauEtude;
    // constructor
    Stagiaire(String nom, String prenom, String Age, String niveauEtude)
    {
        super(nom, prenom, Age);
        this.niveauEtude = niveauEtude;
    }
    public String getNiveauEtude() {
        return niveauEtude;
    }
    @Override
    public void afficher()
    {
        System.out.println(" le nom est : " + getNom()+"Son prénom est : "+getPrenom()+"Son Age est "+getAge()+"Son Niveau d'étude est : "+niveauEtude);
    }
}