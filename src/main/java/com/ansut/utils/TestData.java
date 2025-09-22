package com.ansut.utils;

import java.util.Random;

/**
 * Classe utilitaire pour gérer les données de test
 */
public class TestData {
    
    private static final Random random = new Random();
    
    /**
     * Génère un libellé unique pour les tests
     */
    public static String generateUniqueLibelle(String prefix) {
        return prefix + "_" + System.currentTimeMillis() + "_" + random.nextInt(1000);
    }
    
    /**
     * Génère un code unique pour les tests
     */
    public static String generateUniqueCode(String prefix) {
        return prefix + random.nextInt(999);
    }
    
    /**
     * Données de test pour les raisons de cloture
     */
    public static class ClotureData {
        public static final String DEFAULT_LIBELLE = "Test Automatique";
        public static final String DEFAULT_CODE = "TST";
        public static final String MODIFIED_LIBELLE = "Test Modifié";
        public static final String MODIFIED_CODE = "MOD";
        public static final String SEARCH_TERM = "Test";
    }
    
    /**
     * Données de test pour les utilisateurs
     */
    public static class UserData {
        public static final String DEFAULT_NAME = "Utilisateur Test";
        public static final String DEFAULT_LOGIN = "test.user";
        public static final String DEFAULT_EMAIL = "test@example.com";
    }
    
    /**
     * Données de test pour les sections
     */
    public static class SectionData {
        public static final String DEFAULT_NAME = "Section Test";
        public static final String DEFAULT_CODE = "SEC";
    }
}
