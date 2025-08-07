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
        try {
            String msg = service.registerTourist(tourist);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error Happened", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> allTourists() {
        try {
            List<Tourist> tourists = service.fetchAllTourists();
            return new ResponseEntity<>(tourists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error Happened", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getTouristById(@PathVariable Integer id) {
        try {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
        try {
            String updateMsg = service.updateTouristByDetails(tourist);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/modifyBudget/{id}/{amt}")
    public ResponseEntity<String> modifyTouristBudgetById(@PathVariable Integer id, @PathVariable("amt") Float hikeAmount) {
        try {
            String updateMsg = service.updateTouristBudgetById(id, hikeAmount);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeTouristById(@PathVariable Integer id) {
        try {
            String updateMsg = service.deleteTouristById(id);
            return new ResponseEntity<>(updateMsg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
