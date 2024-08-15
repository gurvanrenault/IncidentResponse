package com.incidentresponse.application.controller;

import com.incidentresponse.application.dto.CommentDTO;
import com.incidentresponse.application.mapper.CommentDTOMapper;
import com.incidentresponse.application.mapper.IncidentDTOMapper;
import com.incidentresponse.application.utils.CommentValidator;
import com.incidentresponse.application.utils.Validator;
import com.incidentresponse.domain.interfaces.ICommentService;
import com.incidentresponse.domain.interfaces.IIncidentService;
import com.incidentresponse.domain.model.Comment;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.enums.ErrorsEnum;
import com.incidentresponse.errors.IncidentResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final ICommentService commentService;
    private final IIncidentService incidentService;
    private final CommentDTOMapper commentDTOMapper;
    private final IncidentDTOMapper incidentDTOMapper;

    public CommentController(ICommentService commentaryService, IIncidentService incidentService,
                             CommentDTOMapper commentaryDTOMapper, IncidentDTOMapper incidentDTOMapper) {
        this.commentService = commentaryService;
        this.commentDTOMapper = commentaryDTOMapper;
        this.incidentService = incidentService;
        this.incidentDTOMapper = incidentDTOMapper;
    }

    @PostMapping(path = "incidents/{id}/comments")
    public ResponseEntity<?> addIncident(@PathVariable("id") Long id, @RequestBody CommentDTO commentDTO) {
        Validator<CommentDTO> validator = new CommentValidator();
        Incident incident = this.incidentService.getIncident(id);
        commentDTO.setIncident(this.incidentDTOMapper.domainToApplication(incident));
        if (incident != null && validator.isValid(commentDTO)) {

            Comment commentCreated = this.commentService.addComment(this.commentDTOMapper.applicationToDomain(commentDTO));
            return ResponseEntity.ok(this.commentDTOMapper.domainToApplication(commentCreated));
        }
        if (incident == null)
            return new ResponseEntity<>(new IncidentResponseError(ErrorsEnum.ERROR_NOT_FOUND_INCIDENT.getCode(), ErrorsEnum.ERROR_NOT_FOUND_INCIDENT.getMessage()), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new IncidentResponseError(ErrorsEnum.ERROR_INVALID_COMMENT.getCode(), ErrorsEnum.ERROR_INVALID_COMMENT.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "incidents/{id}/comments")
    public ResponseEntity<?> getCommentsByIdIncident(@PathVariable("id") Long id) {
        Incident incident = this.incidentService.getIncident(id);
        if (incident != null) {
            List<Comment> comments = this.commentService.getCommentsByIdIncident(id);
            return ResponseEntity.ok(this.commentDTOMapper.listDomainToApplication(comments));
        } else {
            return new ResponseEntity<>(new IncidentResponseError(ErrorsEnum.ERROR_NOT_FOUND_INCIDENT.getCode(), ErrorsEnum.ERROR_NOT_FOUND_INCIDENT.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
