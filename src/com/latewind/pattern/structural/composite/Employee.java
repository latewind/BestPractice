package com.latewind.pattern.structural.composite;

import java.util.List;

public class Employee {
    private String name;
    private Boolean leader;
    private List<Employee> subEmployees;

    public Employee(String name, Boolean leader, List<Employee> subEmployees) {

        super();
        this.name = name;
        this.leader = leader;
        this.subEmployees = subEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLeader() {
        return leader;
    }

    public void setLeader(Boolean leader) {
        this.leader = leader;
    }

    public List<Employee> getSubEmployees() {
        return subEmployees;
    }

    public void setSubEmployees(List<Employee> subEmployees) {
        this.subEmployees = subEmployees;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("name:" + name + "\n\r");
        builder.append("leader:" + (leader ? "yes" : "no") + "\n\r");
        if (!getLeader()) {
            return builder.toString();
        }

        builder.append("-------------------" + "\n\r");
        for (Employee e : subEmployees) {

            builder.append(e.toString());
        }
        builder.append("-------------------");

        return builder.toString();
    }

}
