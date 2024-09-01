package com.example.Placement;
import com.example.Placement.Placement;
import com.example.Placement.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/placements")
public class PlacementController {
	 @Autowired
	    private PlacementService placementService;

	    @GetMapping
	    public List<Placement> getAllPlacements() {
	        return placementService.getAllPlacements();
	    }

	    @GetMapping("/{id}")
	    public Placement getPlacementById(@PathVariable Long id) {
	        return placementService.getPlacementById(id);
	    }

	    @PostMapping
	    public Placement createPlacement(@RequestBody Placement placement) {
	        return placementService.savePlacement(placement);
	    }

	    @PutMapping("/{id}")
	    public Placement updatePlacement(@PathVariable Long id, @RequestBody Placement placement) {
	        Placement existingPlacement = placementService.getPlacementById(id);
	        if (existingPlacement != null) {
	            existingPlacement.setCompanyName(placement.getCompanyName());
	            existingPlacement.setJobTitle(placement.getJobTitle());
	            existingPlacement.setPlacementDate(placement.getPlacementDate());
	            existingPlacement.setStudentId(placement.getStudentId());
	            return placementService.savePlacement(existingPlacement);
	        }
	        return null;
	    }

	    @DeleteMapping("/{id}")
	    public void deletePlacement(@PathVariable Long id) {
	        placementService.deletePlacement(id);
	    }
}
