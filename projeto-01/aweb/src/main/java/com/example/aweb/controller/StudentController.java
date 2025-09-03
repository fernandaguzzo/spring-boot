package com.example.aweb.controller;

import com.example.aweb.model.Student;
import com.example.aweb.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.listAll()); 
        return "list";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("student", new Student()); 
        return "form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, RedirectAttributes attributes) {
        try {
            model.addAttribute("student", studentService.findStudent(id));
            return "form";
        } catch (RuntimeException e) {
            attributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/students";
        }
    }

    @PostMapping
    public String save(@Valid Student student, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "form";
        }

        studentService.createStudent(student);
        attributes.addFlashAttribute("message", "Cadastro do estudante foi salvo!");
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            studentService.deleteStudent(id);
            attributes.addFlashAttribute("message", "Cadastro excluído com sucesso");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/students";
    }
}
