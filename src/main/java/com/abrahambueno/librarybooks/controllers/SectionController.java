package com.abrahambueno.librarybooks.controllers;

import com.abrahambueno.librarybooks.models.Section;
import com.abrahambueno.librarybooks.repositories.SectionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Library Application", description = "The classic Library Application in CRUD")
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController {
    @Autowired
    private SectionRepository sectionrepos;

    @ApiOperation(value = "list All Sections", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieve list"),
                    @ApiResponse(code = 401, message = "You are not authorized to the view the resource"),
                    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
            })
    @GetMapping("/sections")
    public List<Section> getAllBookDetailInformation() {
        var foundBooks = sectionrepos.findAll();
        if (foundBooks != null) {
            return foundBooks;
        } else {
            return null;
        }
    }
}
