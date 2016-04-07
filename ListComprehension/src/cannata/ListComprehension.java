package cannata;

import java.util.*;

public class ListComprehension {
    public static void main(String[] args) {

        //list 1
        ArrayList<List<Object>> emp = new ArrayList<List<Object>>();
        List<Object> e1 = Arrays.asList(10, "JACKSON", "MARTA", "JACKSOMT", "27-FEB-91", "null", "Warehouse Manager", 1507, 0, 45, 2);
        List<Object> e2 = Arrays.asList(11, "HENDERSON", "COLIN", "HENDERCS", "14-MAY-90", "null", "Sales Representative", 1400, 10, 31, 3);
        List<Object> e3 = Arrays.asList(12,"Gilson","Sam","gilsonsj","18-Jan-92","null","Sales Representative",1490,12.5,32,3);
        List<Object> e4 = Arrays.asList(13,"Sanders","Jason","sanderjk","18-Feb-91","null","Sales Representative",1515,10,33,3);
        List<Object> e5 = Arrays.asList(14,"Dameron","Andre","dameroap","9-Oct-91","null","Sales Representative",1450,17.5,35,3);
        List<Object> e6 = Arrays.asList(15,"Hardwick","Elaine","hardwiem","7-Feb-92","null","Stock Clerk",1400,"null",41,6);
        List<Object> e7 = Arrays.asList(16,"Brown","George","browngw","8-Mar-90","null","Stock Clerk",940,"null",41,6);
        List<Object> e8 = Arrays.asList(17,"Washington","Thomas","washintl","9-Feb-91","null","Stock Clerk",1200,"null",42,7);
        List<Object> e9 = Arrays.asList(18,"Patterson","Donald","patterdv","6-Aug-91","null","Stock Clerk",795,"null",42,7);
        List<Object> e10 = Arrays.asList(19,"Bell","Alexander","bellag","26-May-91","null","Stock Clerk",850,"null",43,8);
        List<Object> e11 = Arrays.asList(2,"Smith","Doris","smithdj","8-Mar-90","null","VP Operations",2450,"null",41,1);
        List<Object> e12 = Arrays.asList(20,"Gantos","Eddie","gantosej","30-Nov-90","null","Stock Clerk",800,"null",44,9);
        List<Object> e13 = Arrays.asList(21,"Stephenson","Blaine","stephebs","17-Mar-91","null","Stock Clerk",860,"null",45,10);
        List<Object> e14 = Arrays.asList(22,"Chester","Eddie","chesteek","30-Nov-90","null","Stock Clerk",800,"null",44,9);
        List<Object> e15 = Arrays.asList(23,"Pearl","Roger","pearlrg","17-Oct-90","null","Stock Clerk",795,"null",34,9);
        List<Object> e16 = Arrays.asList(24,"Dancer","Bonnie","dancerbw","17-Mar-91","null","Stock Clerk",860,"null",45,7);
        List<Object> e17 = Arrays.asList(25,"Schmitt","Sandra","schmitss","9-May-91","null","Stock Clerk",1100,"null",45,8);
        List<Object> e18 = Arrays.asList(3,"Norton","Michael","nortonma","17-Jun-91","null","VP Sales",2400,"null",31,1);
        List<Object> e19 = Arrays.asList(4,"Quentin","Mark","quentiml","7-Apr-90","null","VP Finance",2450,"null",10,1);
        List<Object> e20 = Arrays.asList(5,"Roper","Joseph","roperjm","4-Mar-90","null","VP Administration",2550,"null",50,1);
        List<Object> e21 = Arrays.asList(6,"Brown","Molly","brownmr","18-Jan-91","null","Warehouse Manager",1600,"null",41,2);
        List<Object> e22 = Arrays.asList(7,"Hawkins","Roberta","hawkinrt","14-May-90","null","Warehouse Manager",1650,"null",42,2);
        List<Object> e23 = Arrays.asList(8,"Burns","Ben","burnsba","7-Apr-90","null","Warehouse Manager",1500,"null",43,2);

        emp.add(e1); emp.add(e2); emp.add(e3); emp.add(e4); emp.add(e5); emp.add(e6); emp.add(e7); emp.add(e8); emp.add(e9); emp.add(e10);
        emp.add(e11); emp.add(e12); emp.add(e13); emp.add(e14); emp.add(e15); emp.add(e16); emp.add(e17); emp.add(e18); emp.add(e19); emp.add(e20);
        emp.add(e21); emp.add(e22); emp.add(e23);

        //emp.stream()
          //      .forEach(e -> { System.out.println(e); });

        //
        // actual functions

        //#select * from s_dept;
        System.out.println();
        System.out.println("Print the entire list");
        System.out.println("SQL:SELECT * FROM emp");

        emp.stream()
                .forEach(System.out::println);


        //#select last_name, first_name, title, salary from s_emp where salary > 1500 and dept_id > 40;
        System.out.println();
        System.out.println("Print the list and informacion of everyone who makes over $1500 slary");
        System.out.println("SQL: SELECT * FROM emp WHERE sal > 1500");

        emp.stream()
                .filter(e -> (Integer)e.get(7) > 1500)
                .forEach(System.out::println);


        //#select last_name, first_name, title, salary from s_emp where salary > 1500 and dept_id > 40 order by last_name;
        System.out.println();
        System.out.println("Print only the salries that are over $1500");
        System.out.println("SQL: SELECT sal FROM emp WHERE sal > 1500");

        emp.stream()
                .filter(e -> (Integer)e.get(7) > 1500)
                .map(e -> (Integer)e.get(7))
                .sorted()
                .forEach(System.out::println);


        //#select last_name, first_name, title, salary from s_emp where salary > 1500 and dept_id > 40 order by salary desc;
        System.out.println();
        System.out.println("Print a list of sales representative slaries that are over $1500");
        System.out.println("SQL: SELECT sal FROM emp WHERE sal > 1500, title = 'Sales Representative'");

        emp.stream()
                .filter(e -> e.get(6).equals("Sales Representative") && (Integer)e.get(7) > 1500)
                .map(e -> (Integer)e.get(7))
                .sorted()
                .forEach(System.out::println);


        // ghjkhkfkuyfouygolugoutiytfyrei6rf
        System.out.println();
        System.out.println("Print a list of sales representative slaries that are over $1500");
        System.out.println("SQL: SELECT sal FROM emp WHERE sal < 1000, title = 'Stock Clerk'");

        emp.stream()
                .filter(e -> e.get(6).equals("Stock Clerk") && (Integer)e.get(7) < 1000)
                .map(e -> (Integer)e.get(7))
                .sorted()
                .forEach(System.out::println);

    }
}

