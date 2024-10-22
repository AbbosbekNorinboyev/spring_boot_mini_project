package uz.pdp.employee_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.pdp.employee_system.entity.Employee;
import uz.pdp.employee_system.service.EmployeeService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EMPController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "home";
    }

    @GetMapping("/addEmp")
    public String addEmp() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        System.out.println(employee);
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("successMessage", "Employee added successfully");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/update")
    public String editPage(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("successMessage", "Employee successfully updated");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deletePage(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
