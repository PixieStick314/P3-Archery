package P3.Archery.controller;

import P3.Archery.entity.Locker;
import P3.Archery.repository.LockerRepository;
import P3.Archery.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/locker")
public class LockerController {

    private final LockerService lockerService;

    public LockerController(LockerService lockerService) {
        this.lockerService = lockerService;
    }

    @PostMapping("/create")
    public Locker createLocker(@RequestBody Locker locker) {
        return lockerService.createLocker(locker);
    }

    @GetMapping("/")
    public String test() {
        return "hello world!";
    }


}
