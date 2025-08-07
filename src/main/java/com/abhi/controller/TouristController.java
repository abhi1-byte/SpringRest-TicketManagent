package com.abhi.controller;

import com.abhi.model.Tourist;
import com.abhi.service.ITouristMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

    @Autowired
    private ITouristMgmtService service;

    @PostMapping("/regTourist")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
            String msg = service.registerTourist(tourist);
            return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> allTourists() {
            List<Tourist> tourists = service.fetchAllTourists();
            return new ResponseEntity<>(tourists, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getTouristById(@PathVariable Integer id) {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
            String updateMsg = service.updateTouristByDetails(tourist);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
    }

    @PatchMapping("/modifyBudget/{id}/{amt}")
    public ResponseEntity<String> modifyTouristBudgetById(@PathVariable Integer id, @PathVariable("amt") Float hikeAmount) {
            String updateMsg = service.updateTouristBudgetById(id, hikeAmount);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeTouristById(@PathVariable Integer id) {
            String updateMsg = service.deleteTouristById(id);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
    }
}
