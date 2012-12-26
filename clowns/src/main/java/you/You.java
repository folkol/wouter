package you;

import clowns.Clown;
import clowns.Volkswagen;

public class You {
    static Volkswagen wv = new Volkswagen();
    static int dieFuckers = 19;

    public static void main(String args[]) {
        new You().doMagic();
    }

    public void doMagic() {
        wv.add(new Hora());
        wv.done();
    }

    static class Hora extends Clown {
        @Override
        public int hashCode() {
            if(dieFuckers-- > 0) {
                wv.add(new Hora());
            }
            return super.hashCode();
        }
    }
}
