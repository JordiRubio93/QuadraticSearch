public class Search {

    public static int SIZE = 10000000;
    public static int KEY = 1;
    public Search() {

        //creem un array ordenat
        Integer A[] = new Integer[SIZE];
        for (int i = 0; i<SIZE; i++){
            A[i]=i*2;
        }
        System.out.println("\n\n QUADRATIC SEARCH \n\n");

        int resultat = quadraticSearch(A,KEY);
        if (resultat==-1) System.out.println("Resultat NO Trobat");
        else System.out.println("Resultat "+ resultat);

        System.out.println("\n\n BINARY SEARCH \n\n");

        resultat = binarySearch(A,KEY);
        if (resultat==-1) System.out.println("Resultat NO Trobat");
        else System.out.println("Resultat "+ resultat);



    }

    private  int quadraticSearch( Integer A[],int KEY) {
        int P1,P2,MID;
        int FIRST = 1;
        int LAST = A.length;
        int i = 0;
        while( FIRST<=LAST ) {
            MID = (FIRST+LAST)/2;
            P1 = FIRST+(LAST-FIRST)/4;
            P2 = FIRST+(LAST-FIRST)*3/4;
            System.out.println("Iteration: " + ++i + " ["+FIRST+","+P1+","+MID+","+P2+","+LAST+"]");
            if(KEY==A[MID] || KEY==A[P1] || KEY==A[P2]) {
                return KEY; //TROBAT
            }
            else if(KEY<A[MID] && KEY<A[P1]){
                LAST=P1-1;
            }
            else if(KEY<A[MID] && KEY>A[P1]){
                FIRST=P1+1;
                LAST=MID-1;
            }
            else if(KEY>A[MID] && KEY>A[P2]){
                FIRST=P2+1;
            }
            else if(KEY>A[MID] && KEY<A[P2]){
                FIRST=MID+1;
                LAST=P2-1;
            }
        } return -1;
    }


    private  int binarySearch( Integer A[],int KEY) {
        int MID;
        int FIRST = 1;
        int LAST = A.length;
        int i = 0;
        while( FIRST<=LAST ) {
            MID = (FIRST+LAST)/2;
            System.out.println("Iteration: " + ++i + " ["+FIRST+","+MID+","+LAST+"]");
            if(KEY==A[MID] ) {
                return KEY; //TROBAT
            }
            else if(KEY<A[MID]){
                LAST=MID-1;
            }
            else if(KEY>A[MID]){
                FIRST=MID+1;
            }
        } return -1;
    }
}
