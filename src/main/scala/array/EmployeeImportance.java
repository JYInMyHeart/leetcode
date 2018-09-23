package array;


import java.util.List;

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        List<Integer> subEmployees = null;
        for(Employee e:employees){
            if(id == e.id){
                ans = e.importance;
                subEmployees = e.subordinates;
                break;
            }
        }

        if(subEmployees == null) return 0;

        for(int i:subEmployees){
            ans += getImportance(employees,i);
        }
        return ans;
    }





    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}

