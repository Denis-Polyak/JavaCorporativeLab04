package org.example.lab04_javaco.controller;

import org.example.lab04_javaco.entity.Driver;
import org.example.lab04_javaco.repository.DriverRepository;
import org.example.lab04_javaco.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
@RequestMapping("/drivers")
public class DriverPageController {

    private final DriverService driverService;

    @Autowired
    public DriverPageController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/add")
    public String showAddDriverForm(Model model) {
        model.addAttribute("driver", new Driver());
        return "addDriver";  // Повертаємо шаблон для додавання водія
    }

    @PostMapping("/save")
    public String saveDriver(@ModelAttribute Driver driver, Model model) {
        if (driver.getIssuedDate() != null) {
            try {
                driver.setIssuedDate(LocalDate.parse(driver.getIssuedDate().toString()));
            } catch (DateTimeParseException e) {
                model.addAttribute("errorMessage", "Invalid date format.");
                return "addDriver";  // Return to the form with an error message
            }
        }
        driverService.saveDriver(driver);  // Використовуємо сервіс
        model.addAttribute("successMessage", "Driver saved successfully!");
        return "addDriver";
    }

    @GetMapping("/list")
    public String getDriversList(Model model) {
        List<Driver> drivers = driverService.getAllDrivers();  // Використовуємо сервіс
        model.addAttribute("drivers", drivers);
        return "driversList";
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        if (driverService.getDriverById(id).isPresent()) {
            driverService.deleteDriver(id);  // Використовуємо сервіс
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Driver driver = driverService.getDriverById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid driver Id:" + id));
        model.addAttribute("driver", driver);
        return "editDriver";
    }

    @PostMapping("/edit/{id}")
    public String updateDriver(@PathVariable Long id, @ModelAttribute Driver driver) {
        driver.setId(id);
        driverService.saveDriver(driver);  // Використовуємо сервіс
        return "redirect:/drivers/list";
    }
}


