// Here is the Eager implementation of the Announcer Singleton
// In the code, after talking to Bruce, we only call the
// Eager version of the Announcer via a variable that can be
// set under Store.java

package com.FLGS.Store.Employees;

public class EagerAnnouncer extends Announcer{
    private static EagerAnnouncer unique =
            new EagerAnnouncer("Guy");

    private EagerAnnouncer(String announcerName) {
        super(announcerName);
    }

    public static EagerAnnouncer getInstance(){
        return unique;
    }
}
