package com.fireguardian.fireguardian360;

import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MainAppTests {

    @Nested
    class AlertTest {
        @Test
        void testHighRiskOverload() {
            Alert a = new Alert();
            a.setLevel(6);
            assertTrue(a.isHighRisk());
            assertTrue(a.isHighRisk(6));
        }
    }

    @Nested
    class ShelterTest {
        @Test
        void occupancyRate() {
            Shelter s = new Shelter();
            s.setCapacity(100);
            s.setAvailable(80);
            assertEquals(20.0, s.getOccupancyRate(), 0.01);
        }
    }

    @Nested
    class ChecklistItemTest {
        @Test
        void pendingStatus() {
            ChecklistItem c = new ChecklistItem();
            c.setStatus('P');
            assertTrue(c.isPending());
        }
    }

}