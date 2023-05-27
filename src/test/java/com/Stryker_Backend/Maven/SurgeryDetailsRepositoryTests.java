package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.entity.dao.SurgeryDetailsEntity;
import com.Stryker_Backend.Maven.repository.SurgeryDetailsRepository;
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
class SurgeryDetailsRepositoryTests {

    @Mock
    private SurgeryDetailsRepository surgeryDetailsRepository;

//    @InjectMocks
//    private SurgeryDetailsRepositoryImpl surgeryDetailsRepositoryImpl;

    @Test
    void testFindbyTicketId() {
        // Mocking the repository
        String ticketId = "123";
        List<SurgeryDetailsEntity> expectedSurgeryDetails = Arrays.asList(
                new SurgeryDetailsEntity(1, "Surgery 1"),
                new SurgeryDetailsEntity(2, "Surgery 2")
        );
        when(surgeryDetailsRepository.FindbyTicketId(ticketId)).thenReturn(expectedSurgeryDetails);

        // Calling the repository method
        List<SurgeryDetailsEntity> actualSurgeryDetails = surgeryDetailsRepository.FindbyTicketId(ticketId);

        // Verifying the result
        assertEquals(expectedSurgeryDetails, actualSurgeryDetails);
        verify(surgeryDetailsRepository, times(1)).FindbyTicketId(ticketId);
    }
}
