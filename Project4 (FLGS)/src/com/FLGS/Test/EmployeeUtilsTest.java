package com.FLGS.Test;

import com.FLGS.Store.Employees.Announcer;
import com.FLGS.Store.Employees.Baker;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Utils.EmployeeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeUtilsTest {

    @Test
    void spawnAnnouncer() {
        assertEquals(EmployeeUtils.spawnAnnouncer().getClass(), Announcer.class);
    }

    @Test
    void spawnCashier() {
        assertEquals(EmployeeUtils.spawnCashier(EmployeeUtils.spawnAnnouncer()).getClass(), Cashier.class);
    }

    @Test
    void spawnBaker() {
        assertEquals(EmployeeUtils.spawnBaker(EmployeeUtils.spawnAnnouncer()).getClass(), Baker.class);
    }

    @Test
    void spawnDemonstrator() {
        assertEquals(EmployeeUtils.spawnDemonstrator(EmployeeUtils.spawnAnnouncer()).getClass(), Demonstrator.class);
    }
}