package com.example.esercizioSwagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Practice", description = "A practice controller to write with Swagger following OpenAPI standards")
@RestController
@RequestMapping("v1/")
public class nameController {
    @Operation(
            summary = "Retrieve the name by Request paramter",
            description = "Get a name object by specifying its parameter. The response is a String with the name itself.",
            tags = { "nameController", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the name in the parameter",content = { @Content(schema = @Schema(implementation = nameController.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Malformed name parameter", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Name not found or wrong mapping", content = { @Content(schema = @Schema()) }) })
    @GetMapping(path = "getname")
    public String getName(@RequestParam String name) {
        return name;
    }
    @Operation(
            summary = "Retrieve the name by Request paramter",
            description = "Get a name object and reverse it by specifying its parameter. The response is a StringBuilder with the name itself reversed.",
            tags = { "nameController", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the name in the parameter reversed ",content = { @Content(schema = @Schema(implementation = nameController.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400" , description = "Malformed name parameter", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Name not found or wrong mapping", content = { @Content(schema = @Schema()) }) })
    @PostMapping(path = "createreversedname")
    public StringBuilder postName(@RequestParam String name) {
        StringBuilder invertedName = new StringBuilder(name);
        return  invertedName.reverse();
    }
}