package app.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Formation {
    private String codeFormation;
    private String diplome;
    private Byte n0Annee;
    private String nomFormation;
    private String doubleDiplome;
    private Timestamp debutAccreditation;
    private Timestamp finAccreditation;

    @Id
    @Column(name = "CODE_FORMATION")
    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    @Basic
    @Column(name = "DIPLOME")
    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    @Basic
    @Column(name = "N0_ANNEE")
    public Byte getN0Annee() {
        return n0Annee;
    }

    public void setN0Annee(Byte n0Annee) {
        this.n0Annee = n0Annee;
    }

    @Basic
    @Column(name = "NOM_FORMATION")
    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    @Basic
    @Column(name = "DOUBLE_DIPLOME")
    public String getDoubleDiplome() {
        return doubleDiplome;
    }

    public void setDoubleDiplome(String doubleDiplome) {
        this.doubleDiplome = doubleDiplome;
    }

    @Basic
    @Column(name = "DEBUT_ACCREDITATION")
    public Timestamp getDebutAccreditation() {
        return debutAccreditation;
    }

    public void setDebutAccreditation(Timestamp debutAccreditation) {
        this.debutAccreditation = debutAccreditation;
    }

    @Basic
    @Column(name = "FIN_ACCREDITATION")
    public Timestamp getFinAccreditation() {
        return finAccreditation;
    }

    public void setFinAccreditation(Timestamp finAccreditation) {
        this.finAccreditation = finAccreditation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formation formation = (Formation) o;
        return Objects.equals(codeFormation, formation.codeFormation) &&
                Objects.equals(diplome, formation.diplome) &&
                Objects.equals(n0Annee, formation.n0Annee) &&
                Objects.equals(nomFormation, formation.nomFormation) &&
                Objects.equals(doubleDiplome, formation.doubleDiplome) &&
                Objects.equals(debutAccreditation, formation.debutAccreditation) &&
                Objects.equals(finAccreditation, formation.finAccreditation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeFormation, diplome, n0Annee, nomFormation, doubleDiplome, debutAccreditation, finAccreditation);
    }
}
