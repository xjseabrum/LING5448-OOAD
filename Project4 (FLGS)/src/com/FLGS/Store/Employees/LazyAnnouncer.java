// Here is the Lazy implementation of the Announcer Singleton
// In the code, after talking to Bruce, we only call the
// Eager version of the Announcer via a variable that can be
// set under Store.java

package com.FLGS.Store.Employees;

public class LazyAnnouncer extends Announcer{
    private static LazyAnnouncer unique;

    private LazyAnnouncer(String announcerName) {
        super(announcerName);
    }

    public static synchronized LazyAnnouncer getInstance(){
        if (unique == null){
            unique = new LazyAnnouncer("Guy");
        }
        return unique;
    }
}
