import java.util.ArrayList;
import java.util.List;

public class FinalKeywordExamples  {

    public class Person {
        private final String name;

        public Person(String name) {
            this.name = name;
        }

        final void printName(){
            System.out.println(name);
        }
    }

    public class Student extends Person {

        private final double averageGrade;

        public Student(String name, double averageGrade) {
            super(name);
            this.averageGrade = averageGrade;
        }

//        @Override
//        void printName(){
           //any code
//        }

    }

    void aMethod(final List<String> list){
        //some logic
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        ImmutableClass immutableClass = new ImmutableClass(5, "hello", list);
        immutableClass.getList().add("world");
    }



}
