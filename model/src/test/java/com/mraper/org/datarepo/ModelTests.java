package com.mraper.org.datarepo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class ModelTests {

    private DataManagerImpl dataManager;
    private DataManager.DataListener listener;

    @Before
    public void setUp() {
        dataManager = new DataManagerImpl();
        listener = mock(DataManager.DataListener.class);
    }

    @Test
    public void testRestApiProviderInstantiatiedSuccessfully() {
        assertNotNull(dataManager.getRestApiProvider());
    }

    @Test
    public void testDataListenerRegistrationAnUnregistrationSuccessful() {
        assertNull(dataManager.getDataListener());
        dataManager.registerListener(listener);
        assertNotNull(dataManager.getDataListener());
        dataManager.unregisterListener();
        assertNull(dataManager.getDataListener());
    }
}