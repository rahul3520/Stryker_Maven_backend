package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.entity.dao.OtherTicketsEntity;
import com.Stryker_Backend.Maven.repository.OtherTicketsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OtherTicketsRepositoryTests {

    @Mock
    private OtherTicketsRepository otherTicketsRepository;

//    @InjectMocks
//    private OtherTicketsRepositoryImpl otherTicketsRepositoryImpl;

    @Test
    void testFindAllOtherTickets() {
        // Mocking the repository
        String ticketNumber = "T123";
        List<OtherTicketsEntity> expectedOtherTickets = Arrays.asList(
                new OtherTicketsEntity(1, "Ticket 1"),
                new OtherTicketsEntity(2, "Ticket 2")
        );
        when(otherTicketsRepository.FindAllOtherTickets(ticketNumber)).thenReturn(expectedOtherTickets);

        // Calling the repository method
        List<OtherTicketsEntity> actualOtherTickets = otherTicketsRepository.FindAllOtherTickets(ticketNumber);

        // Verifying the result
        assertEquals(expectedOtherTickets, actualOtherTickets);
        verify(otherTicketsRepository, times(1)).FindAllOtherTickets(ticketNumber);
    }
}
