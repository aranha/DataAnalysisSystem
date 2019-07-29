package controllers;

import models.Customer;
import models.Salesman;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TypeDataTest {

    @Test
    public void sizeOfListsAndSetsTest() {
        ReadWriteFile.readFile("ç");
        assertEquals(2, TypeData.getInstance().getSalesmanSet().size());
        assertEquals(2, TypeData.getInstance().getCustomersSet().size());
        assertEquals(6, TypeData.getInstance().getItemsSoldList().size());
        assertEquals(2, TypeData.getInstance().getSalesList().size());
    }
}
