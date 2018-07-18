/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.springboot2.AppController;

import com.yritys.springboot2.pojos.Task;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tommi
 */
@Controller
public class AppController {

    private ArrayList<Task> tasks;

    public AppController() {
        this.tasks = new ArrayList<>();
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", this.tasks);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getForm(@RequestParam String task) {
        this.tasks.add(new Task(task));
        return "redirect:/";
    }

    @RequestMapping(value = "/{task}")
    public String details(Model model, @PathVariable String task) {
        for (Task index : this.tasks) {
            if (index.getTask().equals(task)) {
                index.increaseViews();
                model.addAttribute("views", index.getViews());
            }
        }
        model.addAttribute("task", task);
        return "details";
    }

}
