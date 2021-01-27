import java.util.LinkedList;

public class TuermeVonHanoi {

    LinkedList<Integer>[] stangen = new LinkedList[3];
    int platten;

    public TuermeVonHanoi(int anzahlPlatten) {

        platten = anzahlPlatten;

        stangen[0] = new LinkedList<Integer>();
        stangen[1] = new LinkedList<Integer>();
        stangen[2] = new LinkedList<Integer>();

        for(int i = anzahlPlatten; i > 0; i--) {

            stangen[0].add(i);
        }
    }

    public void loese() {

        bewege(0, 2, platten);

        for(int i: stangen[2]) {

            System.out.println(i);
        }
    }

    private void bewege(int indexStart, int indexZiel, int anzahl) {

        if (anzahl == 1) {

            System.out.println("bewege: " + indexStart + " zu " + indexZiel);

            stangen[indexZiel].add(stangen[indexStart].removeLast());
        }
        else {

            int ziel;

            if(indexStart == 0 && indexZiel == 1) ziel = 2;
            else if(indexStart == 0 && indexZiel == 2) ziel = 1;
            else if(indexStart == 1 && indexZiel == 0) ziel = 2;
            else if(indexStart == 1 && indexZiel == 2) ziel = 0;
            else if(indexStart == 2 && indexZiel == 0) ziel = 1;
            else ziel = 0;

            bewege(indexStart, ziel, anzahl - 1);
            bewege(indexStart, indexZiel, 1);
            bewege(ziel, indexZiel, anzahl - 1);
        }
    }

    public static void main(String[] args) {

        TuermeVonHanoi t = new TuermeVonHanoi(10);
        t.loese();
    }
}
