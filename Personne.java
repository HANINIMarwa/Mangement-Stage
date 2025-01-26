package pk2;
public abstract class Personne
{  // attributs de la classe personne
    private String nom;
    private String prenom;
    private String Age;
    // constructeur
    public Personne(String nom, String prenom, String Age)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.Age = Age;
    }
    public String getNom()
    {
        return nom;
    }
    public String getPrenom()
    {
        return prenom;
    }

    public String getAge()
    {
        return Age;
    }
    // affichage
    public abstract void afficher ();
}

