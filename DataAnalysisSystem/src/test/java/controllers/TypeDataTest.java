package controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeDataTest {

    @Test
    public void sizeOfListsAndSetsTest() {
        assertEquals(2, TypeData.getInstance().getSalesmanSet().size());
        assertEquals(2, TypeData.getInstance().getCustomersSet().size());
        assertEquals(6, TypeData.getInstance().getItemsSoldList().size());
        assertEquals(2, TypeData.getInstance().getSalesList().size());
    }
}
