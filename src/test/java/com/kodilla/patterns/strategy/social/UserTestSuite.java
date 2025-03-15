package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        // Given
        User john = new Millennials("John");
        User emily = new YGeneration("Emily");
        User mike = new ZGeneration("Mike");

        // When
        String johnShares = john.sharePost();
        String emilyShares = emily.sharePost();
        String mikeShares = mike.sharePost();

        // Then
        assertEquals("Sharing post on Facebook", johnShares);
        assertEquals("Sharing post on Twitter", emilyShares);
        assertEquals("Sharing post on Snapchat", mikeShares);
    }

    @Test
    void testIndividualSharingStrategy() {
        // Given
        User john = new Millennials("John");

        // When
        String johnShares = john.sharePost();
        System.out.println("John's default: " + johnShares);

        john.setSocialPublisher(new TwitterPublisher());
        johnShares = john.sharePost();
        System.out.println("John after change: " + johnShares);

        // Then
        assertEquals("Sharing post on Twitter", johnShares);
    }
}
