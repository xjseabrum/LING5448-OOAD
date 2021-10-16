package com.FLGS.Test;

import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Store.StoreVisitors.CookieMonster;
import com.FLGS.Store.StoreVisitors.Customer;
import com.FLGS.Utils.EmployeeUtils;
import com.FLGS.Utils.StoreUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreUtilsTest {

    @Test
    void spawnCustomers() {
        List result=StoreUtils.spawnCustomers();
        if(result!=null && result.size()>0){
            assertEquals(result.get(0).getClass(),Customer.class);
        }
    }

    @Test
    void spawnCookieMonster() {
        Object result=StoreUtils.spawnCookieMonster();
        if(result!=null){
            assertEquals(result.getClass(), CookieMonster.class);
        }
    }
}