//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public static int Min(int a, int b){
    if (a < b){
        return a;
    }return b;

}

public static int Abs(int nbr){
    return Math.abs(nbr);
}
public static int Sum(int nbrMax){
    int somme = 0;
    for (int i=0; i<=nbrMax; i++ ){
        somme += i;
    }return somme;
}

public static int Power(int nbr1, int nbr2){
    return (int) Math.pow(nbr1,nbr2);
}

public static String Miroir(String mot){
    String nv_mot = "";
    for (int i= mot.length()-1; i >= 0; i--){
        nv_mot += mot.charAt(i);
        // System.out.println(i);
    }return nv_mot;
}

public static int Multi(int nbr){
    for (int i=0; i<=10; i++){
        System.out.println(nbr + " multiplié par " +i +" vaut : " + nbr*i);
    }
    return nbr;
}

public static boolean Annee(int annee){
    if (annee % 4 == 0){
        return true;
    }else{
        return false;
    }
}

public static boolean Calendar(int annee, int mois, int jour){
    if (annee>2024){
        return false;
    }
    if ((mois == 1 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) && jour == 31){
        return false;
    }
    if (mois == 2 && jour >= 29){
        return false;
    }
    return true;
}



public static void main(String[] args) {
    // page 50
    System.out.println(Min(2,9));
    System.out.println(Abs(-4));
    System.out.println(Sum(4));
    System.out.println(Power(2,4));
    // page 51
    System.out.println(Miroir("Coding"));
    System.out.println(Multi(5));
    System.out.println(Annee(2024));
    System.out.println(Calendar(2025, 1, 1));

}




