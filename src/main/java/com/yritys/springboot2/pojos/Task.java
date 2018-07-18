/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.springboot2.pojos;

/**
 *
 * @author tommib
 */
public class Task {

    private String task;
    private int views;

    public Task(String task) {
        this.task = task;
        this.views = 0;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void increaseViews() {
        this.views++;
    }

    public int getViews() {
        return this.views;
    }
}
