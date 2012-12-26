// this is the only file you're allowed to edit
package dream;

import sleep.Sleeper;

public class Dream {
    public Dream() {
        // TODO Auto-generated constructor stub
    }

    public void dream(Sleeper s) {
        // Spåna en tråd som blockar på "dream"?
        new Thread(new BlockingDream(s)).start();
        synchronized(this) {
        try {
            s.wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }
}

class BlockingDream extends Dream implements Runnable {
    Sleeper s;

    public BlockingDream(Sleeper s) {
        this.s = s;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void dream(Sleeper s) {
        // TODO Auto-generated method stub
        // super.dream(s);
        synchronized (this) {
        try {
            s.notifyAll();
            s.wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }

    @Override
    public void run() {
        // TODO Auto -generated method stub
        s.enter(this);
    }
}