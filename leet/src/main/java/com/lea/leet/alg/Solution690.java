package com.lea.leet.alg;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution690 {

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = employees
                .stream()
                .collect(Collectors.toMap(it -> it.id, Function.identity()));

        Employee employee = map.get(id);

        LinkedList<Employee> stack = new LinkedList<>();
        stack.push(employee);
        int sum = 0;
        while (!stack.isEmpty()) {

            Employee tmp = stack.pop();
            sum += tmp.importance;
            for(int subId : tmp.subordinates){
                stack.push(map.get(subId));
            }

        }

        return sum;
    }


    public static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}


