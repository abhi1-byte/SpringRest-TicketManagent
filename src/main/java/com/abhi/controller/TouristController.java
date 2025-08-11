package com.abhi.controller;

import com.abhi.model.Tourist;
import com.abhi.service.ITouristMgmtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourist")
@Tag(name = "TouristController", description = "Tourist management APIs")
public class TouristController {

    @Autowired
    private ITouristMgmtService service;

    @PostMapping("/regTourist")
    @Operation(summary = "Creates a new Tourist")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
            String msg = service.registerTourist(tourist);
            return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get All Tourists")
    public ResponseEntity<?> allTourists() {
            List<Tourist> tourists = service.fetchAllTourists();
            return new ResponseEntity<>(tourists, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "Get Tourist by Id")
    public ResponseEntity<?> getTouristById(@PathVariable Integer id) {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
    }

    @PutMapping("/modify")
    @Operation(summary = "Update entire Tourist")
    public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
            String updateMsg = service.updateTouristByDetails(tourist);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
    }

    @PatchMapping("/modifyBudget/{id}/{amt}")
    @Operation(summary = "Partial update for Tourist")
    public ResponseEntity<String> modifyTouristBudgetById(@PathVariable Integer id, @PathVariable("amt") Float hikeAmount) {
            String updateMsg = service.updateTouristBudgetById(id, hikeAmount);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a Tourist")
    public ResponseEntity<String> removeTouristById(@PathVariable Integer id) {
            String updateMsg = service.deleteTouristById(id);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
    }
}
