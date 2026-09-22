package barbershop_vk.controller;

import barbershop_vk.entity.Scheduling;
import barbershop_vk.repository.SchedulingRepository;
import barbershop_vk.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import barbershop_vk.dto.QueuePositionRequest;
import org.springframework.security.access.prepost.PreAuthorize;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/scheduling")
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @GetMapping
    @PreAuthorize("hasRole('BARBEIRO')")
    public List<Scheduling> findAll() {
        return schedulingService.findAll();
    }

    @PostMapping
    public Scheduling createScheduling(@RequestBody Scheduling scheduling) {
        scheduling=schedulingService.insert(scheduling);
        return scheduling;
    }
    @DeleteMapping
    public void deleteScheduling(@RequestBody Long id) {
        schedulingService.delete(id);
    }
    @GetMapping("/queue")
    @PreAuthorize("hasRole('BARBEIRO')")
    public List<Scheduling> findQueue(
            @RequestParam Long barberId,
            @RequestParam LocalDate date
    ) {
        return schedulingService.findQueue(barberId, date);
    }
    @PutMapping("/{id}/queue-position")
    @PreAuthorize("hasRole('BARBEIRO')")
    public Scheduling updateQueuePosition(
            @PathVariable Long id,
            @RequestBody QueuePositionRequest request
    ) {
        return schedulingService.updateQueuePosition(id, request);
    }
    @PutMapping("/{id}/start")
    @PreAuthorize("hasRole('BARBEIRO')")
    public Scheduling startScheduling(@PathVariable Long id) {
        return schedulingService.startScheduling(id);
    }
    @PutMapping("/{id}/finish")
    @PreAuthorize("hasRole('BARBEIRO')")
    public Scheduling finishScheduling(@PathVariable Long id) {
        return schedulingService.finishScheduling(id);
    }


}
