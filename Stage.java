package pk2;

public class Stage
{
    // attributs de stage
    private String titrestage;
    private String Duree ;
    //constructeur
    Stage(String titrestage, String Duree)
    {
        this.titrestage = titrestage;
        this.Duree = Duree;
    }
    // afficher
    public void afficher ()
    {
        System.out.println("Titre de stage est : "+titrestage+"Sa durée est :"+Duree);
    }

    public String getTitrestage() {
        return titrestage;
    }

    public void setTitrestage(String titrestage) {
        this.titrestage = titrestage;
    }

    public String getDuree() {
        return Duree;
    }

    public void setDuree(String duree) {
        Duree = duree;
    }
}