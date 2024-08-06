package application.validators;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.application.dto.IncidentDTO;
import com.incidentresponse.application.utils.IncidentValidator;
import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
        IncidentDTO incident = this.generateIncidentDTO(false, false, false, false);
        assertTrue(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingTitle() {
        IncidentDTO incident = this.generateIncidentDTO(true, false, false, false);
        assertFalse(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingDescription() {
        IncidentDTO incident = this.generateIncidentDTO(false, true, false, false);
        assertFalse(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingPriority() {
        IncidentDTO incident = this.generateIncidentDTO(true, false, true, false);
        assertFalse(this.incidentValidator.isValid(incident));
    }

    @Test
    public void testIncidentValidatorMissingStatus() {
        IncidentDTO incident = this.generateIncidentDTO(true, false, false, true);
        assertFalse(this.incidentValidator.isValid(incident));
    }

    /**
     * Create an incident  with missing parameters
     *
     * @param missingTitle       the title is missing
     * @param missingDescription the description is missing
     * @param missingPriority    the prioririty is missing
     * @param missingStatus      the status is missing
     * @return an incident
     */
    private IncidentDTO generateIncidentDTO(boolean missingTitle, boolean missingDescription, boolean missingPriority, boolean missingStatus) {
        IncidentDTO incident = new IncidentDTO();
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
