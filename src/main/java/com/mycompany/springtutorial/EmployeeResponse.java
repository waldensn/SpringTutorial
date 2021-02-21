
package com.mycompany.springtutorial;

import java.util.List;


public class EmployeeResponse {

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the emps
     */
    public List<Employee> getEmps() {
        return emps;
    }

    /**
     * @param emps the emps to set
     */
    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }
    
    private boolean success;
    private int count;
    private List<Employee> emps;
}
