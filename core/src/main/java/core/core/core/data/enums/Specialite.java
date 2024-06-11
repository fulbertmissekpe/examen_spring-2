package core.core.core.data.enums;

public enum Specialite {
    Dentaire,Generaliste,Cardioloque,Pediatrie,Ophta;

    public static Specialite  toEnum(int valOrdinal) {
        for (Specialite enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }

    //Méthode pour convertir un string en une enumération de type EtatCours
    public static Specialite convertStringToEtatCours(String etat) {
        return Specialite .valueOf(etat);
    }

}
