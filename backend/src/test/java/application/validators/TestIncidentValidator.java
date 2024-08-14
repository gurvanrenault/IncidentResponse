package application.validators;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.application.dto.IncidentDTO;
import com.incidentresponse.application.dto.UserDTO;
import com.incidentresponse.application.utils.IncidentValidator;
import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = IncidentApplication.class)
public class TestIncidentValidator {


    private IncidentValidator incidentValidator;

    @BeforeEach
    public void beforeEach() {
        this.incidentValidator = new IncidentValidator();
    }

    @Test
    public void testIncidentValidatorOK() {
        IncidentDTO incident = this.generateIncidentDTO(false, false, false, false, false, false, false);
        assertTrue(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingTitle() {
        IncidentDTO incident = this.generateIncidentDTO(false, false, false, true, false, false, false);
        Assertions.assertFalse(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingDescription() {
        IncidentDTO incident = this.generateIncidentDTO(false, false, false, false, true, false, false);
        Assertions.assertFalse(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingPriority() {
        IncidentDTO incident = this.generateIncidentDTO(false, false, false, false, false, true, false);
        Assertions.assertFalse(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingStatus() {
        IncidentDTO incident = this.generateIncidentDTO(false, false, false, false, false, false, true);
        Assertions.assertFalse(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingDate() {
        IncidentDTO incident = this.generateIncidentDTO(false, false, true, false, false, false, false);
        assertTrue(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingUser() {
        IncidentDTO incident = this.generateIncidentDTO(false, true, false, false, false, false, false);
        Assertions.assertTrue(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingId() {
        IncidentDTO incident = this.generateIncidentDTO(true, false, false, false, false, false, false);
        Assertions.assertTrue(this.incidentValidator.isValid(incident));
    }


    /**
     * Create an incident  with missing parameters
     * @param missingId          the id is missing
     * @param missingUser        the user is missing
     * @param missingDate        the date is missing
     * @param missingTitle       the title is missing
     * @param missingDescription the description is missing
     * @param missingPriority    the prioririty is missing
     * @param missingStatus      the status is missing
     * @return an incident
     */
    private IncidentDTO generateIncidentDTO(boolean missingId, boolean missingUser, boolean missingDate, boolean missingTitle, boolean missingDescription, boolean missingPriority, boolean missingStatus) {
        IncidentDTO incident = new IncidentDTO();
        if (!missingId) {
            incident.setId(42L);
        }
        if (!missingUser) {
            incident.setUserAssignated(new UserDTO());
        }
        if (!missingDate) {
            incident.setDate(new Date());
        }
        if (!missingDescription) {
            incident.setDescription(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        }
        if (!missingPriority) {
            incident.setPriority(PriorityStatusEnum.P1);
        }
        if (!missingStatus) {
            incident.setStatus(StatusIncidentEnum.TO_DO);
        }
        if (!missingTitle) {
            incident.setTitle(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        }
        return incident;

    }


}
