package com.mvc.validator;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for handling customer form requests.
 *
 * <p>
 * Features:
 * - Displays customer form
 * - Performs input validation using Jakarta Validation
 * - Handles form submission and error flow
 * - Trims incoming string inputs to avoid whitespace issues
 * </p>
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    /**
     * Initializes data binder to trim all incoming String values.
     * Converts empty strings to null to support validation annotations like @NotNull.
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    /**
     * Displays the customer form.
     */
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    /**
     * Processes the submitted customer form.
     *
     * @param customer       the form-backed customer object
     * @param bindingResult  holds validation errors
     * @param model          Spring UI model
     * @return view name based on validation result
     */
    @PostMapping("/process")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult,
            Model model) {

        // Debug logging (replace with logger in production)
        System.out.println("Customer received: " + customer);
        System.out.println("Validation result: " + bindingResult);

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        model.addAttribute("customer", customer);
        return "customer-confirmation";
    }
}
