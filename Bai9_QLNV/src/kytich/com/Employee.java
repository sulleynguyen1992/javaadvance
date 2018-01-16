/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com;

/**
 *
 * @author sulleynguyen
 */
public class Employee implements Comparable<Employee> {

    private int codeId;
    private String name;

    public Employee() {
        super();
    }

    public Employee(int codeId, String name) {
        this.codeId = codeId;
        this.name = name;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        int compareName = this.name.compareToIgnoreCase(o.getName());
        if(compareName == 0)
        {
            if(this.codeId == o.codeId)
                return 0;
            if(this.codeId > o.codeId)
                return -1;
            return 1;
        }
        return compareName;
    }

}
