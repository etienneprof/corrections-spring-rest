package bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("etudiant")
public class Etudiant extends Personne {

}
