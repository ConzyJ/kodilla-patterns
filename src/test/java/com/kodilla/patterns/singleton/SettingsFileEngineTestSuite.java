package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsFileEngineTestSuite {

    private static SettingsFileEngine settingsFileEngine;

    @BeforeAll
    public static void openSettingsFile() {
        settingsFileEngine = SettingsFileEngine.INSTANCE;
        settingsFileEngine.open("myapp.settings");
    }

    @AfterAll
    public static void closeSettingsFile() {
        settingsFileEngine.close();
    }

    @Test
    void testGetFileName() {

        String fileName = settingsFileEngine.getFileName();


        assertEquals("myapp.settings", fileName);
    }

    @Test
    void testLoadSettings() {
        assertTrue(settingsFileEngine.loadSettings());
    }

    @Test
    void testSaveSettings() {
        assertTrue(settingsFileEngine.saveSettings());
    }
}
