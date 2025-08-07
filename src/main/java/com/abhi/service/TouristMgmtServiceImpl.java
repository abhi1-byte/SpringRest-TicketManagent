package com.abhi.service;

import com.abhi.dao.ITouristRepo;
import com.abhi.exception.TouristNotFoundException;
import com.abhi.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {

    @Autowired
    private ITouristRepo repo;

    @Override
    public String registerTourist(Tourist tourist) {
        Integer ticketId = repo.save(tourist).getTicketId();
        return "Tourist is registered having the ticket id :: " + ticketId;
    }

    @Override
    public List<Tourist> fetchAllTourists() {
        List<Tourist> list = repo.findAll();
        //Sorting the elements in descending order on a basis of ticketId
        list.sort((t1, t2) -> (t2.getTicketId().compareTo(t1.getTicketId())));
        return list;
    }

    @Override
    public Tourist fetchTouristById(Integer id) {
        /*Optional<Tourist> tourist = repo.findById(id);
        Tourist t = null;
        if(tourist.isPresent()) {
            t = tourist.get();
        }else{
            throw new TouristNotFoundException("Tourist not found for the given id ::"+id);
        }*/
        return repo.findById(id).orElseThrow(() -> new TouristNotFoundException("Tourist not found for the given id ::" + id));
    }

    @Override
    public String updateTouristByDetails(Tourist tourist) {
        Integer ticketId = tourist.getTicketId();
        Optional<Tourist> optional = repo.findById(ticketId);
        if (optional.isPresent()) {
            repo.save(tourist);
            return "Tourist with the id : " + ticketId + " got updated successfully";
        } else {
            throw new TouristNotFoundException("Tourist not found to update for the given id ::" + ticketId);
        }
    }

    @Override
    public String updateTouristBudgetById(Integer id, Float hikePercent) {
        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()) {
            Tourist tourist = optional.get();
            tourist.setBudget(tourist.getBudget() + (tourist.getBudget() * (hikePercent / 100)));
            repo.save(tourist);
            return "Tourist with the id : " + id + " got updated for budget successfully";
        } else {
            throw new TouristNotFoundException("Tourist not found to update the budget for the given id ::" + id);
        }
    }

    @Override
    public String deleteTouristById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()) {
            /* This will again run the select query to check if the record available for the given Id,
            if found then run delete query
            repo.deleteById(id);*/
            repo.delete(optional.get());
            return "Tourist with the id : " + id + " got deleted successfully";
        } else {
            throw new TouristNotFoundException("Tourist not found to delete for the given id ::" + id);
        }
    }
}
