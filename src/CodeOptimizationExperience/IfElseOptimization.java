package CodeOptimizationExperience;

import java.util.Optional;

public class IfElseOptimization {

	public static void main(String[] args) {
		 // creepy initialization step, dont worry
        Employee employee = new Employee();

        // 优化前
        if(employee != null){
            Salary salary = employee.getSalary();
            if(salary != null){
                Unit unit = salary.getUnit();
                if(unit != null){
                    System.out.println("I discovered the variable finally " + unit);
                }
            }
        }
        // 优化后,使用了Optional能大大消去空指针异常
        Optional.ofNullable(employee)
                .map(Employee::getSalary)
                .map(Salary::getUnit)
                .map(Unit::getPrecision)
                .ifPresent(e -> System.out.println("I discovered the variable finally " + e));

	}

	static class Employee {

        Salary salary;

        public Salary getSalary() {
            return salary;
        }

        public void setSalary(Salary salary) {
            this.salary = salary;
        }
    }

    class Salary {
        // 单位
        Unit unit;

        public Unit getUnit() {
            return unit;
        }

        public void setUnit(Unit unit) {
            this.unit = unit;
        }
    }

    class Unit {
        // 精度
        Integer precision;

        public Integer getPrecision() {
            return precision;
        }

        public void setPrecision(Integer precision) {
            this.precision = precision;
        }
    }
}
