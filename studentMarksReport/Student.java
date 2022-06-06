package studentMarksReport;
import javax.swing.*;
public abstract class Student 
{
    //Instance variables
    private static int studentNo;
    private static int  testResult;
    private static int assignmentResult;
    private static int examResult;

    //Student Constructor method
    public Student(int studentNo, int testResult, int assignmentResult, int examResult) {
        this.studentNo = studentNo;
        this.testResult = testResult;
        this.assignmentResult = assignmentResult;
        this.examResult = examResult;
    }
    //getter methods
    public static int getStudentNo() {
        return studentNo;
    }

    public static int getTestResult() {
        return testResult;
    }

    public static int getAssignmentResult() {
        return assignmentResult;
    }

    public static int getExamResult() {
        return examResult;
    }
   
}//End of Student class

class Student_Report extends Student
{
    //Student_Report constructor
    public Student_Report(int studentNo, int testResult, int assignmentResult, int examResult) 
    {
        super(studentNo, testResult, assignmentResult, examResult);
    }
    
    //Student_Report Getter methods
    //@Override
    public static int getExamResult() 
    {
        int examResult = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Exam Mark "));
    
        while ((examResult > 100) || (examResult < 0)) //loop to ensure user enters proper mark
        {   
                String m = "The mark has to be between 0 and 100!";
                JOptionPane.showMessageDialog(null, m);
                examResult = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Exam Mark "));
        }  return examResult;
    }

    //@Override
    public static int getAssignmentResult() {
        int assignmentResult = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Assignment Mark "));
    
        while ((assignmentResult > 100) || (assignmentResult < 0)) //loop to ensure user enters proper mark
        {   
                String m = "The mark has to be between 0 and 100!";
                JOptionPane.showMessageDialog(null, m);
                assignmentResult = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Assignment Mark "));
        }  return assignmentResult;
    }

   // @Override
    public static int getTestResult() 
    {
        int testResult = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Test Mark "));
    
        while ((testResult > 100) || (testResult < 0)) //loop to ensure user enters proper mark
        {   
                String m = "The mark has to be between 0 and 100!";
                JOptionPane.showMessageDialog(null, m);
                testResult = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Test Mark "));
        }  return testResult;
        
    }

    
    // @Override
public static int getStudentNo()
    {
    int studentNo = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Student Number "));

        while ((studentNo > 99999) || (studentNo < 10000)) //loop to ensure user enters proper mark
        {   
                String m = "Student number must have 5 digits";
                JOptionPane.showMessageDialog(null, m);
                studentNo = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Student Number"));
        }  return studentNo;
    }
    
    //Main method
    public static void main(String[] args) 
    {
        //Local variables declaration
        Integer studentNo =0;
        int testResult =0;
        int assignmentResult = 0;
        int examResult =0;
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        
        //String variables i'll use to compare to the letters variables to test if user entered strings or integers
        String studentNoStr="";
        String testResultStr = "";
        String assignmentResultStr = "";
        String examResultStr = "";
        
        
        
        do 
        {
            try { //Exception handling for incorrect user input
             studentNo = Student_Report.getStudentNo();
             studentNoStr = String.valueOf(studentNo);//Converting variable to strings to compare them to letters variable.
             
             testResult = Student_Report.getTestResult();
             testResultStr = String.valueOf(testResult);//Converting variable to strings to compare them to letters variable.
             
             assignmentResult = Student_Report.getAssignmentResult();
             assignmentResultStr = String.valueOf(assignmentResult);//Converting variable to strings to compare them to letters variable.
             
             examResult = Student_Report.getExamResult();
             examResultStr = String.valueOf(examResult);//Converting variable to strings to compare them to letters variable.
             
            JOptionPane.showMessageDialog(null,Student_Report.print_report(studentNo,testResult,assignmentResult,examResult));
            break;
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Enter numbers only.\n The program will now restart");
        }
        } while //loop will continue as long as user enters strings instead of integers
        (
           !studentNoStr.contains(letters) || 
           !testResultStr.contains(letters) ||
           !assignmentResultStr.contains(letters) ||
           !examResultStr.contains(letters)
        );
            
        
       
    }
    //Print_report method
    public static String print_report(int studentNo,int testResults,int assignmentResults,int examResults)
    {
        double test = (double)testResults /100 * 25; //test calculation
        
        double assignment = (double)assignmentResults /100 * 25; //assignment calculation
        
        double exam = (double)examResults /100 * 50; //exam calculation
        
        //Variable that returns all the calculated percentages and student number:
        String report = "Student number: "+studentNo+"\n"+
                "Student got: "+test+"% of 25% for test"+"\n"+
                "Student got: "+assignment+"% of 25% for assignment"+"\n"+
                "Student got: "+exam+"% of 50% for exam"+"\n";
        return report;        
    }
}


